package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.domain.Phrases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhrasesService {
    @Autowired
    private Phrases phrases = new Phrases();

    public List<String> getPhrases() {
        return phrases.getPhrases_list();
    }

    public String getPhrase(int id) {
        List<String> data = phrases.getPhrases_list();
        int s = data.size();
        if (id >= 0 && id < s) {
            return data.get(id);
        } else return "Failed. Out of bounds {0;" + (s-1) + "}";
    }

    public String getRandomPhrase() {
        List<String> data = phrases.getPhrases_list();
        int s = data.size();
        return data.get(new Random().nextInt(s));
    }

    public boolean removePhrase(int id) {
        int s = phrases.getPhrases_list().size();
        List<String> data = phrases.getPhrases_list();
        if (id >= 0 && id < s) {
            data.remove(id);
            phrases.setPhrases_list(data);
            return true;
        } else return false;
    }
    public boolean removePhrase(String value) {
        List<String> data = phrases.getPhrases_list();
        if (data.contains(value)) {
            data.remove(value);
            phrases.setPhrases_list(data);
            return true;
        } else return false;
    }

    public void addPhrase(String value) {
        List<String> data = phrases.getPhrases_list();
        data.add(value);
        phrases.setPhrases_list(data);
    }

    public boolean editPhrase(int id, String value) {
        List<String> data = phrases.getPhrases_list();
        int s = data.size();
        if (id >= 0 && id < s) {
            data.set(id, value);
            return true;
        } else {
            return false;
        }
    }
}
