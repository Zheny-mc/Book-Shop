package com.applicaton.Book.controllers;

import com.applicaton.Book.Model.dataBase.BookRepository;
import com.applicaton.Book.Model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookConrol {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book) throws URISyntaxException {
        Book savedClient = bookRepository.save(book);
        return ResponseEntity.created(new URI("/book/" + savedClient.getId())).body(savedClient);
    }
/*
    @PostMapping
    public ResponseEntity addBookToCard(@RequestBody Book book) throws URISyntaxException {
        Book savedClient = bookRepository.save(book);
        return ResponseEntity.created(new URI("/book/card/" + savedClient.getId())).body(savedClient);
    }
*/
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book currentBook = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        currentBook = bookRepository.save(book);

        return ResponseEntity.ok(currentBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
