package servicetemplate.application.error.exception.handler.implement;

import io.micrometer.tracing.Tracer;
import servicetemplate.application.annotation.KafkaExceptionHandler;
import servicetemplate.application.common.component.clockholder.ClockHolder;
import servicetemplate.application.error.exception.handler.ExceptionHandler;
import servicetemplate.dto.event.Event;
import servicetemplate.support.deadletter.DeadLetterSender;
import servicetemplate.support.deadletter.dto.DeadLetter;
import servicetemplate.support.deadletter.factory.DeadLetterFactory;
import servicetemplate.support.logger.JsonLogger;
import servicetemplate.support.logger.SystemLogger;

@KafkaExceptionHandler
public class RuntimeExceptionHandler implements ExceptionHandler {

	private final DeadLetterSender deadLetterSender;
	private final ClockHolder clockHolder;
	private final Tracer tracer;
	private final SystemLogger logger = new JsonLogger(this.getClass());


	public RuntimeExceptionHandler(DeadLetterSender deadLetterSender, ClockHolder clockHolder, Tracer tracer) {
		this.deadLetterSender = deadLetterSender;
		this.clockHolder = clockHolder;
		this.tracer = tracer;
	}

	@Override
	public Class<? extends RuntimeException> getExceptionClass() {
		return RuntimeException.class;
	}

	@Override
	public void handle(Event event, Exception exception) {
		DeadLetter deadLetter = DeadLetterFactory.create(
			clockHolder.getCurrentTime(),
			exception,
			tracer.currentSpan().context().spanId(),
			tracer.currentSpan().context().traceId()
		);

		logger.logException(exception);
		deadLetterSender.send(deadLetter);
	}
}
