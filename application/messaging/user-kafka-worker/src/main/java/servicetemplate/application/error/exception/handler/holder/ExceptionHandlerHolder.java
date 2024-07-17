package servicetemplate.application.error.exception.handler.holder;

import org.springframework.stereotype.Component;
import servicetemplate.application.error.exception.handler.ExceptionHandler;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ExceptionHandlerHolder {

	private final Map<Class<? extends RuntimeException>, ExceptionHandler> exceptionHandlerMap;

	public ExceptionHandlerHolder(Set<ExceptionHandler> exceptionHandlers) {
		this.exceptionHandlerMap = exceptionHandlers.stream()
			.collect(Collectors.toMap(
				ExceptionHandler::getExceptionClass,
				exceptionHandler -> exceptionHandler
			));
	}

	public ExceptionHandler hold(Throwable exception) {
		Class<?> exceptionClass = exception.getClass();
		ExceptionHandler closestHandler = null;
		int closestDistance = Integer.MAX_VALUE;

		for (Map.Entry<Class<? extends RuntimeException>, ExceptionHandler> entry : exceptionHandlerMap.entrySet()) {
			Class<?> handlerExceptionClass = entry.getKey();
			if (handlerExceptionClass.isAssignableFrom(exceptionClass)) {
				int distance = getInheritanceDistance(exceptionClass, handlerExceptionClass);
				if (distance < closestDistance) {
					closestHandler = entry.getValue();
					closestDistance = distance;
				}
			}
		}

		return closestHandler;
	}


	private int getInheritanceDistance(Class<?> from, Class<?> to) {
		int distance = 0;
		while (from != null && from != to) {
			distance++;
			from = from.getSuperclass();
		}
		return distance;
	}
}
