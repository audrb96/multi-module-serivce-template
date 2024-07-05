package servicetemplate.repository.domain.user.implement;

import org.springframework.stereotype.Repository;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.UserRepository;
import servicetemplate.domain.user.vo.UserId;
import servicetemplate.domain.user.vo.UserName;
import servicetemplate.repository.domain.user.UserJPARepository;
import servicetemplate.repository.domain.user.entity.UserEntity;

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

	@Override
	public Optional<User> findByName(UserName name) {
		return repository.findByName(name.name()).map(UserEntity::toDomain);
	}
}
