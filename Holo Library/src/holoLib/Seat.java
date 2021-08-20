package holoLib;

public class Seat {
    /********** Properties **********/
    private String seatNO;
    private Member currentUser;
    private boolean isReserved;
    private static int totalSeats;

    /********** Constructors **********/
    public Seat() {
        this("", new Member());
        isReserved = false;
        totalSeats++;
    }

    public Seat(String seatNO, Member currentUser) {
        this.seatNO = seatNO;
        this.currentUser = currentUser;
        isReserved = false;
        totalSeats++;
    }

    /********** Accessors & Mutators **********/
    public String getSeatNO() {
        return seatNO;
    }

    public void setSeatNO(String seatNO) {
        this.seatNO = seatNO;
    }

    public Member getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Member currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public static int getTotalSeats() {
        return totalSeats;
    }

    /********** Methods **********/
    // toString() method
    @Override
    public String toString() {
        return "Seat NO: " + seatNO + "\nCurrent User: " + currentUser + "\nReserved Status: " + isReserved;
    }
}
