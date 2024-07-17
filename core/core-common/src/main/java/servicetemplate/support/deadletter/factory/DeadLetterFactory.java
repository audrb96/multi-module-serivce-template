package servicetemplate.support.deadletter.factory;


import servicetemplate.dto.key.Key;
import servicetemplate.error.exception.CommonException;
import servicetemplate.support.deadletter.dto.DeadLetter;
import servicetemplate.support.deadletter.dto.DeadLetterKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DeadLetterFactory {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DeadLetterFactory() {
		throw new UnsupportedOperationException(this.getClass().getName() + "의 인스턴스는 생성되어서 안됩니다.");
	}

	public static DeadLetter create(LocalDateTime incidentAt, CommonException exception, String spanId, String traceId) {
		DeadLetter deadLetter = new DeadLetter()
			.append(new DeadLetterKey("incident time", incidentAt.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))))
			.append(new DeadLetterKey("spanId", spanId))
			.append(new DeadLetterKey("traceId", traceId));

		for (Key key : exception.getKeys()) {
			deadLetter = deadLetter.append(new DeadLetterKey(key.getName(), key.getValue()));
		}

		return deadLetter.append(new DeadLetterKey("message", exception.getMessage()));
	}

	public static DeadLetter create(LocalDateTime incidentAt, Exception exception, String spanId, String traceId) {
		DeadLetter deadLetter = new DeadLetter()
			.append(new DeadLetterKey("incident time", incidentAt.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))))
			.append(new DeadLetterKey("spanId", spanId))
			.append(new DeadLetterKey("traceId", traceId));

		return deadLetter.append(new DeadLetterKey("message", exception.getMessage()));
	}
}
