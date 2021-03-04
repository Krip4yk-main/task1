package krip4yk.deskchan.task1.domain;

import javax.persistence.*;

@Entity
@Table(name="phrases_table")
public class Phrase {

    @Id
    @GeneratedValue
    private Long id;
    private String phrase;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
