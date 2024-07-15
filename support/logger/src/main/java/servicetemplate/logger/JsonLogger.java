package servicetemplate.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servicetemplate.dto.event.Event;
import servicetemplate.error.exception.CommonException;
import servicetemplate.logger.dto.EventLog;
import servicetemplate.logger.dto.ExceptionLog;

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
}
