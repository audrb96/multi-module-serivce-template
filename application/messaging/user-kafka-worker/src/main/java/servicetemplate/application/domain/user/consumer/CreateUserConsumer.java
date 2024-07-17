package servicetemplate.application.domain.user.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.transaction.annotation.Transactional;
import servicetemplate.application.annotation.Consumer;
import servicetemplate.application.common.util.JsonUtil;
import servicetemplate.application.domain.user.consumer.dto.CreateUserEvent;
import servicetemplate.application.domain.user.consumer.dto.UserCreatedEvent;
import servicetemplate.application.domain.user.producer.UserCreatedEventProducer;
import servicetemplate.application.domain.user.service.UserService;
import servicetemplate.domain.user.User;
import servicetemplate.support.logger.JsonLogger;
import servicetemplate.support.logger.SystemLogger;

@Consumer
public class CreateUserConsumer {

	private final UserService userService;
	private final UserCreatedEventProducer userCreatedEventProducer;
	private final SystemLogger logger = new JsonLogger(this.getClass());

	public CreateUserConsumer(UserService userService, UserCreatedEventProducer userCreatedEventProducer) {
		this.userService = userService;
		this.userCreatedEventProducer = userCreatedEventProducer;
	}

	@Transactional("kafkaTransactionManager")
	@KafkaListener(
		topics = {"${kafka.consumer.topic.login-user}"},
		errorHandler = "handleCreateUser"
	)
	public void consume(
		ConsumerRecord<String, String> record,
		@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
	) {
		CreateUserEvent event = JsonUtil.convertToObject(record.value(), CreateUserEvent.class);
		logger.logEvent(event, topic);
		User createdUser = userService.create(event.toCommand());

		userCreatedEventProducer.send(UserCreatedEvent.from(createdUser));
	}
}
