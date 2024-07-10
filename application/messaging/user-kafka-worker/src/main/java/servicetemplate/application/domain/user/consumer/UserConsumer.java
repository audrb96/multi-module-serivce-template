package servicetemplate.application.domain.user.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import servicetemplate.application.annotation.Consumer;
import servicetemplate.application.common.util.JsonUtil;
import servicetemplate.application.domain.user.consumer.dto.CreateUserEvent;
import servicetemplate.application.domain.user.service.UserService;
import servicetemplate.logger.JsonLogger;
import servicetemplate.logger.SystemLogger;

@Consumer
public class UserConsumer {

	private final UserService userService;
	private final SystemLogger logger = new JsonLogger(this.getClass());

	public UserConsumer(UserService userService) {
		this.userService = userService;
	}

	@KafkaListener(
		topics = {"${kafka.consumer.topic.login-user}"}
	)
	public void consume(
		ConsumerRecord<String, String> record,
		Acknowledgment acknowledgment,
		@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
	) {
		acknowledgment.acknowledge();
		CreateUserEvent event = JsonUtil.convertToObject(record.value(), CreateUserEvent.class);
		logger.logEvent(event, topic);
		userService.create(event.toCommand());
	}
}
