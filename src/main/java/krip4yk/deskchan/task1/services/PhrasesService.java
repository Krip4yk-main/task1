package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.controller.AuthorController;
import krip4yk.deskchan.task1.domain.Author;
import krip4yk.deskchan.task1.domain.Phrase;
import krip4yk.deskchan.task1.repository.AuthorRepository;
import krip4yk.deskchan.task1.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PhrasesService {
    private final PhraseRepository phraseRepository;

    public PhrasesService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    @Autowired
    private AuthorService authorService;

    //POST
    public void addPhrase(Phrase phrase) {
        phrase = isAuthorExist(phrase);
        phraseRepository.save(phrase);
    }

    public void addPhrases(List<Phrase> phrases) {
        for (Phrase phrase : phrases) {
            int ind = phrases.indexOf(phrase);
            phrase = isAuthorExist(phrase);
            phrases.set(ind, phrase);
        }
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

        phrase = isAuthorExist(phrase);
        existingPhrase.setAuthor(phrase.getAuthor());

        phraseRepository.save(existingPhrase);
    }

    //OTHER

    private Phrase isAuthorExist(Phrase phrase) {
        if (phrase.getAuthor() != null) {
            if (phrase.getAuthor().getId() == null) {
                Author tempAuthor = authorService.getAuthorByName(phrase.getAuthor().getName());
                if (tempAuthor != null) {
                    phrase.getAuthor().setId(tempAuthor.getId());
                } else {
                    authorService.addAuthor(phrase.getAuthor());
                }
            }
        }
        return phrase;
    }
}
