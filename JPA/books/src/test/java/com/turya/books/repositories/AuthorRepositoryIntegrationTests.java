package com.turya.books.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.turya.books.TestDataUtil;
import com.turya.books.domain.Author;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {
	
	private AuthorRepository underTest;
	
	@Autowired
	public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
		this.underTest = underTest;
	}
	
	@Test
	public void testThatAuthorCanBeCreatedAndRecalled() {
		Author author = TestDataUtil.createTestAuthor();
		underTest.save(author);
		Optional<Author> result = underTest.findById(author.getId());
		assertThat(result).isPresent();
		assertThat(result.get()).isEqualTo(author);
	}
	
	@Test
	public void testThatMultipleAuthorCanBeCreatedAndRecalled() {
		Author authorA = TestDataUtil.createTestAuthor();
		underTest.save(authorA);
		Author authorB = TestDataUtil.createTestAuthorB();
		underTest.save(authorB);
		Author authorC = TestDataUtil.createTestAuthorC();
		underTest.save(authorC);
		
		Iterable<Author> result = underTest.findAll();
		assertThat(result)
			.hasSize(3)
			.containsExactly(authorA, authorB, authorC);
		
	}
	
	@Test
    public void testThatAuthorCanBeUpdated() {
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.save(authorA);
        authorA.setName("UPDATED");
        underTest.save(authorA);
        Optional<Author> result = underTest.findById(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }
//	
	@Test
    public void testThatAuthorCanBeDeleted() {
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.save(authorA);
        underTest.deleteById(authorA.getId());
        Optional<Author> result = underTest.findById(authorA.getId());
        assertThat(result).isEmpty();
    }
	
	@Test
    public void testThatGetAuthorsWithAgeLessThan() {
        Author testAuthorA = TestDataUtil.createTestAuthor();
        underTest.save(testAuthorA);
        Author testAuthorB = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorB);
        Author testAuthorC = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorC);

        Iterable<Author> result = underTest.ageLessThan(65);
        assertThat(result).containsExactly(testAuthorB);
    }
	
	@Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
        Author testAuthorA = TestDataUtil.createTestAuthor();
        underTest.save(testAuthorA);
        Author testAuthorB = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorB);
        Author testAuthorC = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorC);

        Iterable<Author> result = underTest.findAuthorsWithAgeGreaterThan(65);
        assertThat(result).containsExactly(testAuthorA, testAuthorC);
    }
}
