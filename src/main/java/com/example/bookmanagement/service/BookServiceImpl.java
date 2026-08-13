package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Book;

import com.example.bookmanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }
}
