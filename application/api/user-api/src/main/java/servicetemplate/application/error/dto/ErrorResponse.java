package servicetemplate.application.error.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import servicetemplate.application.error.exception.ApplicationException;
import servicetemplate.application.error.key.ApplicationErrorKey;
import servicetemplate.application.error.key.ApplicationErrorKeys;
import servicetemplate.error.exception.DomainException;
import servicetemplate.error.key.DomainErrorKey;
import servicetemplate.error.key.DomainErrorKeys;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static servicetemplate.application.error.code.ApplicationErrorCode.RUNTIME_ERROR;

public class ErrorResponse {

	private final int code;

	private final String name;

	private final String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<Key> keys;

	public ErrorResponse(int code, String name, String message, List<Key> keys) {
		this.code = code;
		this.name = name;
		this.message = message;
		this.keys = keys;
	}

	public static ErrorResponse from(RuntimeException exception) {
		return new ErrorResponse(RUNTIME_ERROR.getCode(), RUNTIME_ERROR.name(), exception.getMessage(), Collections.emptyList());
	}

	public static ErrorResponse from(ApplicationException exception) {
		return new ErrorResponse(exception.getCode().getCode(), exception.getCode().name(), exception.getMessage(), toKeys(exception.getKeys()));
	}

	public static ErrorResponse from(DomainException exception) {
		return new ErrorResponse(exception.getCode().getCode(), exception.getCode().name(), exception.getMessage(), toKeys(exception.getKeys()));
	}

	public static List<Key> toKeys(ApplicationErrorKeys keys) {
		return keys.getKeys().stream()
			.map(Key::from)
			.collect(Collectors.toList());
	}

	public static List<Key> toKeys(DomainErrorKeys keys) {
		return keys.getKeys().stream()
			.map(Key::from)
			.collect(Collectors.toList());
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public List<Key> getKeys() {
		return keys;
	}

	private static final class Key {

		private final String name;

		private final String value;

		public Key(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public static Key from(ApplicationErrorKey key) {
			return new Key(key.getName(), key.getValue());
		}

		public static Key from(DomainErrorKey key) {
			return new Key(key.getName(), key.getValue());
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
	}
}
