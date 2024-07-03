package servicetemplate.application.service.user;

import org.springframework.stereotype.Component;
import servicetemplate.application.service.user.command.CreateUserCommand;
import servicetemplate.application.service.user.query.GetUserByIdQuery;
import servicetemplate.domain.User;
import servicetemplate.domain.UserRepository;

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
