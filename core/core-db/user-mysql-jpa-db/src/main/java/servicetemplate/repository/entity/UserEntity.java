package servicetemplate.repository.entity;

import jakarta.persistence.*;
import servicetemplate.domain.User;
import servicetemplate.domain.vo.UserId;
import servicetemplate.domain.vo.UserName;
import servicetemplate.domain.vo.UserPassword;

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
