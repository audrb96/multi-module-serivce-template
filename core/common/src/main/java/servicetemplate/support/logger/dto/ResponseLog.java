package servicetemplate.support.logger.dto;

public class ResponseLog {

	private static final String message = ">>>>> Receive Response";

	private final String configKey;

	private final int status;

	private final long timeMilis;

	private final String body;

	public ResponseLog(String configKey, int status, long timeMilis, String body) {
		this.configKey = configKey;
		this.status = status;
		this.timeMilis = timeMilis;
		this.body = body;
	}

	public String getConfigKey() {
		return configKey;
	}

	public int getStatus() {
		return status;
	}

	public long getTimeMilis() {
		return timeMilis;
	}

	public String getBody() {
		return body;
	}

	public boolean isError() {
		return this.status >= 400;
	}

	public boolean isSuccess() {
		return this.status < 400;
	}

	public String getMessage() {
		return message;
	}
}
