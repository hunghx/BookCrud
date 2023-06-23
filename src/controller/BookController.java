package controller;

import model.Book;
import service.BookService;

import java.util.List;

public class BookController {
    protected BookService bookService;
    public BookController() {
        bookService= new BookService();
    }
    public List<Book> findAll(){
        return bookService.getAll();
    }
    public void  save(Book book){
        bookService.save(book);
    }
    public Book findById(int id){
        return bookService.findById(id);
    }
    public void delete(int idDel){
        bookService.delete(idDel);
    }
}
