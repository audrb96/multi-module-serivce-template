package servicetemplate.deadletter.factory;

import com.muhayu.message.DeadLetter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DeadLetterFactory {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DeadLetterFactory() {
		throw new UnsupportedOperationException(this.getClass() + "의 인스턴스는 생성되어서 안됩니다.");
	}

	public static DeadLetter create(LocalDateTime incidentAt, Exception exception, String spanId, String traceId) {
		DeadLetter deadLetter = new DeadLetter();
		deadLetter
			.append("incident time", incidentAt.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
			.append("spanId", spanId)
			.append("traceId", traceId)
			.append("message", exception.getMessage());
		
		return deadLetter;
	}
}
