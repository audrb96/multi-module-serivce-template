package user.application.presentation.api.dto.request;

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
}
