package holoLib;

public class Member {
    private String name; 
    private LibraryCard libraryCard;
    private static int totalMember = 0;
    private boolean isMember; // check is it member, need?

    public Member(){
        this.name = "";
    }

    public Member(String name, LibraryCard libraryCard){
        this.name = name;
        totalMember++;
     
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static int getTotalMember(){
        return totalMember;
    }

    private void registerMembership(){
        
    }

}
