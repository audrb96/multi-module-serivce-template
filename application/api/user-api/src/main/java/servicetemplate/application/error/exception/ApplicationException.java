package servicetemplate.application.error.exception;

import servicetemplate.application.error.code.ApplicationErrorCode;
import servicetemplate.application.error.key.ApplicationErrorKeys;

public class ApplicationException extends RuntimeException {

	private final ApplicationErrorCode code;

	private final ApplicationErrorKeys keys;

	public ApplicationException(ApplicationErrorCode code, ApplicationErrorKeys keys) {
		super(code.getMessage());
		this.code = code;
		this.keys = keys;
	}

	public ApplicationErrorCode getCode() {
		return code;
	}

	public ApplicationErrorKeys getKeys() {
		return keys;
	}
}
