package servicetemplate.deadletter.kafka;

import com.muhayu.constant.Topics;
import com.muhayu.message.DeadLetter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import servicetemplate.deadletter.DeadLetterSender;

@Component
public class KafkaDeadLetterSender implements DeadLetterSender {

	private final KafkaTemplate<String, DeadLetter> deadLetterTemplate;

	@Value("${spring.application.name}")
	private String appName;

	public KafkaDeadLetterSender(KafkaTemplate<String, DeadLetter> deadLetterTemplate) {
		this.deadLetterTemplate = deadLetterTemplate;
	}

	@Override
	public void send(DeadLetter deadLetter) {
		deadLetter.setAppName(appName);
		deadLetterTemplate.send(Topics.DEAD_LETTER, deadLetter);
	}
}
