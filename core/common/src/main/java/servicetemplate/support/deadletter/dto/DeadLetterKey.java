package servicetemplate.support.deadletter.dto;

import servicetemplate.dto.key.Key;

public class DeadLetterKey implements Key {

	private final String name;

	private final String value;

	public DeadLetterKey(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public String toString() {
		return String.format("[%s] %s", this.name, this.value);
	}
}
