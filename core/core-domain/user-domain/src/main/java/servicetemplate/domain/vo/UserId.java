package servicetemplate.domain.vo;

public record UserId(Long id) {

	public static UserId empty() {
		return new UserId(null);
	}
}
