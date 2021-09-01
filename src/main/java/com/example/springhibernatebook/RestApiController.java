package com.example.springhibernatebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
                        new Book("Fullstack React: The Complete Guide to ReactJS and Friends",
                                "Anthony Accomazzo",
                                "Leanpub",
                                "2020-01-13",
                                "https://images-na.ssl-images-amazon.com/images/I/51CMUOgy8HL._SX218_BO1,204,203,200_QL40_FMwebp_.jpg")
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