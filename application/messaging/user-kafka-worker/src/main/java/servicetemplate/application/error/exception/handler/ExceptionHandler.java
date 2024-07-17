package servicetemplate.application.error.exception.handler;

import servicetemplate.dto.event.Event;

public interface ExceptionHandler {

	Class<? extends RuntimeException> getExceptionClass();

	void handle(Event event, Exception exception);
}
