package com.api.book.bootrestbook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int authorId;
        private String firstName;
        private String lastName;
        private String language;
        
        @OneToOne(mappedBy = "author")
        private Book book;

        public int getAuthorId() {
            return authorId;
        }
        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getLanguage() {
            return language;
        }
        public void setLanguage(String language) {
            this.language = language;
        }
        public Book getBook() {
            return book;
        }
        public void setBook(Book book) {
            this.book = book;
        }


}
