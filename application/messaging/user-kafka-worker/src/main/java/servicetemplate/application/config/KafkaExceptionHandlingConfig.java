package servicetemplate.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import servicetemplate.application.common.util.JsonUtil;
import servicetemplate.application.domain.user.consumer.dto.CreateUserEvent;
import servicetemplate.application.error.exception.handler.ExceptionHandler;
import servicetemplate.application.error.exception.handler.holder.ExceptionHandlerHolder;

@Configuration
public class KafkaExceptionHandlingConfig {

	@Bean
	public KafkaListenerErrorHandler handleCreateUser(ExceptionHandlerHolder holder) {
		return (message, exception) -> {
			CreateUserEvent event = JsonUtil.convertToObject(message.getPayload().toString(), CreateUserEvent.class);
			ExceptionHandler handler = holder.hold(exception.getCause());
			handler.handle(event, (Exception) exception.getCause());

			return null;
		};
	}
}
