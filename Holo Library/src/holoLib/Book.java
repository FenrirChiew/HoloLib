package holoLib;

import java.util.Date;

public class Book extends ReadingMaterial {
    /*Data Field*/
    private String bookType;

    /*Constructor*/
    public Book(){}

    public Book(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, Date readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialStatus, String bookType) {
        super(readingMaterialCode, readingMaterialTitle, readingMaterialLanguage, readingMaterialAuthor, readingMaterialPublisher, readingMaterialPublicationDate, readingMaterialPrice, readingMaterialStatus);
        this.bookType = bookType;
    }

    /*Getter & Setter*/
    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Book Type: " + bookType;
    }
}
