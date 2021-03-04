package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.domain.Phrase;
import krip4yk.deskchan.task1.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PhrasesService {
    private final PhraseRepository phraseRepository;

    public PhrasesService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    //POST
    public void addPhrase(Phrase phrase) {
        phraseRepository.save(phrase);
    }

    public void addPhrases(List<Phrase> phrases) {
        phraseRepository.saveAll(phrases);
    }

    //GET
    public Phrase getPhraseById(Long id) {
        return phraseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Phrase getPhraseRandom() {
        return phraseRepository.findById(ThreadLocalRandom.current().nextLong(0, phraseRepository.count())).orElse(null);
    }

    public Phrase getPhraseByName(String phrase) {
        return phraseRepository.findByPhrase(phrase);
    }

    public List<Phrase> getPhrases() {
        return phraseRepository.findAll();
    }

    //DELETE
    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }

    //PUT
    public void updatePhrase(Phrase phrase) {
        Phrase existingPhrase = phraseRepository.findById(phrase.getId()).orElse(null);
        existingPhrase.setPhrase(phrase.getPhrase());
        phraseRepository.save(existingPhrase);
    }
}
