package user.application.presentation.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.application.presentation.api.dto.request.CreateUserRequest;
import user.application.presentation.api.dto.response.CreateUserResponse;

@RestController
public class UserApi {

	@PostMapping("/user")
	public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {

	}
}
