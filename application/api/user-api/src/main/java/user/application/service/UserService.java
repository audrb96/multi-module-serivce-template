package user.application.service;

import org.springframework.stereotype.Component;
import user.application.service.command.CreateUserCommand;
import user.application.service.query.GetUserByIdQuery;
import user.domain.User;
import user.domain.UserRepository;

@Component
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User create(CreateUserCommand command) {
		return repository.save(command.toUser());
	}

	public User getById(GetUserByIdQuery query) {
		return repository.findById(query.toUserId())
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
	}
}
