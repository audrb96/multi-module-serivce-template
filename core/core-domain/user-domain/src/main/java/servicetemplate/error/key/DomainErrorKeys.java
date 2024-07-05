package servicetemplate.error.key;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomainErrorKeys {

	private final List<DomainErrorKey> keys;

	public DomainErrorKeys(List<DomainErrorKey> keys) {
		this.keys = keys;
	}

	public static DomainErrorKeys of(DomainErrorKey... keys) {
		return new DomainErrorKeys(new ArrayList<>(Arrays.asList(keys)));
	}

	public List<DomainErrorKey> getKeys() {
		return List.copyOf(this.keys);
	}
}
