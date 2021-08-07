package holoLib;

import java.util.Date;

public class Book extends ReadingMaterial {
    /*Data Field*/
    private String type;

    /*Constructor*/
    public Book(){}

    public Book(String code, String title, String language, String author, String publisher, Date publicationDate, double price, String status, String type) {
        super(code, title, language, author, publisher, publicationDate, price, status);
        this.type = type;
    }

    /*Getter & Setter*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Book Type: " + type;
    }
}
