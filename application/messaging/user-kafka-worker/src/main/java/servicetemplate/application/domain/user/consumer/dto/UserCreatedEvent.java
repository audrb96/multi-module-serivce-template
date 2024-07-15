package servicetemplate.application.domain.user.consumer.dto;

import servicetemplate.domain.user.User;
import servicetemplate.dto.event.Event;

public class UserCreatedEvent implements Event {

	private final Long userId;

	public UserCreatedEvent(Long userId) {
		this.userId = userId;
	}

	public static UserCreatedEvent from(User user) {
		return new UserCreatedEvent(user.getId().id());
	}

	public Long getUserId() {
		return userId;
	}
}
