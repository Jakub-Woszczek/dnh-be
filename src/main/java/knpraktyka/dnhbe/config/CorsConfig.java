package knpraktyka.dnhbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global CORS configuration for allowing cross-origin requests from the frontend.
 */
@Configuration
public class CorsConfig {

      /**
       * Configures CORS to allow requests from http://localhost:3000 with standard HTTP methods.
       * @return WebMvcConfigurer with customized CORS settings.
       */
      @Bean
      public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                  @Override
                  public void addCorsMappings(CorsRegistry registry) {
                        registry.addMapping("/**")
                                .allowedOrigins("http://localhost:3000")
                                .allowedMethods("GET", "POST", "PUT", "DELETE")
                                .allowCredentials(true);
                  }
            };
      }
}
