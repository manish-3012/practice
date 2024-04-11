package com.turya.books.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turya.books.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	Iterable<Author> ageLessThan(int age);
	
	@Query("SELECT a from Author a where a.age > ?1")  // ?1 means the first parameter
	Iterable<Author> findAuthorsWithAgeGreaterThan(int age);
}
