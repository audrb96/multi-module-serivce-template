package servicetemplate.application.domain.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicetemplate.application.domain.user.api.dto.request.CreateUserRequest;
import servicetemplate.application.domain.user.api.dto.response.CreateUserResponse;
import servicetemplate.application.domain.user.api.dto.response.GetUserByIdResponse;
import servicetemplate.application.domain.user.service.UserService;
import servicetemplate.application.domain.user.service.query.GetUserByIdQuery;
import servicetemplate.domain.user.User;

import java.net.URI;

@RestController
public class UserApi {

	private final UserService service;

	public UserApi(UserService service) {
		this.service = service;
	}

	@PostMapping("/user")
	public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
		User user = service.create(request.toCommand());

		return ResponseEntity.created(URI.create(String.format("/user/%d", user.getId().id())))
			.body(CreateUserResponse.from(user));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<GetUserByIdResponse> getById(@PathVariable Long userId) {
		User user = service.getById(new GetUserByIdQuery(userId));

		return ResponseEntity.ok(GetUserByIdResponse.from(user));
	}

}
