package krip4yk.deskchan.task1.services;

import krip4yk.deskchan.task1.domain.Author;
import krip4yk.deskchan.task1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //POST
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void addAuthors(List<Author> authors) {
        authorRepository.saveAll(authors);
    }

    //GET
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Author getAuthorRandom() {
        return authorRepository.findById(ThreadLocalRandom.current().nextLong(0, authorRepository.count())).orElse(null);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    //DELETE
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    //PUT
    public void updateAuthor(Author author) {
        Author existingauthor = authorRepository.findById(author.getId()).orElse(null);
        existingauthor.setName(author.getName());
        authorRepository.save(existingauthor);
    }
}
