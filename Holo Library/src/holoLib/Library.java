package holoLib;

public class Library {
    private Account account;
    private Facility facility;
    private ReadingMaterial readingMaterial;
    
    //Constructor without arguments
    public Library(){

    }

    //Constructor with arguments
    public Library(Account account, Facility facility, ReadingMaterial readingMaterial){
        this.account = account;
        this.facility = facility;
        this.readingMaterial = readingMaterial;
    }

    
}
