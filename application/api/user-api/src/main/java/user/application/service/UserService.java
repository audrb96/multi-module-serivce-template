package user.application.service;

import org.springframework.stereotype.Component;
import user.application.service.command.CreateUserCommand;
import user.domain.User;
import user.domain.UserRepository;

@Component
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User create(CreateUserCommand command) {
		return userRepository.save(command.toUser());
	}
}
