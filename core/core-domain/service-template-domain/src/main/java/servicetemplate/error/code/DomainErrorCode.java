package servicetemplate.error.code;

public enum DomainErrorCode {

	NOT_FOUND_USER(2001, "사용자를 찾을 수 없습니다.");

	private final int code;

	private final String message;

	DomainErrorCode(int code, String message) {
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
