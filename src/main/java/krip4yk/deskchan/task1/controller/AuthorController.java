package krip4yk.deskchan.task1.controller;

import krip4yk.deskchan.task1.domain.Author;
import krip4yk.deskchan.task1.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    //POST
    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody Author author) {
        service.addAuthor(author);
    }

    @PostMapping("/addAuthors")
    public void addAuthors(@RequestBody List<Author> authors) {
        service.addAuthors(authors);
    }

    //GET
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    @GetMapping("/random")
    public Author getAuthorRandom() {
        return service.getAuthorRandom();
    }

    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return service.getAuthorByName(name);
    }

    @GetMapping("")
    public List<Author> getAuthors() {
        return service.getAuthors();
    }

    //DELETE
    @DeleteMapping("/remove/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
    }

    //PUT
    @PutMapping("/update")
    public void updateAuthor(@RequestBody Author author) {
        service.updateAuthor(author);
    }
}
