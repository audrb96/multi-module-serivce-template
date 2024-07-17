package servicetemplate.application.domain.user.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import servicetemplate.application.annotation.Consumer;
import servicetemplate.application.common.util.JsonUtil;
import servicetemplate.application.domain.user.consumer.dto.UserCreatedEvent;
import servicetemplate.support.logger.JsonLogger;
import servicetemplate.support.logger.SystemLogger;

@Consumer
public class TestConsumer {

	private final SystemLogger logger = new JsonLogger(this.getClass());


	@KafkaListener(
		topics = {"${kafka.producer.topic.user-created}"}
	)
	public void consume(
		ConsumerRecord<String, String> record,
		@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
	) {
		UserCreatedEvent event = JsonUtil.convertToObject(record.value(), UserCreatedEvent.class);
		logger.logEvent(event, topic);
	}
}
