package servicetemplate.application.error.exception;

import servicetemplate.application.error.code.ApplicationErrorCode;
import servicetemplate.application.error.key.ApplicationErrorKey;
import servicetemplate.domain.user.vo.UserName;

import java.util.List;

import static servicetemplate.application.error.code.ApplicationErrorCode.CANNOT_CREATE_USER_EXIST_NAME;

public class CreateUserValidateException extends ApplicationException {

	private static final String ERROR_KEY_USER_NAME = "userName";

	public CreateUserValidateException(ApplicationErrorCode code, List<ApplicationErrorKey> keys) {
		super(code, keys);
	}

	public static CreateUserValidateException existName(UserName name) {
		return new CreateUserValidateException(
			CANNOT_CREATE_USER_EXIST_NAME,
			List.of(new ApplicationErrorKey(ERROR_KEY_USER_NAME, name.name()))
		);
	}
}
