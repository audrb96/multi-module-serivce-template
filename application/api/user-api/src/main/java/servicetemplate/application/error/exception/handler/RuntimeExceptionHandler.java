package servicetemplate.application.error.exception.handler;

import com.muhayu.message.DeadLetter;
import io.micrometer.tracing.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.common.component.clockholder.ClockHolder;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.factory.ResponseEntityFactory;
import servicetemplate.deadletter.DeadLetterSender;
import servicetemplate.deadletter.factory.DeadLetterFactory;
import servicetemplate.logger.JsonLogger;
import servicetemplate.logger.SystemLogger;

@ControllerAdvice
public class RuntimeExceptionHandler {

	private final SystemLogger logger = new JsonLogger(this.getClass());

	private final DeadLetterSender deadLetterSender;
	private final Tracer tracer;
	private final ClockHolder clockHolder;

	public RuntimeExceptionHandler(DeadLetterSender deadLetterSender, Tracer tracer, ClockHolder clockHolder) {
		this.deadLetterSender = deadLetterSender;
		this.tracer = tracer;
		this.clockHolder = clockHolder;
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handle(RuntimeException exception) {
		DeadLetter deadLetter = DeadLetterFactory.create(
			clockHolder.getCurrentTime(),
			exception,
			tracer.currentSpan().toString(),
			tracer.currentSpan().context().traceId()
		);
		deadLetterSender.send(deadLetter);
		
		logger.logException(exception);

		return ResponseEntityFactory.internalServerError(exception);
	}
}
