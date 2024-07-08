package servicetemplate.error.exception;

import servicetemplate.error.code.ErrorCode;
import servicetemplate.key.Key;

import java.util.List;

public class CommonException extends RuntimeException {

	private final ErrorCode code;

	private final List<Key> keys;

	public CommonException(ErrorCode code, List<Key> keys) {
		super(code.getMessage());
		this.code = code;
		this.keys = keys;
	}

	public ErrorCode getCode() {
		return code;
	}

	public List<Key> getKeys() {
		return keys;
	}
}
