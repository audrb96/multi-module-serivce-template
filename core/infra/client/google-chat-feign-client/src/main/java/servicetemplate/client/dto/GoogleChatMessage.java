package servicetemplate.client.dto;

public class GoogleChatMessage {

	private final String text;

	public GoogleChatMessage(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
