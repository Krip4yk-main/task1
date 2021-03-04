package krip4yk.deskchan.task1.repository;

import krip4yk.deskchan.task1.domain.Author;
import krip4yk.deskchan.task1.domain.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
