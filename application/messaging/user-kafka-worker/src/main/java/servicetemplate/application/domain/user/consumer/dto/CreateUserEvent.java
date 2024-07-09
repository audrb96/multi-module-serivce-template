package servicetemplate.application.domain.user.consumer.dto;

import servicetemplate.application.domain.user.service.command.CreateUserCommand;
import servicetemplate.dto.event.Event;

public class CreateUserEvent implements Event {

	private String name;

	private String password;

	public CreateUserEvent(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public CreateUserEvent() {
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public CreateUserCommand toCommand() {
		return new CreateUserCommand(this.name, this.password);
	}
}
