package holoLib;

import java.util.Date;

public abstract class ReadingMaterial {
    /*Data Field*/
    private String code;
    private String title;
    private String language;
    private String author;
    private String publisher;
    private Date publicationDate;
    private double price;
    private String status;

    private static int MAX_BORROW_DATE;

    /*Constructor*/
    protected ReadingMaterial(){}

    protected ReadingMaterial(String code, String title, String language, String author, String publisher, Date publicationDate, double price, String status) {
        this.code = code;
        this.title = title;
        this.language = language;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.price = price;
        this.status = status;
    }

    /*Getter & Setter*/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getMaxBorrowDate() {
        return MAX_BORROW_DATE;
    }

    public static void setMaxBorrowDate(int maxBorrowDate) {
        MAX_BORROW_DATE = maxBorrowDate;
    }

    /*Method*/
    public String toString() {
        return "ReadingMaterial" +
                "===============" +
                "Code: " + code + "\n" +
                "Title: " + title +  "\n" +
                "Language: " + language +  "\n" +
                "Author: " + author +  "\n" +
                "Publisher: " + publisher +  "\n" +
                "PublicationDate: " + publicationDate + "\n" +
                "Price: " + price + "\n" +
                "Status: " + status + "\n";
    }
}
