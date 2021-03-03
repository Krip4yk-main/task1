package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.domain.Phrase;
import krip4yk.deskchan.task1.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhrasesService {
    @Autowired
    private PhraseRepository phraseRepository;


    //POST
    public Phrase savePhrase(Phrase phrase) {
        return phraseRepository.save(phrase);
    }

    public List<Phrase> savePhrases(List<Phrase> phrases) {
        return phraseRepository.saveAll(phrases);
    }

    //GET
    public Phrase getPhraseById(long id) {
        return phraseRepository.findById(id).orElse(null);
    }

    public Phrase getPhraseRandom() {
        new Random(phraseRepository.count()).nextLong();
        return phraseRepository.findById(new Random(phraseRepository.count()).nextLong()).orElse(null);
    }

    public List<Phrase> getPhrases() {
        return phraseRepository.findAll();
    }
}
