package com.sts.services;

import com.sts.entities.Book;
import com.sts.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;
    public BookService() {
        super();
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book>getAllBooks() {
        return bookRepository.getAllBooks();
    }
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    public Book getBookById(Integer id) {
        Optional<Book>optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()) {
            return null;
        }
        return optionalBook.get();
    }
    public List<Book> deleteBookByIdAndAuthor(Integer id,String author) {
        Book book = bookRepository.findByIdAndAuthor(id,author);
        bookRepository.deleteById(book.getId());
        return bookRepository.getAllBooks();
    }
    public List<Book> deleteBookById(Integer id) {
        bookRepository.deleteById(id);
        return bookRepository.getAllBooks();
    }

    @Transactional
    public Book updateBookById(Integer id,Book book) {
        Optional<Book> oldBook = bookRepository.findById(id);
        if(oldBook.isEmpty()) {
            return null;
        }
        bookRepository.updateAuthorByBookId(book.getAuthor(),id);
        entityManager.refresh(oldBook.get()); // this or flush() forces the persistence context to update with the changes if we
        // have written custom query
        //We required @Transactional annotation because we want to call the flush or refresh method otherwise spring will consider
        // these methods as outside the context of transaction and will throw error.
        return bookRepository.findById(id).get();
    }
}
