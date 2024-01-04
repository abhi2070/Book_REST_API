package com.api.book.bootrestbook.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.Services.BookService;
import com.api.book.bootrestbook.entities.Book;


@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

//get method for books.
    // @GetMapping("/books")
    // public List<Book> getBooks(){
    //     return this.bookService.getAllBooks();
    // }
//get method with responce
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list=bookService.getAllBooks();
        if (list.size() <=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }



//get request for single book
    // @GetMapping("/books/{id}")
    // public Book getBooks(@PathVariable("id") int id){
    //     return bookService.getBookByID(id);
    // }
//get request for simgle book with responce
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id){
        Book book=bookService.getBookByID(id);
        if (book==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }



//adding a book
    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book book){
    //     Book b = this.bookService.addBook(book);
    //     System.out.println(book);
    //     return b;
    // }
//Adding a book with responce
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b=null;
        try{
            b = this.bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



//delete book handler
    // @DeleteMapping("/books/{bookId}")
    // public void deleteBook(@PathVariable("bookId") int bookId){
    //    this.bookService.deleteBook(bookId);
    // }
//Delete book handler with responce
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
       try{
        this.bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }



//update book handler
    // @PutMapping("/books/{bookId}")
    // public Book updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId){
    //     this.bookService.updateBook(book, bookId);
    //     return book;
    // }
////update book handler with responce
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId){
        try{
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
