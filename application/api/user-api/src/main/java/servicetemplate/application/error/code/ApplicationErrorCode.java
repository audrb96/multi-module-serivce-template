package servicetemplate.application.error.code;

public enum ApplicationErrorCode {

	RUNTIME_ERROR(1000, "런타임 에러");

	private final int code;
	private final String message;

	ApplicationErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
