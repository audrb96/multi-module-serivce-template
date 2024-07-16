package servicetemplate.support.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servicetemplate.dto.event.Event;
import servicetemplate.error.exception.CommonException;
import servicetemplate.support.logger.dto.*;

import java.util.Collections;

public class JsonLogger implements SystemLogger {

	private static final ObjectMapper mapper = new ObjectMapper();

	private final Logger logger;

	public JsonLogger(Class<?> cls) {
		this.logger = LoggerFactory.getLogger(cls);
	}

	@Override
	public void logException(CommonException exception) {
		try {
			logger.error(mapper.writeValueAsString(new ExceptionLog(exception.getKeys(), exception.getMessage(), exception.getStackTrace())));
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void logException(Exception exception) {
		try {
			logger.error(mapper.writeValueAsString(new ExceptionLog(Collections.emptyList(), exception.getMessage(), exception.getStackTrace())));
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void logEvent(Event event, String topic) {
		try {
			logger.info(mapper.writeValueAsString(new EventLog(event, topic)));
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void logRequest(RequestLog requestLog) {
		try {
			logger.info(mapper.writeValueAsString(requestLog));
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void logResponse(ResponseLog responseLog) {
		try {
			if (responseLog.isError()) {
				logger.error(mapper.writeValueAsString(responseLog));
			}

			if (responseLog.isSuccess()) {
				logger.info(mapper.writeValueAsString(responseLog));
			}
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void logInfo(MessageLog messageLog) {
		try {
			logger.info(mapper.writeValueAsString(messageLog));
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}
}
