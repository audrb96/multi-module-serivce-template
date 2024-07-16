package servicetemplate.support.deadletter.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class DeadLetter {

	private final String appName;

	private final List<DeadLetterKey> keys;

	public DeadLetter() {
		this.appName = null;
		this.keys = Collections.EMPTY_LIST;
	}

	private DeadLetter(String appName, List<DeadLetterKey> keys) {
		this.appName = appName;
		this.keys = keys;
	}

	public DeadLetter append(DeadLetterKey key) {
		ArrayList<DeadLetterKey> copyKeys = new ArrayList<>(this.keys);
		copyKeys.add(key);

		return new DeadLetter(this.appName, List.copyOf(copyKeys));
	}

	public DeadLetter withAppName(String appName) {
		return new DeadLetter(appName, this.keys);
	}

	public String toPrettyMessage() {
		StringJoiner stringJoiner = new StringJoiner("\n");
		stringJoiner.add("---------------" + this.appName + "---------------");
		this.keys.stream().map(DeadLetterKey::toString).forEach(stringJoiner::add);

		return stringJoiner.toString();
	}
}
