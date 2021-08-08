package holoLib;

public class Seat {
    /********** Properties **********/
    private String seatNO = null;
    private Schedule seatSchedule = null;
    private static int totalSeats = 0;
    
    /********** Constructors **********/
    public Seat(){
        totalSeats++;
    }

    public Seat(String seatNO, Schedule seatSchedule){
        this.seatNO = seatNO;
        this.seatSchedule = seatSchedule;
        totalSeats++;
    }

    /********** Accessors & Mutators **********/
    public String getSeatNO() {
        return seatNO;
    }

    public void setSeatNO(String seatNO) {
        this.seatNO = seatNO;
    }

    public Schedule getSeatSchedule() {
        return seatSchedule;
    }

    public static int getTotalSeats() {
        return totalSeats;
    }

    /********** Methods **********/
    public String toString() {
        return super.toString();
    }
}
