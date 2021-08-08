package holoLib;

public class ICTArea extends Facility {
    /********** Properties **********/
    private int totalComputers = 0;
    private Seat[] seats = null;
    private static int totalICTArea = 0;

    /********** Constructors **********/
    public ICTArea() {
        super();
        totalICTArea++;
    }

    public ICTArea(String facilityName, String facilityID, String facilityType, int totalComputers) {
        super(facilityName, facilityID, facilityType);
        this.totalComputers = totalComputers;
        createSeats();
        totalICTArea++;
    }

    /********** Accessors & Mutators **********/
    public int getTotalComputers() {
        return totalComputers;
    }

    public void setTotalComputers(int totalComputers) {
        this.totalComputers = totalComputers;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public static int getTotalICTArea() {
        return totalICTArea;
    }

    /********** Methods **********/
    public void createSeats() {
        seats = new Seat[totalComputers];
        for (int i = 0; i < seats.length; i++) {
            seats[i].setSeatNO(String.format("%03d", i));
        }
    }
}
