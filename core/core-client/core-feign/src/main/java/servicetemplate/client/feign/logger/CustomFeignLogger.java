package servicetemplate.client.feign.logger;

import feign.Logger;
import feign.Request;
import feign.Response;
import org.apache.commons.io.IOUtils;
import servicetemplate.support.logger.JsonLogger;
import servicetemplate.support.logger.SystemLogger;
import servicetemplate.support.logger.dto.MessageLog;
import servicetemplate.support.logger.dto.RequestLog;
import servicetemplate.support.logger.dto.ResponseLog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomFeignLogger extends Logger {

	private final SystemLogger logger = new JsonLogger(this.getClass());

	@Override
	protected void log(String configKey, String format, Object... args) {
		logger.logInfo(new MessageLog(String.format(methodTag(configKey) + format, args)));
	}

	@Override
	protected void logRequest(String configKey, Level logLevel, Request request) {
		logger.logRequest(new RequestLog(configKey, request.url(), request.httpMethod().name(), request.headers()));
	}

	@Override
	protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
		int status = response.status();
		logger.logResponse(new ResponseLog(configKey, status, elapsedTime, IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8)));

		return response;
	}
}
