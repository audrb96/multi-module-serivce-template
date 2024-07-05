package servicetemplate.error.exception;

import servicetemplate.error.code.DomainErrorCode;
import servicetemplate.error.key.DomainErrorKeys;

public class DomainException extends RuntimeException {

	private final DomainErrorCode code;

	private final DomainErrorKeys keys;

	public DomainException(DomainErrorCode code, DomainErrorKeys keys) {
		super(code.getMessage());
		this.code = code;
		this.keys = keys;
	}

	public DomainErrorCode getCode() {
		return code;
	}

	public DomainErrorKeys getKeys() {
		return keys;
	}
}
