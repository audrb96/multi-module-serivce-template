package user.application.service.command;

import user.domain.User;
import user.domain.vo.UserId;
import user.domain.vo.UserName;
import user.domain.vo.UserPassword;

public class CreateUserCommand {

	private final String name;

	private final String password;

	public CreateUserCommand(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User toUser() {
		return new User(UserId.empty(), new UserName(this.name), new UserPassword(this.password));
	}
}
