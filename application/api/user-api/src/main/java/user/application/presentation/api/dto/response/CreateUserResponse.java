package user.application.presentation.api.dto.response;

public class CreateUserResponse {

	private final String name;

	private final String password;

	public CreateUserResponse(String name, String password) {
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
