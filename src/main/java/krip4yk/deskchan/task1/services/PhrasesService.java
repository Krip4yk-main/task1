package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.domain.Phrase;
import krip4yk.deskchan.task1.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhrasesService {
    @Autowired
    private PhraseRepository phraseRepository;

    //POST
    public void addPhrase(Phrase phrase) {
        phraseRepository.save(phrase);
    }

    public void addPhrases(List<Phrase> phrases) {
        phraseRepository.saveAll(phrases);
    }

    //GET
    public Phrase getPhraseById(long id) {
        return phraseRepository.findById(id).orElse(null);
    }

    public Phrase getPhraseRandom() {
        new Random(phraseRepository.count()).nextLong();
        return phraseRepository.findById(new Random(phraseRepository.count()).nextLong()).orElse(null);
    }

    public Phrase getPhraseByName(String phrase) {
        return phraseRepository.findByPhrase(phrase);
    }

    public List<Phrase> getPhrases() {
        return phraseRepository.findAll();
    }

    //DELETE
    public void deletePhrase(long id) {
        phraseRepository.deleteById(id);
    }

    //PUT
    public void updatePhrase(Phrase phrase) {
        Phrase existingPhrase = phraseRepository.findById(phrase.getId()).orElse(null);
        existingPhrase.setPhrase(phrase.getPhrase());
        phraseRepository.save(existingPhrase);
    }
}
