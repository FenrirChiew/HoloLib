package holoLib;

public interface SearchBook {
    /********** Methods **********/
    void searchBookByTitle(String bookTitle);

    Book searchBookByID(String bookID);

    void searchBookByAuthor(String bookAuthor);

    void searchBookByPublisher(String bookPublisher);
}
