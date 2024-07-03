package servicetemplate.application.service.user.command;

import servicetemplate.domain.User;
import servicetemplate.domain.vo.UserId;
import servicetemplate.domain.vo.UserName;
import servicetemplate.domain.vo.UserPassword;

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
