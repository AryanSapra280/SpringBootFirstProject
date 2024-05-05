package com.sts.repositories;

import com.sts.entities.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{
    @Query("select b from Book b")
    List<Book> getAllBooks();
    Book findByIdAndAuthor(Integer id,String author);
}
