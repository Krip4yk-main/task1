package krip4yk.deskchan.task1.controller;

import krip4yk.deskchan.task1.domain.Phrase;
import krip4yk.deskchan.task1.services.PhrasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class PhraseController {
    @Autowired
    private PhrasesService service;

    //POST
    @PostMapping("/addPhrase")
    public void addPhrase(@RequestBody Phrase phrase) {
        service.addPhrase(phrase);
    }

    @PostMapping("/addPhrases")
    public void addPhrases(List<Phrase> phrases) {
        service.addPhrases(phrases);
    }

    //GET
    @GetMapping()
    public Phrase getPhraseById(long id) {
        return service.getPhraseById(id);
    }

    @GetMapping
    public Phrase getPhraseRandom() {
        return service.getPhraseRandom();
    }

    @GetMapping
    public Phrase getPhraseByName(String name) {
        return service.getPhraseByName(name);
    }

    @GetMapping
    public List<Phrase> getPhrases() {
        return service.getPhrases();
    }

    //DELETE
    @DeleteMapping
    public void deletePhrase(long id) {
        service.deletePhrase(id);
    }

    //PUT
    @PutMapping
    public void updatePhrase(Phrase phrase) {
        service.updatePhrase(phrase);
    }
}
