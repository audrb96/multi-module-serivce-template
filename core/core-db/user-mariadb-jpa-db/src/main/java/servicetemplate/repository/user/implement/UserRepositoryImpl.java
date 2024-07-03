package servicetemplate.repository.user.implement;

import org.springframework.stereotype.Repository;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.UserRepository;
import servicetemplate.domain.user.vo.UserId;
import servicetemplate.repository.user.UserJPARepository;
import servicetemplate.repository.user.entity.UserEntity;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private final UserJPARepository repository;

	public UserRepositoryImpl(UserJPARepository repository) {
		this.repository = repository;
	}

	@Override
	public User save(User user) {
		return repository.save(UserEntity.from(user)).toDomain();
	}

	@Override
	public Optional<User> findById(UserId id) {
		return repository.findById(id.id()).map(UserEntity::toDomain);
	}
}
