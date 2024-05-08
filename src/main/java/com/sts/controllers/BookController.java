package com.sts.controllers;

import com.sts.services.BookService;
import com.sts.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController() {
        super();
    }
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        if(books.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
//        return new ResponseEntity<Book>(books, HttpStatus.ACCEPTED);
        return ResponseEntity.of(Optional.ofNullable(books));
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        Book book = bookService.getBookById(id);
        return book;
    }
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}/{author}")
    public List<Book> deleteBookByIdAndAuthor(@PathVariable("id")Integer id,@PathVariable("author")String author) {
        return bookService.deleteBookByIdAndAuthor(id,author);
    }
    @DeleteMapping("/deleteBook/{id}")
    public List<Book> deleteBookById(@PathVariable("id")Integer id) {
        return bookService.deleteBookById(id);
    }

    @PutMapping("/update/{id}")
    public Book updateBookById(@PathVariable("id") Integer id, @RequestBody Book book) {
        return bookService.updateBookById(id,book);
    }
}
