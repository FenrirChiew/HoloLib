package holoLib;

import java.util.Date;

public class Newspaper extends ReadingMaterial{
    /*Data Field*/
    private String newspaperType;

    /*Constructor*/
    public Newspaper(){}

    public Newspaper(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, Date readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialStatus, String newspaperType) {
        super(readingMaterialCode, readingMaterialTitle, readingMaterialLanguage, readingMaterialAuthor, readingMaterialPublisher, readingMaterialPublicationDate, readingMaterialPrice, readingMaterialStatus);
        this.newspaperType = newspaperType;
    }

    /*Getter & Setter*/
    public String getNewspaperType() {
        return newspaperType;
    }

    public void setNewspaperType(String newspaperType) {
        this.newspaperType = newspaperType;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Newspaper Type: " + newspaperType;
    }
}
