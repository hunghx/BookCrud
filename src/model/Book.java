package model;

public class Book {
    private int id;
    private String name;
    private String author;
    private int totalPage;
    private double price;

    public Book() {
    }

    public Book(int id, String name, String author, int totalPage, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.totalPage = totalPage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID : "+id +"| Name: "+name +" | TotalPage : "+totalPage
                +"\nAuthor: "+ author + " | Price : " +price;
    }
}
