package servicetemplate.application.error.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.exception.ApplicationException;
import servicetemplate.application.error.factory.ResponseEntityFactory;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handle(ApplicationException exception) {

		return ResponseEntityFactory.badRequest(exception);
	}
}
