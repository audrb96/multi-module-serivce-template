package servicetemplate.domain.user;

import servicetemplate.domain.user.vo.UserId;

import java.util.Optional;

public interface UserRepository {

	User save(User user);

	Optional<User> findById(UserId id);
}
