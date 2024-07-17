package servicetemplate.application.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.MicrometerConsumerListener;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

	private final KafkaProperties kafkaProperties;
	private final MeterRegistry meterRegistry;

	public KafkaConsumerConfig(KafkaProperties kafkaProperties, MeterRegistry meterRegistry) {
		this.kafkaProperties = kafkaProperties;
		this.meterRegistry = meterRegistry;
	}

	@SuppressWarnings("resource")
	@Bean
	public Map<String, Object> consumerConfigs(SslBundles sslBundles) {
		Map<String, Object> props = new HashMap<>(kafkaProperties.buildConsumerProperties(sslBundles));
		props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, CooperativeStickyAssignor.class.getName());

		return props;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory(SslBundles sslBundles) {
		ConsumerFactory<String, String> factory = new DefaultKafkaConsumerFactory<>(consumerConfigs(sslBundles));
		factory.addListener(new MicrometerConsumerListener<>(meterRegistry)); // adds native Kafka consumer metrics
		
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(SslBundles sslBundles) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.getContainerProperties().setObservationEnabled(true);
		factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
		factory.setConsumerFactory(consumerFactory(sslBundles));

		return factory;
	}
}
