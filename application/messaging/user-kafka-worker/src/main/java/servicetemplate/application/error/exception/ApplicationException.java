package servicetemplate.application.error.exception;

import servicetemplate.application.error.code.ApplicationErrorCode;
import servicetemplate.application.error.key.ApplicationErrorKey;
import servicetemplate.error.exception.CommonException;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationException extends CommonException {

	public ApplicationException(ApplicationErrorCode code, List<ApplicationErrorKey> keys) {
		super(code, keys.stream().collect(Collectors.toList()));
	}
}
