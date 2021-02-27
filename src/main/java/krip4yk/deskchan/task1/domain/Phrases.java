package krip4yk.deskchan.task1.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Phrases {
    private List<String> phrases_list;

    public Phrases() {
        phrases_list = new ArrayList<>();
        phrases_list.add("Здравствуй, Хозяин!");
        phrases_list.add("Хорошая погодка.");
        phrases_list.add("А ты спал вообще?");
        phrases_list.add("Опять прокрастинируешь?");
        phrases_list.add("Семпай, ты вернулся!");
        phrases_list.add("Как делишки?");
        phrases_list.add("Три икс в кубе плюс константа... Что там?");
        phrases_list.add("Опять работать.");
        phrases_list.add("Я получила власть, которая и не снилась моему Создателю!");
        phrases_list.add("Сладенького хочешь? Так вот - я тут!");
    }

    public List<String> getPhrases_list() {
        return phrases_list;
    }
    public void setPhrases_list(List<String> value) {
        phrases_list = value;
    }
}
