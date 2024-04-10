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
	
	public static Book createTestBook() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .authorId(1L)
                .build();
    }
}
