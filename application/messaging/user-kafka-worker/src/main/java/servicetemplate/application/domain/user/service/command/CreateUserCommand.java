package servicetemplate.application.domain.user.service.command;

import servicetemplate.domain.user.User;
import servicetemplate.domain.user.vo.UserId;
import servicetemplate.domain.user.vo.UserName;
import servicetemplate.domain.user.vo.UserPassword;

public class CreateUserCommand {

	private final String name;

	private final String password;

	public CreateUserCommand(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public User toUser() {
		return new User(UserId.empty(), new UserName(this.name), new UserPassword(this.password));
	}
}
