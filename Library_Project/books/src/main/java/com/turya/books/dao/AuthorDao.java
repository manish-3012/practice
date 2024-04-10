package com.turya.books.dao;

import java.util.List;
import java.util.Optional;

import com.turya.books.domain.Author;

public interface AuthorDao {
	
	void create(Author author);
	
	Optional<Author> findOne(long l);
	
	List<Author> find();
	
	void update(long id, Author author);
	
	void delete(long id);
}
