package com.applicaton.Book.Model.dataBase;

import com.applicaton.Book.Model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
