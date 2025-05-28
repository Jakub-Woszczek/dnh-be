package knpraktyka.dnhbe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

      @GetMapping("/suggestions")
      public String suggestions(@RequestParam String query) {
            System.out.println(query);
            return query;
      }

}
