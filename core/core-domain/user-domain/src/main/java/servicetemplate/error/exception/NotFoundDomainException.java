package servicetemplate.error.exception;

import servicetemplate.domain.user.vo.UserId;
import servicetemplate.error.code.DomainErrorCode;
import servicetemplate.error.key.DomainErrorKey;
import servicetemplate.error.key.DomainErrorKeys;

import static servicetemplate.error.code.DomainErrorCode.NOT_FOUND_USER;

public class NotFoundDomainException extends DomainException {

	public NotFoundDomainException(DomainErrorCode code, DomainErrorKeys keys) {
		super(code, keys);
	}

	public static NotFoundDomainException user(UserId userId) {
		return new NotFoundDomainException(
			NOT_FOUND_USER,
			DomainErrorKeys.of(
				new DomainErrorKey("userId", userId.id().toString())
			)
		);
	}
}
