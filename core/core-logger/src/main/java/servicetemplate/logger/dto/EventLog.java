package servicetemplate.logger.dto;

import servicetemplate.dto.event.Event;

public class EventLog {

	private final Event event;

	private final String topic;

	public EventLog(Event event, String topic) {
		this.event = event;
		this.topic = topic;
	}

	public Event getEvent() {
		return event;
	}

	public String getTopic() {
		return topic;
	}
}
