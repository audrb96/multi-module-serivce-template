package servicetemplate.application.error.exception.handler.implement;

import io.micrometer.tracing.Tracer;
import servicetemplate.application.annotation.KafkaExceptionHandler;
import servicetemplate.application.common.component.clockholder.ClockHolder;
import servicetemplate.application.error.exception.handler.ExceptionHandler;
import servicetemplate.dto.event.Event;
import servicetemplate.error.exception.CommonException;
import servicetemplate.support.deadletter.DeadLetterSender;
import servicetemplate.support.deadletter.dto.DeadLetter;
import servicetemplate.support.deadletter.factory.DeadLetterFactory;
import servicetemplate.support.logger.JsonLogger;
import servicetemplate.support.logger.SystemLogger;

@KafkaExceptionHandler
public class CommonExceptionHandler implements ExceptionHandler {

	private final DeadLetterSender deadLetterSender;
	private final ClockHolder clockHolder;
	private final Tracer tracer;
	private final SystemLogger logger = new JsonLogger(this.getClass());

	public CommonExceptionHandler(DeadLetterSender deadLetterSender, ClockHolder clockHolder, Tracer tracer) {
		this.deadLetterSender = deadLetterSender;
		this.clockHolder = clockHolder;
		this.tracer = tracer;
	}

	@Override
	public Class<? extends RuntimeException> getExceptionClass() {
		return CommonException.class;
	}

	public void handle(Event event, Exception exception) {
		CommonException commonException = (CommonException) exception;
		DeadLetter deadLetter = DeadLetterFactory.create(
			clockHolder.getCurrentTime(),
			commonException,
			tracer.currentSpan().context().spanId(),
			tracer.currentSpan().context().traceId()
		);
		
		logger.logException(commonException);
		deadLetterSender.send(deadLetter);
	}
}