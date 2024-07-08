package servicetemplate.application.error.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.exception.ApplicationException;
import servicetemplate.application.error.factory.ResponseEntityFactory;
import servicetemplate.logger.JsonLogger;
import servicetemplate.logger.SystemLogger;

@ControllerAdvice
public class ApplicationExceptionHandler {

	private final SystemLogger logger = new JsonLogger(this.getClass());

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handle(ApplicationException exception) {
		logger.logException(exception);

		return ResponseEntityFactory.badRequest(exception);
	}
}
