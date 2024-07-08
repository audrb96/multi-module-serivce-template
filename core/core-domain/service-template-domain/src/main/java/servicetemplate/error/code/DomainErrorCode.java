package servicetemplate.error.code;

public enum DomainErrorCode implements ErrorCode {

	NOT_FOUND_USER(2001, "사용자를 찾을 수 없습니다.");

	private final int code;

	private final String message;

	DomainErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
