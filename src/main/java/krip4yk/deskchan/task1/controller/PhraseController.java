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
    @PostMapping("/phrases/addPhrase")
    public void addPhrase(@RequestBody Phrase phrase) {
        service.addPhrase(phrase);
    }

    @PostMapping("/phrases/addPhrases")
    public void addPhrases(@RequestBody List<Phrase> phrases) {
        service.addPhrases(phrases);
    }

    //GET
    @GetMapping("/phrases/{id}")
    public Phrase getPhraseById(@PathVariable Long id) {
        return service.getPhraseById(id);
    }

    @GetMapping("/phrases/random")
    public Phrase getPhraseRandom() {
        return service.getPhraseRandom();
    }

    @GetMapping("/phrases/{name}")
    public Phrase getPhraseByName(@PathVariable String name) {
        return service.getPhraseByName(name);
    }

    @GetMapping("/phrases")
    public List<Phrase> getPhrases() {
        return service.getPhrases();
    }

    //DELETE
    @DeleteMapping("/phrases/remove/{id}")
    public void deletePhrase(@PathVariable Long id) {
        service.deletePhrase(id);
    }

    //PUT
    @PutMapping("/phrases/update")
    public void updatePhrase(@RequestBody Phrase phrase) {
        service.updatePhrase(phrase);
    }
}
