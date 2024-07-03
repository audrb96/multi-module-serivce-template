package servicetemplate.domain;

import servicetemplate.domain.vo.UserId;
import servicetemplate.domain.vo.UserName;
import servicetemplate.domain.vo.UserPassword;

public class User {

	private final UserId id;

	private final UserName name;

	private final UserPassword password;

	public User(UserId id, UserName name, UserPassword password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public UserId getId() {
		return id;
	}

	public UserName getName() {
		return name;
	}

	public UserPassword getPassword() {
		return password;
	}
}
