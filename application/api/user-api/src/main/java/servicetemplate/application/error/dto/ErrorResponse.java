package servicetemplate.application.error.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import servicetemplate.error.exception.CommonException;
import servicetemplate.key.Key;

import java.util.Collections;
import java.util.List;

import static servicetemplate.application.error.code.ApplicationErrorCode.RUNTIME_ERROR;

public class ErrorResponse {

	private final int code;

	private final String name;

	private final String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<Key> errorKeys;

	public ErrorResponse(int code, String name, String message, List<Key> errorKeys) {
		this.code = code;
		this.name = name;
		this.message = message;
		this.errorKeys = errorKeys;
	}

	public static ErrorResponse from(RuntimeException exception) {
		return new ErrorResponse(RUNTIME_ERROR.getCode(), RUNTIME_ERROR.name(), exception.getMessage(), Collections.emptyList());
	}

	public static ErrorResponse from(CommonException exception) {
		return new ErrorResponse(exception.getCode().getCode(), exception.getCode().name(), exception.getMessage(), exception.getKeys());
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public List<Key> getErrorKeys() {
		return errorKeys;
	}
}
