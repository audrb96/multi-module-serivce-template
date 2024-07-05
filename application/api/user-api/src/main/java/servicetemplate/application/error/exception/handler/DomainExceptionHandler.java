package servicetemplate.application.error.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.factory.ResponseEntityFactory;
import servicetemplate.error.exception.NotFoundDomainException;

@ControllerAdvice
public class DomainExceptionHandler {

	@ExceptionHandler(NotFoundDomainException.class)
	public ResponseEntity<ErrorResponse> handle(NotFoundDomainException exception) {

		return ResponseEntityFactory.notFound(exception);
	}
}
