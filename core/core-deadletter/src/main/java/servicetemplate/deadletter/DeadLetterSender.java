package servicetemplate.deadletter;

import com.muhayu.message.DeadLetter;

public interface DeadLetterSender {

	void send(DeadLetter deadLetter);
}
