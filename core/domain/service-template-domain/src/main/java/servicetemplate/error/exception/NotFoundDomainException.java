package servicetemplate.error.exception;

import servicetemplate.domain.user.vo.UserId;
import servicetemplate.error.code.DomainErrorCode;
import servicetemplate.error.key.DomainErrorKey;

import java.util.List;

import static servicetemplate.error.code.DomainErrorCode.NOT_FOUND_USER;

public class NotFoundDomainException extends DomainException {

	private static final String ERROR_KEY_USER_ID = "userId";

	public NotFoundDomainException(DomainErrorCode code, List<DomainErrorKey> keys) {
		super(code, keys);
	}


	public static NotFoundDomainException user(UserId userId) {
		return new NotFoundDomainException(
			NOT_FOUND_USER,
			List.of(new DomainErrorKey(ERROR_KEY_USER_ID, userId.id().toString()))
		);
	}
}
