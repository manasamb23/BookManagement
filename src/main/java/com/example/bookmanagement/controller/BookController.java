package com.example.bookmanagement.controller;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // Book Management REST APIs
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(
                bookService.addBook(book),
                HttpStatus.CREATED
        );
    }
        @GetMapping
        public ResponseEntity<List<Book>> getAllBooks () {

        return ResponseEntity.ok(bookService.getAllBooks());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Book> getBookById(@PathVariable Long id) {
            return ResponseEntity.ok(bookService.getBookById(id));
        }
     // delete book
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        }
    }


