package servicetemplate.support.logger;

import servicetemplate.dto.event.Event;
import servicetemplate.error.exception.CommonException;
import servicetemplate.support.logger.dto.MessageLog;
import servicetemplate.support.logger.dto.RequestLog;
import servicetemplate.support.logger.dto.ResponseLog;

public interface SystemLogger {

	void logException(CommonException exception);

	void logException(Exception exception);

	void logEvent(Event event, String topic);

	void logRequest(RequestLog requestLog);

	void logResponse(ResponseLog responseLog);

	void logInfo(MessageLog messageLog);
}

