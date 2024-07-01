package user.repository.implement;

import org.springframework.stereotype.Repository;
import user.domain.User;
import user.domain.UserRepository;
import user.domain.vo.UserId;
import user.repository.UserJPARepository;
import user.repository.entity.UserEntity;

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
