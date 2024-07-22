package servicetemplate.domain.user;


import servicetemplate.domain.user.vo.UserId;
import servicetemplate.domain.user.vo.UserName;
import servicetemplate.domain.user.vo.UserPassword;

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

