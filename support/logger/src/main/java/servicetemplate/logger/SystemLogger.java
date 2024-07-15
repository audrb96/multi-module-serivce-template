package servicetemplate.logger;

import servicetemplate.dto.event.Event;
import servicetemplate.error.exception.CommonException;

public interface SystemLogger {

	void logException(CommonException exception);

	void logException(Exception exception);

	void logEvent(Event event, String topic);
}
