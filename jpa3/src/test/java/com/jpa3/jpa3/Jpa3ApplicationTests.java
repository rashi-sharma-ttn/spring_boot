package com.jpa3.jpa3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class Jpa3ApplicationTests {

	@Autowired
	AuthorRepo authorRepo;
	@Autowired
	BookRepo bookRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testManyToManyRel(){
		Author author = new Author();
		author.setAuthorName("William Shakespeare");
		Address address = new Address();
		address.setLocation("Bandra");
		address.setState("Mumbai");
		address.setStreetNo(13);
		author.setAddress(address);
		HashSet<Book> books= new HashSet<Book>();
		Book book = new Book();
		book.setBookName("A time to kill");
		books.add(book);
		authorRepo.save(author);
	}

	@Test
	public void testOneToManyMapping(){
		Author a= new Author();
		a.setAuthorName("Jai");
		Address add = new Address();
		add.setLocation("Agra");
		add.setState("UP");
		add.setStreetNo(14);
		a.setAddress(add);
		HashSet<Book> books= new HashSet<Book>();
		Book b = new Book();
		b.setBookName("Once Upon a Time");
		books.add(b);
		a.setBook(books);
		authorRepo.save(a);
	}
}
