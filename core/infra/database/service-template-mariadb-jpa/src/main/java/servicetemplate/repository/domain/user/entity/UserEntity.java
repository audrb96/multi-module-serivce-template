package servicetemplate.repository.domain.user.entity;

import jakarta.persistence.*;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.vo.UserId;
import servicetemplate.domain.user.vo.UserName;
import servicetemplate.domain.user.vo.UserPassword;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	public UserEntity(Long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	protected UserEntity() {
	}

	public static UserEntity from(User user) {
		return new UserEntity(user.getId().id(), user.getName().name(), user.getPassword().password());
	}

	public User toDomain() {
		return new User(new UserId(this.id), new UserName(this.name), new UserPassword(this.password));
	}
}
