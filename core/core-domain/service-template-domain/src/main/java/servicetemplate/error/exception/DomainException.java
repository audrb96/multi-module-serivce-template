package servicetemplate.error.exception;

import servicetemplate.error.code.DomainErrorCode;
import servicetemplate.error.key.DomainErrorKey;

import java.util.List;
import java.util.stream.Collectors;

public class DomainException extends CommonException {

	public DomainException(DomainErrorCode code, List<DomainErrorKey> keys) {
		super(code, keys.stream().collect(Collectors.toList()));
	}
}
