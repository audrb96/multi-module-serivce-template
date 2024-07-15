package servicetemplate.logger.dto;

import servicetemplate.dto.key.Key;

import java.util.List;

public class ExceptionLog {

	private final List<Key> keys;

	private final String message;

	private final StackTraceElement[] stackTraceElements;

	public ExceptionLog(List<Key> keys, String message, StackTraceElement[] stackTraceElements) {
		this.keys = keys;
		this.message = message;
		this.stackTraceElements = stackTraceElements;
	}

	public List<Key> getKeys() {
		return keys;
	}

	public String getMessage() {
		return message;
	}

	public StackTraceElement[] getStackTraceElements() {
		return stackTraceElements;
	}
}
