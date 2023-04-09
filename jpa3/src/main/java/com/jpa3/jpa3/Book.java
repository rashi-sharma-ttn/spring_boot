package com.jpa3.jpa3;
import jakarta.persistence.*;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;

    //    @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //    @ManyToMany(mappedBy = "books")
    //    private Set<Author> authors;
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}