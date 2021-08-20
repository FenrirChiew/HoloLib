package holoLib;

public class Area extends Facility {
    /********** Properties **********/
    private int maxSeats;
    private Seat[] seats;
    private static int totalArea;

    /********** Constructors **********/
    public Area() {
        this(0);
        createSeats();
        totalArea++;
    }

    public Area(int maxSeats) {
        this.maxSeats = maxSeats;
        createSeats();
        totalArea++;
    }

    /********** Accessors & Mutators **********/
    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public static int getTotalSeats() {
        return totalArea;
    }

    /********** Methods **********/
    public void createSeats() {
        seats = new Seat[maxSeats];

        for (int i = 0; i < seats.length; i++) {
            seats[i].setSeatNO(String.format("%03d", i));
        }
    }

    public void displayCurrentVisitors() {
        System.out.println("Current Visitors");
        System.out.println("================");

        for (int i = 0; i < seats.length; i++) {
            if (seats[i].isReserved() == true) {
                System.out.println("Seat " + seats[i].getSeatNO() + ": " + seats[i].getCurrentUser().getMemberID());
            }
        }
    }

    @Override
    public void makeReservation(Member member) {
        reservationList[reservationList.length] = member;
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "Maximum Seats: " + maxSeats;
    }
}
