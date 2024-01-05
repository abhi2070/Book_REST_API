package com.api.book.bootrestbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    //To create constructor or getter setter select all variables and do right click the go to source Action.
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    private String title;
    private String Author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        Author = author;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", Author=" + Author + "]";
    }

}
