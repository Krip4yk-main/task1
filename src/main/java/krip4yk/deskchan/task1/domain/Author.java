package krip4yk.deskchan.task1.domain;

import javax.persistence.*;

@Entity
@Table(name="author_table")
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
