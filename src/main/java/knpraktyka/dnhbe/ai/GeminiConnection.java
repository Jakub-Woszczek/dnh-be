package knpraktyka.dnhbe.ai;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Class responsible for communicating with google gemini.
 */
@Getter
@Component
public class GeminiConnection {
    private final Client client;

    private final GeminiProperties properties;

    private final GenerateContentConfig config;

    private static final int DEFAULT_NUMBER_OF_DOMAINS = 10;

    /**
     * Constructor initializes client and properties
     * required to create queries.
     * @param properties properties loaded from application.properties
     */
    public GeminiConnection(GeminiProperties properties) {
        this.client = Client.builder()
                .apiKey(properties.getApiKey())
                .build();

        this.properties = properties;

        this.config = GenerateContentConfig.builder()
                .temperature(properties.getSettings().getTemperature())
                .build();
    }


    /**
     * Method for querying the AI and fetching results.
     * @param companyDescription Description on which we base our domain names.
     * @param count How many domains to generate.
     * @return List of generated domain names.
     */
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

    /**
     * Query with default {@code count}
     * @see GeminiConnection#query(String companyDescription, int count)
     */
    public Optional<List<String>> query(String companyDescription){
        return query(companyDescription, DEFAULT_NUMBER_OF_DOMAINS);
    }

    /**
     * Inserts company description and how many names to generate
     * into a prompt template.
     * @param companyDescription description
     * @param count how many domain names to generate
     * @return prompt
     */
    private String buildPrompt(String companyDescription, int count){
        return String.format(PromptTemplates.DOMAIN_PROMPT,
                companyDescription.trim(),
                count,
                count);
    }

    /**
     * Close the client (end connection)
     */
    public void close() {
        client.close();
    }
}

