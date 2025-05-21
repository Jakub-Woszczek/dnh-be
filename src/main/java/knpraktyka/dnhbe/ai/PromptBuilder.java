package knpraktyka.dnhbe.ai;

import com.google.genai.types.GenerateContentConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {
    @Getter
    private final String model;
    private final double temperature;

    public PromptBuilder(GeminiProperties properties) {
        this.model = properties.getModel();
        this.temperature = properties.getSettings().getTemperature();
    }

    public GenerateContentConfig buildConfig() {
        return GenerateContentConfig.builder()
                .temperature((float) temperature)
                .build();
    }
}
