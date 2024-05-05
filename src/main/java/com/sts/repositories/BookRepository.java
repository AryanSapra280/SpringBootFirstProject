package com.sts.repositories;

import com.sts.entities.Book;
import jakarta.transaction.Transactional;
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
    @Modifying
    @Query("update Book b set b.author=:author where b.id=:id")
    @Transactional
    void updateAuthorByBookId(@Param("author")String author,@Param("id")Integer id);
}
