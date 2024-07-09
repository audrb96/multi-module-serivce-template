package servicetemplate.application.error.factory;

import org.springframework.http.ResponseEntity;
import servicetemplate.application.error.dto.ErrorResponse;
import servicetemplate.application.error.exception.ApplicationException;
import servicetemplate.error.exception.NotFoundDomainException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public final class ResponseEntityFactory {

	public ResponseEntityFactory() {
		throw new UnsupportedOperationException(this.getClass().getName() + "의 인스턴스는 생성되어서 안됩니다.");
	}

	public static ResponseEntity<ErrorResponse> internalServerError(RuntimeException exception) {
		return ResponseEntity.internalServerError()
			.body(ErrorResponse.from(exception));
	}

	public static ResponseEntity<ErrorResponse> badRequest(ApplicationException exception) {
		return ResponseEntity.badRequest()
			.body(ErrorResponse.from(exception));
	}

	public static ResponseEntity<ErrorResponse> notFound(NotFoundDomainException exception) {
		return ResponseEntity
			.status(NOT_FOUND)
			.body(ErrorResponse.from(exception));
	}
}
