package user.application.presentation.api.dto.response;

import user.domain.User;

public class GetUserByIdResponse {

	private final String name;

	private final String password;

	public GetUserByIdResponse(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public static GetUserByIdResponse from(User user) {
		return new GetUserByIdResponse(user.getName().name(), user.getPassword().password());
	}
}
