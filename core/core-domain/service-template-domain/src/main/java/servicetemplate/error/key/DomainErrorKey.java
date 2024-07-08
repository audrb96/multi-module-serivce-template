package servicetemplate.error.key;

import servicetemplate.key.Key;

public class DomainErrorKey implements Key {

	private final String name;

	private final String value;

	public DomainErrorKey(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}
}
