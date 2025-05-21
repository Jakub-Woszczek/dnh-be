package knpraktyka.dnhbe.ai;

import com.google.genai.Client;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GeminiConnection {
    private final Client client;

    public GeminiConnection(GeminiProperties properties) {
        this.client = Client.builder()
                .apiKey(properties.getApiKey())
                .build();
    }

    public void close() {
        client.close();
    }
}

