package servicetemplate.application.error.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.factory.ResponseEntityFactory;
import servicetemplate.logger.JsonLogger;
import servicetemplate.logger.SystemLogger;

@ControllerAdvice
public class RuntimeExceptionHandler {

	private final SystemLogger logger = new JsonLogger(this.getClass());

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handle(RuntimeException exception) {
		logger.logException(exception);

		return ResponseEntityFactory.internalServerError(exception);
	}
}
