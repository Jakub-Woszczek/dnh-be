package knpraktyka.dnhbe.ai;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "gemini")
public class GeminiProperties {
    private String apiKey;
    private String model;
    private Settings settings;

    @Getter
    @Setter
    public static class Settings {
        private double temperature;
        private int maxTokens;
    }
}

