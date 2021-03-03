package krip4yk.deskchan.task1.repository;

import krip4yk.deskchan.task1.domain.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {

}
