package knpraktyka.dnhbe.controller;

import knpraktyka.dnhbe.ai.GeminiConnection;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Class respon
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

      private final GeminiConnection geminiConnection;

      public ChatController(GeminiConnection geminiConnection) {
            this.geminiConnection = geminiConnection;
      }

      /**
       * Gemini response endpoint.
       * @param query Description on which we base our domain names.
       * @param count How many domains to generate.
       * @return List of generated names or 'none' if no suggestions are available.
       */
      @GetMapping("/suggestions")
      public List<String> suggestions(@RequestParam String query,
                                      @RequestParam(defaultValue = "10") int count) {

            Optional<List<String>> response = geminiConnection.query(query, count);
            return response.orElse(List.of("none"));
      }
}
