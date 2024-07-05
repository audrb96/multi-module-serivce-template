package servicetemplate.application.domain.user.service;

import org.springframework.stereotype.Component;
import servicetemplate.application.domain.user.service.command.CreateUserCommand;
import servicetemplate.application.domain.user.service.query.GetUserByIdQuery;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.UserRepository;

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
