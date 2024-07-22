package servicetemplate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import servicetemplate.client.dto.GoogleChatMessage;

@FeignClient(name = "googleChatClient", url = "${client.google-chat.url}")
public interface GoogleChatClient {

	@PostMapping
	void sendMessage(@RequestBody GoogleChatMessage message);
}
