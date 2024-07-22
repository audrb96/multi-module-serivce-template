package servicetemplate.support.deadletter.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import servicetemplate.client.GoogleChatClient;
import servicetemplate.client.dto.GoogleChatMessage;
import servicetemplate.support.deadletter.DeadLetterSender;
import servicetemplate.support.deadletter.dto.DeadLetter;

@Component
public class GoogleChatDeadLetterSender implements DeadLetterSender {

	private final GoogleChatClient client;

	private final String appName;


	public GoogleChatDeadLetterSender(GoogleChatClient client, @Value("${spring.application.name}") String appName) {
		this.client = client;
		this.appName = appName;
	}

	@Override
	public void send(DeadLetter deadLetter) {
		client.sendMessage(new GoogleChatMessage(deadLetter.withAppName(appName).toPrettyMessage()));
	}
}
