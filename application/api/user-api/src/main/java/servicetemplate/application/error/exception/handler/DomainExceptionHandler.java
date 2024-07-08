package servicetemplate.application.error.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.factory.ResponseEntityFactory;
import servicetemplate.error.exception.NotFoundDomainException;
import servicetemplate.logger.JsonLogger;
import servicetemplate.logger.SystemLogger;

@ControllerAdvice
public class DomainExceptionHandler {

	private final SystemLogger logger = new JsonLogger(this.getClass());

	@ExceptionHandler(NotFoundDomainException.class)
	public ResponseEntity<ErrorResponse> handle(NotFoundDomainException exception) {
		logger.logException(exception);

		return ResponseEntityFactory.notFound(exception);
	}
}
