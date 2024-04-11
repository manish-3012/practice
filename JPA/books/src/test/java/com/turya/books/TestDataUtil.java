package com.turya.books;

import com.turya.books.domain.Author;
import com.turya.books.domain.Book;

public final class TestDataUtil {

	private TestDataUtil() {
		
	}
	
	public static Author createTestAuthor() {
		return Author.builder()
				.id(1L)
				.name("Joan Darwy")
				.age(80)
				.build();
	}
	
	public static Author createTestAuthorB() {
		return Author.builder()
				.id(2L)
				.name("Surya Kumar")
				.age(60)
				.build();
	}

	public static Author createTestAuthorC() {
		return Author.builder()
				.id(3L)
				.name("Ranjit Singh")
				.age(70)
				.build();
	}
	
	public static Book createTestBook(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }
}
