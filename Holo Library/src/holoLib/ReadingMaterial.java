package holoLib;

import java.util.Date;

public abstract class ReadingMaterial {
    /*Data Field*/
    private String readingMaterialCode;
    private String readingMaterialTitle;
    private String readingMaterialLanguage;
    private String readingMaterialAuthor;
    private String readingMaterialPublisher;
    private Date readingMaterialPublicationDate;
    private double readingMaterialPrice;
    private String readingMaterialStatus;
    private static int totalNumOfReadingMaterial = 0;

    private static int MAX_BORROW_DATE; // no getter & setter

    /*Constructor*/
    protected ReadingMaterial(){
        totalNumOfReadingMaterial++;
    }

    protected ReadingMaterial(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, Date readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialStatus) {
        this.readingMaterialCode = readingMaterialCode;
        this.readingMaterialTitle = readingMaterialTitle;
        this.readingMaterialLanguage = readingMaterialLanguage;
        this.readingMaterialAuthor = readingMaterialAuthor;
        this.readingMaterialPublisher = readingMaterialPublisher;
        this.readingMaterialPublicationDate = readingMaterialPublicationDate;
        this.readingMaterialPrice = readingMaterialPrice;
        this.readingMaterialStatus = readingMaterialStatus;

        totalNumOfReadingMaterial++;
    }

    /*Getter & Setter*/
    public String getReadingMaterialCode() {
        return readingMaterialCode;
    }

    public String getReadingMaterialTitle() {
        return readingMaterialTitle;
    }

    public String getReadingMaterialLanguage() {
        return readingMaterialLanguage;
    }

    public String getReadingMaterialAuthor() {
        return readingMaterialAuthor;
    }

    public String getReadingMaterialPublisher() {
        return readingMaterialPublisher;
    }

    public Date getReadingMaterialPublicationDate() {
        return readingMaterialPublicationDate;
    }

    public double getReadingMaterialPrice() {
        return readingMaterialPrice;
    }

    public String getReadingMaterialStatus() {
        return readingMaterialStatus;
    }

    public static int getTotalNumOfReadingMaterial(){
        return totalNumOfReadingMaterial;
    }

    public void setReadingMaterialCode(String readingMaterialCode) {
        this.readingMaterialCode = readingMaterialCode;
    }

    public void setReadingMaterialTitle(String readingMaterialTitle) {
        this.readingMaterialTitle = readingMaterialTitle;
    }

    public void setReadingMaterialLanguage(String readingMaterialLanguage) {
        this.readingMaterialLanguage = readingMaterialLanguage;
    }

    public void setReadingMaterialAuthor(String readingMaterialAuthor) {
        this.readingMaterialAuthor = readingMaterialAuthor;
    }

    public void setReadingMaterialPublisher(String readingMaterialPublisher) {
        this.readingMaterialPublisher = readingMaterialPublisher;
    }

    public void setReadingMaterialPublicationDate(Date readingMaterialPublicationDate) {
        this.readingMaterialPublicationDate = readingMaterialPublicationDate;
    }

    public void setReadingMaterialPrice(double readingMaterialPrice) {
        this.readingMaterialPrice = readingMaterialPrice;
    }

    public void setReadingMaterialStatus(String readingMaterialStatus) {
        this.readingMaterialStatus = readingMaterialStatus;
    }

    public static void setTotalNumOfReadingMaterial(int totalNumOfReadingMaterial) {
        ReadingMaterial.totalNumOfReadingMaterial = totalNumOfReadingMaterial;
    }

    /*Method*/
    public String toString() {
        return "Reading Material" +
                "================" +
                "Code: " + readingMaterialCode + "\n" +
                "Title: " + readingMaterialTitle +  "\n" +
                "Language: " + readingMaterialLanguage +  "\n" +
                "Author: " + readingMaterialAuthor +  "\n" +
                "Publisher: " + readingMaterialPublisher +  "\n" +
                "PublicationDate: " + readingMaterialPublicationDate + "\n" +
                "Price: " + readingMaterialPrice + "\n" +
                "Status: " + readingMaterialStatus + "\n";
    }
}
