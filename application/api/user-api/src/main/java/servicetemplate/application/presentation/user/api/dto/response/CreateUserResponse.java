package servicetemplate.application.presentation.user.api.dto.response;

import servicetemplate.domain.User;

public class CreateUserResponse {

	private final Long id;

	private final String name;

	private final String password;

	public CreateUserResponse(Long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public static CreateUserResponse from(User user) {
		return new CreateUserResponse(user.getId().id(), user.getName().name(), user.getPassword().password());
	}
}
