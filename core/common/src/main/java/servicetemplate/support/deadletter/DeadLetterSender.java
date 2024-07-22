package servicetemplate.support.deadletter;

import servicetemplate.support.deadletter.dto.DeadLetter;

public interface DeadLetterSender {

	void send(DeadLetter deadLetter);
}
