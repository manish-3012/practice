package com.turya.books.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.turya.books.TestDataUtil;
import com.turya.books.domain.Author;
import com.turya.books.domain.Book;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {
	
	private BookRepository underTest;
	
	@Autowired
	public BookRepositoryIntegrationTests(BookRepository underTest) {
		this.underTest = underTest;
	}
	
	@Test
	public void testThatBookCanBeCreatedAndRecalled() {
		Author author = TestDataUtil.createTestAuthor();
		Book book = TestDataUtil.createTestBook(author);
		underTest.save(book);
		Optional<Book> result = underTest.findById(book.getIsbn());
		assertThat(result).isPresent();
		assertThat(result.get()).isEqualTo(book);
	}
	
	@Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        
        Book bookA = TestDataUtil.createTestBook(author);
        underTest.save(bookA);

        Book bookB = TestDataUtil.createTestBookB(author);
        underTest.save(bookB);

        Book bookC = TestDataUtil.createTestBookC(author);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);
    }
//	
	@Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthor();
        
        Book bookA = TestDataUtil.createTestBook(author);
        underTest.save(bookA);

        bookA.setTitle("UPDATED");
        underTest.save(bookA);

        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }
//	
	@Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthor();
        
        Book bookA = TestDataUtil.createTestBook(author);
        underTest.save(bookA);

        underTest.deleteById(bookA.getIsbn());

        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isEmpty();
    }
}
