package com.example.springhibernatebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/books")
@Component
class DataLoader {


    private final BookRepository bookRepository;

    //private List<Book> books = new ArrayList<>();

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PostConstruct
    private void loadData(){
        bookRepository.saveAll(
                List.of(
                        new Book("Fullstack React: The Complete Guide to ReactJS and Friends"),
                        new Book("Война и Мир"),
                        new Book("Nolyn: The Rise and Fall, Book 1"),
                        new Book("Анна Каренина"),
                        new Book("American Marxism"),
                        new Book("Billy Summers"),
                        new Book("Dark Roads: A Novel"),
                        new Book("Once There Were Wolves"),
                        new Book("If You Tell: A True Story of Murder, Family Secrets, and the Unbreakable Bond of Sisterhood"),
                        new Book("Greenlights")
                ));
    }

    @GetMapping
    Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> putBook(@PathVariable String id, @RequestBody Book book) {
        return (!bookRepository.existsById(id)) ?
                new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED) :
                new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);
    }

}