package servicetemplate.support.logger.dto;

import java.util.Collection;
import java.util.Map;

public class RequestLog {

	private static final String message = "<<<<< Send Request";

	private final String configKey;
	private final String url;

	private final String method;

	private final Map<String, Collection<String>> headers;

	public RequestLog(String configKey, String url, String method, Map<String, Collection<String>> headers) {
		this.configKey = configKey;
		this.url = url;
		this.method = method;
		this.headers = headers;
	}

	public String getConfigKey() {
		return configKey;
	}

	public String getUrl() {
		return url;
	}

	public String getMethod() {
		return method;
	}

	public Map<String, Collection<String>> getHeaders() {
		return headers;
	}

	public String getMessage() {
		return message;
	}
}
