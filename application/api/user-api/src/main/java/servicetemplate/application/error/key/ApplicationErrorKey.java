package servicetemplate.application.error.key;

public class ApplicationErrorKey {

	private final String name;

	private final String value;

	public ApplicationErrorKey(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
