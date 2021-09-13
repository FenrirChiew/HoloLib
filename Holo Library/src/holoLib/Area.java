package holoLib;

public class Area extends Facility {
    /********** Properties **********/
    private int maxSeats;
    private Seat[] seats;
    private static int totalArea;

    /********** Constructors **********/
    public Area() {
        this("", "", "", "", 0.0, null, 0);
        createSeats();
        totalArea++;
    }

    public Area(String facilityName, String facilityID, String facilityType, String equipments,
            double reservationFees, Member[] reservationList, int maxSeats) {
        super(facilityName, facilityID, facilityType, equipments, reservationFees, reservationList);
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
            seats[i] = new Seat(String.format("ST%03d", i + 1), null);
        }
    }

    public void displaySeats() {
        int rowLength = 10;
        int colLength = seats.length / rowLength;

        System.out.println("+-------------------+");
        System.out.printf("| Facility ID %5s |\n", facilityID);

        for (int i = 0; i < colLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                System.out.print("+-------+ ");
            }
            System.out.println();

            for (int j = 0; j < rowLength; j++) {
                System.out.printf("| %5s | ", seats[j + i * rowLength].getSeatNO());
            }
            System.out.println();

            for (int j = 0; j < rowLength; j++) {
                System.out.print("|       | ");
            }
            System.out.println();

            for (int j = 0; j < rowLength; j++) {
                System.out.printf("|   %c   | ", seats[j + i * rowLength].isReserved() == true ? '\u2718' : '\u2714');
            }
            System.out.println();

            for (int j = 0; j < rowLength; j++) {
                System.out.print("+-------+ ");
            }
            System.out.println();
        }
    }

    public void updateCurrentVisitors() {
        int totalVisitors = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i].isReserved() == true) {
                reservationList[totalVisitors] = seats[i].getCurrentUser();
                totalVisitors++;
            }
        }
    }

    public void displayCurrentVisitors() {
        updateCurrentVisitors();

        System.out.print("Current Visitors");

        if (reservationList.length == 0) {
            System.out.println(": null");
        } else {
            System.out.println("\n================");

            for (int i = 0; i < seats.length; i++) {
                if (seats[i].isReserved() == true) {
                    System.out.println("Seat " + seats[i].getSeatNO() + ": " + seats[i].getCurrentUser().getMemberID());
                }
            }
        }
    }

    @Override
    public void makeReservation(Member member) {
        // if current visitors == max seats --> cannot reserve
        reservationList[reservationList.length] = member;
    }

    @Override
    public void displayFacilityDetails() {
        System.out.println(toString());
        displayCurrentVisitors();
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "Maximum Seats: " + maxSeats;
    }
}
