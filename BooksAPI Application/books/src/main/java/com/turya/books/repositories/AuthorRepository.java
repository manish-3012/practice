package com.turya.books.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turya.books.domain.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>{

	Iterable<AuthorEntity> ageLessThan(int age);
	
	@Query("SELECT a from AuthorEntity a where a.age > ?1")  // ?1 means the first parameter
	Iterable<AuthorEntity> ageGreaterThan(int age);
}
