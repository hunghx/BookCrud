package run;

import config.InputMethods;
import controller.BookController;
import model.Book;

import java.util.List;

public class BookManager {
    private static BookController bookController = new BookController();

    public static void main(String[] args) {
        byte choice = 0;
        while (choice != 5) {
            System.out.println("===========MENU=============");
            System.out.println("1.  Danh sách tất cả cuốn sách");
            System.out.println("2.  Thêm sách");
            System.out.println("3.  Sửa sách");
            System.out.println("4.  Xóa sách");
            System.out.println("5.  Thoát");
            System.out.println("Nhập vào lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // hiển thị
                    displayAll();
                    break;
                case 2:
                    // thêm mới sách
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("thoát chương trình");
                    break;
                default:
                    System.err.println("nhập không hợp lệ , nhập lại");

            }
        }
    }
    public static void displayAll(){
        List<Book> list = bookController.findAll();
        if (list.size()==0){
            System.err.println("danh sách trống");
            return;
        }
        for (Book b: list) {
            System.out.println(b);
        }
    }
    public static void addBook(){
        Book book = new Book();
        // có id tự tăng
        book.setId(getNewId());
        System.out.println("Nhập tên mới");
        book.setName(InputMethods.getString());
        System.out.println("Nhập tên tác giả ");
        book.setAuthor(InputMethods.getString());
        System.out.println("Nhập số trang ");
        book.setTotalPage(InputMethods.getInteger());
        System.out.println("Nhập giá");
        book.setPrice(InputMethods.getDouble());
        bookController.save(book);
    }
    public static void editBook(){
        System.out.println("nhập vào id cần sửa");
        Book editBook = bookController.findById(InputMethods.getInteger());
        if(editBook==null){
            System.err.println("không tìm thấy id ");
            return;
        }
        // cho phép sửa
        System.out.println("Nhập tên mới");
        editBook.setName(InputMethods.getString());
        System.out.println("Nhập tên tác giả moi ");
        editBook.setAuthor(InputMethods.getString());
        System.out.println("Nhập số trang moi");
        editBook.setTotalPage(InputMethods.getInteger());
        System.out.println("Nhập giá moi");
        editBook.setPrice(InputMethods.getDouble());
        bookController.save(editBook);
    }
    public static void deleteBook(){
        System.out.println("nhập vào id cần xoa");
        int idDel = InputMethods.getInteger();
        // cho phep xoa
        bookController.delete(idDel);
    }
    public static int getNewId(){
        int max =0;
        for (Book b:bookController.findAll()) {
         if(max < b.getId()){
             max = b.getId();
         }
        }
        return max+1;
    }
}
