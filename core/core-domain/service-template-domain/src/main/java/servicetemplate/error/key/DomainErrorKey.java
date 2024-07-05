package servicetemplate.error.key;

public class DomainErrorKey {

	private final String name;

	private final String value;

	public DomainErrorKey(String name, String value) {
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
