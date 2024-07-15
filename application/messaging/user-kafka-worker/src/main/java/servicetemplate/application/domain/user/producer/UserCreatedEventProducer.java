package servicetemplate.application.domain.user.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import servicetemplate.application.annotation.Producer;
import servicetemplate.dto.event.Event;

@Producer
public class UserCreatedEventProducer {

	private final KafkaTemplate<String, Event> kafkaTemplate;
	private final String topic;

	public UserCreatedEventProducer(
		KafkaTemplate<String, Event> kafkaTemplate,
		@Value("${kafka.producer.topic.user-created}") String topic
	) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	public void send(Event event) {
		kafkaTemplate.send(topic, event);
	}
}
