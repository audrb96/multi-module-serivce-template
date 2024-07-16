package servicetemplate.client.feign.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servicetemplate.client.feign.logger.CustomFeignLogger;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableFeignClients(basePackages = "servicetemplate.client")
public class FeignConfig {

	@Bean
	public Request.Options options() {
		return new Request.Options(
			60000,
			TimeUnit.SECONDS,
			180000,
			TimeUnit.SECONDS,
			true
		);
	}

	@Bean
	public Contract contract() {
		return new SpringMvcContract();
	}

	@Bean
	public Logger.Level loggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Logger logger() {
		return new CustomFeignLogger();
	}

	@Bean
	public Retryer retryer() {
		return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 3);
	}
}
