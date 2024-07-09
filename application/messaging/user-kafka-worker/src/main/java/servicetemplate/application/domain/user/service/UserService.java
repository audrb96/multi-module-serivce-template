package servicetemplate.application.domain.user.service;

import org.springframework.stereotype.Service;
import servicetemplate.application.domain.user.service.command.CreateUserCommand;
import servicetemplate.application.error.exception.CreateUserValidateException;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User create(CreateUserCommand command) {
		User user = command.toUser();

		repository.findByName(user.getName())
			.ifPresent(findUser -> {
				throw CreateUserValidateException.existName(user.getName());
			});

		return repository.save(user);
	}
}
