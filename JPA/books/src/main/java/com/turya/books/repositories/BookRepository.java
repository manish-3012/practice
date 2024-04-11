package com.turya.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turya.books.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String>{

}
