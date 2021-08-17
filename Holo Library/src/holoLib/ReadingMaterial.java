package holoLib;

import java.util.Scanner;

public class ReadingMaterial {
    /*Data Field*/
    private String readingMaterialCode;
    private String readingMaterialTitle;
    private String readingMaterialLanguage;
    private String readingMaterialAuthor;
    private String readingMaterialPublisher;
    private String readingMaterialPublicationDate;
    private double readingMaterialPrice;
    private String readingMaterialStatus;
    private String readingMaterialType;
    private static int totalNumOfReadingMaterial = 0;

    private static int MAX_BORROW_DATE; // no getter & setter

    /*Constructor*/
    // no arguments
    protected ReadingMaterial(){
        this("", "", "", "", "", "", 0.0, "", "");
        totalNumOfReadingMaterial++;
    }

    // with arguments
    protected ReadingMaterial(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, String readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialStatus, String readingMaterialType) {
        this.readingMaterialCode = readingMaterialCode;
        this.readingMaterialTitle = readingMaterialTitle;
        this.readingMaterialLanguage = readingMaterialLanguage;
        this.readingMaterialAuthor = readingMaterialAuthor;
        this.readingMaterialPublisher = readingMaterialPublisher;
        this.readingMaterialPublicationDate = readingMaterialPublicationDate;
        this.readingMaterialPrice = readingMaterialPrice;
        this.readingMaterialStatus = readingMaterialStatus;
        this.readingMaterialType = readingMaterialType;

        totalNumOfReadingMaterial++;
    }

    /*Getter & Setter*/
    public String getReadingMaterialCode() {
        return readingMaterialCode;
    }

    public void setReadingMaterialCode(String readingMaterialCode) {
        this.readingMaterialCode = readingMaterialCode;
    }

    public String getReadingMaterialTitle() {
        return readingMaterialTitle;
    }

    public void setReadingMaterialTitle(String readingMaterialTitle) {
        this.readingMaterialTitle = readingMaterialTitle;
    }

    public String getReadingMaterialLanguage() {
        return readingMaterialLanguage;
    }

    public void setReadingMaterialLanguage(String readingMaterialLanguage) {
        this.readingMaterialLanguage = readingMaterialLanguage;
    }

    public String getReadingMaterialAuthor() {
        return readingMaterialAuthor;
    }

    public void setReadingMaterialAuthor(String readingMaterialAuthor) {
        this.readingMaterialAuthor = readingMaterialAuthor;
    }

    public String getReadingMaterialPublisher() {
        return readingMaterialPublisher;
    }

    public void setReadingMaterialPublisher(String readingMaterialPublisher) {
        this.readingMaterialPublisher = readingMaterialPublisher;
    }

    public String getReadingMaterialPublicationDate() {
        return readingMaterialPublicationDate;
    }

    public void setReadingMaterialPublicationDate(String readingMaterialPublicationDate) {
        this.readingMaterialPublicationDate = readingMaterialPublicationDate;
    }

    public double getReadingMaterialPrice() {
        return readingMaterialPrice;
    }

    public void setReadingMaterialPrice(double readingMaterialPrice) {
        this.readingMaterialPrice = readingMaterialPrice;
    }

    public String getReadingMaterialStatus() {
        return readingMaterialStatus;
    }

    public void setReadingMaterialStatus(String readingMaterialStatus) {
        this.readingMaterialStatus = readingMaterialStatus;
    }

    public String getReadingMaterialType() {
        return readingMaterialType;
    }

    public void setReadingMaterialType(String readingMaterialType) {
        this.readingMaterialType = readingMaterialType;
    }

    public static int getTotalNumOfReadingMaterial() {
        return totalNumOfReadingMaterial;
    }

    public static int getMaxBorrowDate() {
        return MAX_BORROW_DATE;
    }

    /*Method*/
    public ReadingMaterial add(){
        ReadingMaterial readingMaterial = new ReadingMaterial();
        Scanner scanner = new Scanner(System.in);

        String code = null;

        if(totalNumOfReadingMaterial + 1 < 999){
            code = String.format("RA%03d", totalNumOfReadingMaterial + 1);
        }
        else{
            code = String.format("RB%03d", totalNumOfReadingMaterial + 1 -999);
        }

        // prompt user enter reading material details
        System.out.print("Enter reading material title: ");
        String title = scanner.next();

        System.out.print("Enter reading material written language: ");
        String language = scanner.next();

        System.out.print("Enter reading material author: ");
        String author = scanner.next();

        System.out.print("Enter reading material publisher: ");
        String publisher = scanner.next();

        System.out.print("Enter reading material publisher date (DD/MM/YYYY): ");
        String publisherDate = scanner.next();

        System.out.print("Enter reading material publisher: ");
        double price = scanner.nextDouble();

        //* let user choose?
        System.out.print("Enter : ");
        String types = scanner.next();

        // Ask user to confirm add this reading material
        System.out.print("Confirm add this reading material ? (Y/N): ");
        char confirm = scanner.next().charAt(0);

        // If confirm is 'Y'
        if(confirm == 'Y'){
            // store in obj
            readingMaterial = new ReadingMaterial(code, title, language, author, publisher, publisherDate, price, "None", types);
            System.out.println("This add reading material action has been success.");
        }
        // If confirm is 'N'
        else{
            System.out.println("This add reading material action has been repeal.");
        }
        return readingMaterial;
    }

    public ReadingMaterial modify(){}

    public ReadingMaterial search(){

    }

    public void display(){

        System.out.println("=--------------------=");
        System.out.println("|  Reading Material  |");
        System.out.println("=--------------------=\n");
        System.out.println("+--");
        System.out.println("| Code | Title | Language | Author | Publisher | Publisher Date | Price | Status | Type |");

        for (int i = 0; i < totalNumOfReadingMaterial; i++) {

            System.out.println("| %s | %", readingMaterialCode,);

        }
        System.out.println("+--");
    }
    @Override
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
