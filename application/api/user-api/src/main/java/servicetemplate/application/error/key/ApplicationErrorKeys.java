package servicetemplate.application.error.key;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationErrorKeys {

	private final List<ApplicationErrorKey> keys;

	public ApplicationErrorKeys(List<ApplicationErrorKey> keys) {
		this.keys = keys;
	}

	public static ApplicationErrorKeys of(ApplicationErrorKey... keys) {
		return new ApplicationErrorKeys(new ArrayList<>(Arrays.asList(keys)));
	}

	public List<ApplicationErrorKey> getKeys() {
		return List.copyOf(this.keys);
	}
}
