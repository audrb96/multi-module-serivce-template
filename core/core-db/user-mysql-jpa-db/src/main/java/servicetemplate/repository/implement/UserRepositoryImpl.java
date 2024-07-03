package servicetemplate.repository.implement;

import org.springframework.stereotype.Repository;
import servicetemplate.domain.User;
import servicetemplate.domain.UserRepository;
import servicetemplate.domain.vo.UserId;
import servicetemplate.repository.UserJPARepository;
import servicetemplate.repository.entity.UserEntity;

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
