package servicetemplate.application.domain.user.consumer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import servicetemplate.domain.user.User;
import servicetemplate.dto.event.Event;

public class UserCreatedEvent implements Event {

	private final Long userId;

	@JsonCreator
	public UserCreatedEvent(@JsonProperty("userId") Long userId) {
		this.userId = userId;
	}

	public static UserCreatedEvent from(User user) {
		return new UserCreatedEvent(user.getId().id());
	}

	public Long getUserId() {
		return userId;
	}
}
