package krip4yk.deskchan.task1.controller;

import krip4yk.deskchan.task1.services.PhrasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phrases")
public class PhrasesController {

//    @GetMapping("/phrases")
//    public String allPhrases() {
//        return "That's my first controller";
//    }

    @Autowired
    private PhrasesService phrasesService;


    @GetMapping()
    public @ResponseBody List<String> getPhrases() {
        return phrasesService.getPhrases();
    }

    @GetMapping("/random")
    public @ResponseBody String getRandomPhrase() {
        return phrasesService.getRandomPhrase();
    }

    @PostMapping()
    public ResponseEntity addPhrase(@RequestParam String value) {
        if (value.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        phrasesService.addPhrase(value);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity editPhrase(@RequestParam int id, @RequestParam String value) {
        System.out.println(id + " | " + value);
        if (outOfBounds(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (value.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        phrasesService.editPhrase(id, value);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity removePhrase(@RequestParam int id) {
        if (outOfBounds(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        phrasesService.removePhrase(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean outOfBounds(int value) {
        if (value < 0) return true;
        if (value > phrasesService.getPhrases().size()) return true;
        return false;
    }
}
