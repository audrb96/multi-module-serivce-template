package user.domain;

import user.domain.vo.UserId;

import java.util.Optional;

public interface UserRepository {

	User save(User user);
	Optional<User> findById(UserId id);
}
