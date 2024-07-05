package servicetemplate.application.domain.user.service;

import org.springframework.stereotype.Component;
import servicetemplate.application.domain.user.service.command.CreateUserCommand;
import servicetemplate.application.domain.user.service.query.GetUserByIdQuery;
import servicetemplate.application.error.exception.CreateUserValidateExcpetion;
import servicetemplate.domain.user.User;
import servicetemplate.domain.user.UserRepository;
import servicetemplate.error.exception.NotFoundDomainException;

@Component
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User create(CreateUserCommand command) {
		User user = command.toUser();
		
		repository.findByName(user.getName())
			.ifPresent(findUser -> {
				throw CreateUserValidateExcpetion.existName(user.getName());
			});

		return repository.save(user);
	}

	public User getById(GetUserByIdQuery query) {
		return repository.findById(query.toUserId())
			.orElseThrow(() -> NotFoundDomainException.user(query.toUserId()));
	}
}
