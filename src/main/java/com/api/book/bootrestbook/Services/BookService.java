package com.api.book.bootrestbook.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //commenting our fake things because we are now adding databases to API.
    //private static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Core Java","xyz"));
    //     list.add(new Book(36,"Core html","pqr"));
    //     list.add(new Book(42,"Core css","abc"));
    // }

    //get all book
    public List<Book> getAllBooks(){
        //return list;
        //we are also doing typecasting here
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookByID(int id){
//Before adding databases 
        // Book book=null;
        // try{
        //     book=list.stream().filter(e->e.getId()==id).findFirst().get();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }
        // return book;
//After adding databases
        Book book=null;
        try{
            //book=list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding the book.
    public Book addBook(Book b){
//Before adding databases
        // list.add(b);
        // return b;
//After adding databases
        Book result=bookRepository.save(b);
        return result;
    }

    //delete a book
    public void deleteBook(int bid){
//Before adding databases
        //list.stream().filter(book ->book.getId()!=bid).
       //collect(Collectors.toList());
//After adding databases
       bookRepository.deleteById(bid);
    }

    //update a book
    public void updateBook(Book book, int bookId){
//Before adding databases
    //    list = list.stream().map(b->{
    //         if (b.getId()==bookId) {
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
//After adding databases
        book.setId(bookId);
        bookRepository.save(book);
    }
}