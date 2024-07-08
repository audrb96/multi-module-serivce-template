package servicetemplate.logger;

import servicetemplate.error.exception.CommonException;

public interface SystemLogger {

	void logException(CommonException exception);

	void logException(Exception exception);
}
