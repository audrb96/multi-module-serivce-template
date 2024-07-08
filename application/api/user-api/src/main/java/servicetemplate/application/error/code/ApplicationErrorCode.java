package servicetemplate.application.error.code;

import servicetemplate.error.code.ErrorCode;

public enum ApplicationErrorCode implements ErrorCode {

	RUNTIME_ERROR(1000, "런타임 에러"),
	CANNOT_CREATE_USER_EXIST_NAME(1001, "존재하는 이름의 사용자는 생성할 수 없습니다.");

	private final int code;
	private final String message;

	ApplicationErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
