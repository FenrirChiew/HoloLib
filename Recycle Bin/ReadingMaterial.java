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
    private String readingMaterialStatus = "returned";
    //private String readingMaterialType;
    private static int nextReadingMaterialCode = 001;
    private static int totalNumOfReadingMaterial; // readingMaterial.size() can get

    private static int MAX_BORROW_DATE; // no getter & setter

    /*Constructor*/
    // no arguments
    public ReadingMaterial(){
        this("", "", "", "", "", "", 0.0, "");
    }

    // with arguments
    public ReadingMaterial(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, String readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialType) {
        if(nextReadingMaterialCode < 999){
            this.readingMaterialCode = String.format("RA%03d", nextReadingMaterialCode);
        }
        else{
            nextReadingMaterialCode -= 999;
            this.readingMaterialCode = String.format("RB%03d", nextReadingMaterialCode);
        }
        this.readingMaterialTitle = readingMaterialTitle;
        this.readingMaterialLanguage = readingMaterialLanguage;
        this.readingMaterialAuthor = readingMaterialAuthor;
        this.readingMaterialPublisher = readingMaterialPublisher;
        this.readingMaterialPublicationDate = readingMaterialPublicationDate;
        this.readingMaterialPrice = readingMaterialPrice;
        //this.readingMaterialType = readingMaterialType;

        nextReadingMaterialCode++;
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

/*    public String getReadingMaterialType() {
        return readingMaterialType;
    }

    public void setReadingMaterialType(String readingMaterialType) {
        this.readingMaterialType = readingMaterialType;
    }*/

    public static int getTotalNumOfReadingMaterial() {
        return totalNumOfReadingMaterial;
    }

    public static int getMaxBorrowDate() {
        return MAX_BORROW_DATE;
    }

    /*Method*/
    public ReadingMaterial addNew(){
        ReadingMaterial tempReadM = new ReadingMaterial();
        Scanner scanner = new Scanner(System.in);
        boolean result = false;

        String code;
        if(nextReadingMaterialCode < 999){
            code = String.format("RA%03d", nextReadingMaterialCode);
        }
        else{
            nextReadingMaterialCode -= 999;
            code = String.format("RB%03d", nextReadingMaterialCode);
        }

        // prompt user enter reading material details
        String title;
        do {
            System.out.print("Enter reading material title: ");
            title = scanner.nextLine();
            result = title.matches("[A-Za-z]$");
        }while(!result);

        result = false;
        String language;
        do{
            System.out.print("Enter reading material written language: ");
            language = scanner.next();
            // let them choose?
        }while(!result);


        System.out.print("Enter reading material author: ");
        String author = scanner.next();

        System.out.print("Enter reading material publisher: ");
        String publisher = scanner.next();

        System.out.print("Enter reading material publisher date (DD/MM/YYYY): ");
        String publisherDate = scanner.next();

        System.out.print("Enter reading material price: ");
        double price = scanner.nextDouble();

        //* let user choose?
        System.out.println("1) Book (Novel, manga, ...)");
        System.out.println("2) Magazine");
        System.out.println("3) Newspaper");
        System.out.print("Enter types choice: ");
        String types = scanner.next();

        // Ask user to confirm add this reading material
        System.out.print("Confirm add this reading material ? (Y/N): ");
        char confirm = scanner.next().charAt(0);

        // If confirm is 'Y'
        if(confirm == 'Y'){
            // store in obj
            //tempReadM = new ReadingMaterial(code, title, language, author, publisher, publisherDate, price, "None", types);
            System.out.println("This add reading material action has been success.");
        }
        // If confirm is 'N'
        else{
            System.out.println("This add reading material action has been repeal.");
        }
        //return tempReadM;
        return new ReadingMaterial(code, title, language, author, publisher, publisherDate, price, types);
        //return code, title, language, author, publisher, publisherDate, price, "None", types;
    }

    //public ReadingMaterial search(){} //status, can borrow or not

    /*
    public void display(ReadingMaterial[] tempReadM) {
        System.out.println("=--------------------=");
        System.out.println("|  Reading Material  |");
        System.out.println("=--------------------=");
        System.out.println(".+-------|------------------------------|----------|--------------------|-------------------------|----------------|----------|----------|-----------||");
        System.out.println("||  Code |            Title             | Language |        Author      |        Publisher        | Publisher Date |   Price  |  Status  |   Type    ||");
        System.out.println(".+-------|------------------------------|----------|--------------------|-------------------------|----------------|----------|----------|-----------||");

        //got problem because comment the type
        for (int i = 0; i < totalNumOfReadingMaterial; i++) {
            System.out.printf("||%6s |%30s |%10s |%20s |%25s |%15s |%7.2f |%9s |%10s ||"
                    , tempReadM[i].readingMaterialCode, tempReadM[i].readingMaterialTitle, tempReadM[i].readingMaterialLanguage
                    , tempReadM[i].readingMaterialAuthor, tempReadM[i].readingMaterialPublisher, tempReadM[i].readingMaterialPublicationDate
                    , tempReadM[i].readingMaterialPrice, tempReadM[i].readingMaterialStatus, tempReadM[i].getReadingMaterialType());
        }
        System.out.println(".+-------|------------------------------|----------|--------------------|-------------------------|----------------|----------|----------||");
    }

    @Override
    public String toString() {
        return "\nReading Material\n" +
                "================\n" +
                "Code: " + readingMaterialCode + "\n" +
                "Title: " + readingMaterialTitle +  "\n" +
                "Language: " + readingMaterialLanguage +  "\n" +
                "Author: " + readingMaterialAuthor +  "\n" +
                "Publisher: " + readingMaterialPublisher +  "\n" +
                "PublicationDate: " + readingMaterialPublicationDate + "\n" +
                "Price: " + readingMaterialPrice + "\n" +
                "Status: " + readingMaterialStatus + "\n";
    }
    */
}
