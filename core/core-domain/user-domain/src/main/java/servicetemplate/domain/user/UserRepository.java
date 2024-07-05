package servicetemplate.domain.user;

import servicetemplate.domain.user.vo.UserId;
import servicetemplate.domain.user.vo.UserName;

import java.util.Optional;

public interface UserRepository {

	User save(User user);

	Optional<User> findById(UserId id);

	Optional<User> findByName(UserName name);
}
