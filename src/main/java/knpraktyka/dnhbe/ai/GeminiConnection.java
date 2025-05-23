package knpraktyka.dnhbe.ai;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Getter
@Component
public class GeminiConnection {
    private final Client client;

    private final GeminiProperties properties;

    private final GenerateContentConfig config;

    public GeminiConnection(GeminiProperties properties) {
        this.client = Client.builder()
                .apiKey(properties.getApiKey())
                .build();

        this.properties = properties;

        this.config = GenerateContentConfig.builder()
                .temperature(properties.getSettings().getTemperature())
                .build();
    }

    public Optional<List<String>> query(String companyDescription){
        return query(companyDescription, 10);
    }

    public Optional<List<String>> query(String companyDescription, int count){
        GenerateContentResponse response = client.models.generateContent(
                properties.getModel(),
                buildPrompt(companyDescription, count),
                config
        );

        if(response.text() == null)
            return Optional.empty();
        else
            return Optional.of(List.of(response.text().split(", ")));
    }

    private String buildPrompt(String companyDescription, int count){
        return String.format(PromptTemplates.DOMAIN_PROMPT,
                companyDescription.trim(),
                count,
                count);
    }

    public void close() {
        client.close();
    }
}

