package servicetemplate.application.error.key;

import servicetemplate.key.Key;

public class ApplicationErrorKey implements Key {

	private final String name;

	private final String value;

	public ApplicationErrorKey(String name, String value) {
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
