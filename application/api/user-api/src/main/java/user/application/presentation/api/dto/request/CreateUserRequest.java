package user.application.presentation.api.dto.request;

import user.application.service.command.CreateUserCommand;

public class CreateUserRequest {

	private final String name;

	private final String password;

	public CreateUserRequest(String name, String password) {
		this.name = name;
		this.password = password;
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
