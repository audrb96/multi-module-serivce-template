package user.application.presentation.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.application.presentation.api.dto.request.CreateUserRequest;
import user.application.presentation.api.dto.response.GetUserByIdResponse;
import user.application.presentation.api.dto.response.CreateUserResponse;
import user.application.service.UserService;
import user.application.service.query.GetUserByIdQuery;
import user.domain.User;

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

		return ResponseEntity.created(URI.create(String.format("/user/%d", user.getId().id()))).build();
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<GetUserByIdResponse> getById(@PathVariable Long userId) {
		User user = service.getById(new GetUserByIdQuery(userId));

		return ResponseEntity.ok(GetUserByIdResponse.from(user));
	};
}
