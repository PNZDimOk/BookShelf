package com.koshelev.BookShelf.models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_shelf_id")
    private BookShelf bookShelf;

    public Book() {
    }


    public Book(String title, String author, String description, User user, BookShelf bookShelf) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.user = user;
        this.bookShelf = bookShelf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
