package servicetemplate.application.error.exception;

import servicetemplate.application.error.code.ApplicationErrorCode;
import servicetemplate.application.error.key.ApplicationErrorKey;
import servicetemplate.application.error.key.ApplicationErrorKeys;
import servicetemplate.domain.user.vo.UserName;

import static servicetemplate.application.error.code.ApplicationErrorCode.CANNOT_CREATE_USER_EXIST_NAME;

public class CreateUserValidateExcpetion extends ApplicationException {

	private static final String ERROR_KEY_USER_NAME = "userName";

	public CreateUserValidateExcpetion(ApplicationErrorCode code, ApplicationErrorKeys keys) {
		super(code, keys);
	}

	public static CreateUserValidateExcpetion existName(UserName name) {
		return new CreateUserValidateExcpetion(
			CANNOT_CREATE_USER_EXIST_NAME,
			ApplicationErrorKeys.of(
				new ApplicationErrorKey(ERROR_KEY_USER_NAME, name.name())
			)
		);
	}
}
