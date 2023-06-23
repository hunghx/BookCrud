package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> list ;

    public BookService() {
        list = new ArrayList<>();
    }

    public List<Book> getAll (){
        return list;
    }
    // add + update
    public void save(Book book){
        if(findById(book.getId())==null){
            // them moi book
            list.add(book);
            System.out.println("them moi thanh cong");
        }else {
            // cap nhat
            list.set(list.indexOf(findById(book.getId())),book);
        }
    }
    public Book findById(int id){
        for (Book b: list) {
            if(b.getId()==id){
                // id existed
                return b;
            }
        }
        return null;
    }
    public void delete(int idDel){
        if (findById(idDel)==null){
            System.err.println("id khong ton tai");
        }else {
            // xoas dduwocj
            list.remove(findById(idDel));
            System.out.println("xoa thanh cong");
        }
    }
}
