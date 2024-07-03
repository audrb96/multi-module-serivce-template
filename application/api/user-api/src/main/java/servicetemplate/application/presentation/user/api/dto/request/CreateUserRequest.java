package servicetemplate.application.presentation.user.api.dto.request;

import servicetemplate.application.service.user.command.CreateUserCommand;

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
