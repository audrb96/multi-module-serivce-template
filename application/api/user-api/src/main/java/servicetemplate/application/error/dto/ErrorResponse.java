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

	private final Keys keys;

	public ErrorResponse(int code, String name, String message, Keys keys) {
		this.code = code;
		this.name = name;
		this.message = message;
		this.keys = keys;
	}

	public static ErrorResponse from(RuntimeException exception) {
		return new ErrorResponse(RUNTIME_ERROR.getCode(), RUNTIME_ERROR.name(), exception.getMessage(), Keys.empty());
	}

	public static ErrorResponse from(ApplicationException exception) {
		return new ErrorResponse(exception.getCode().getCode(), exception.getCode().name(), exception.getMessage(), Keys.from(exception.getKeys()));
	}

	public static ErrorResponse from(DomainException exception) {
		return new ErrorResponse(exception.getCode().getCode(), exception.getCode().name(), exception.getMessage(), Keys.from(exception.getKeys()));
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

	public Keys getKeys() {
		return keys;
	}

	private static final class Keys {

		@JsonInclude(JsonInclude.Include.NON_EMPTY)
		private final List<Key> keys;

		public Keys(List<Key> keys) {
			this.keys = keys;
		}

		public static Keys from(ApplicationErrorKeys keys) {
			return new Keys(
				keys.getKeys().stream()
					.map(Key::from)
					.collect(Collectors.toList())
			);
		}

		public static Keys from(DomainErrorKeys keys) {
			return new Keys(
				keys.getKeys().stream()
					.map(Key::from)
					.collect(Collectors.toList())
			);
		}

		public static Keys empty() {
			return new Keys(Collections.emptyList());
		}

		public List<Key> getKeys() {
			return keys;
		}
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
