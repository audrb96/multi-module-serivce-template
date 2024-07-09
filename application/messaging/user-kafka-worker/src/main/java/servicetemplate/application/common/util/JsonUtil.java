package servicetemplate.application.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

	private static final ObjectMapper om = new ObjectMapper();

	private JsonUtil() {
		throw new UnsupportedOperationException(this.getClass().getName() + "의 인스턴스는 생성되어서 안됩니다.");
	}

	public static <T> T convertToObject(String str, Class<T> cls) {
		try {
			return om.readValue(str, cls);
		} catch (JsonProcessingException exception) {
			throw new RuntimeException(exception);
		}
	}
}
