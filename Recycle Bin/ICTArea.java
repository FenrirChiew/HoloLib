package holoLib;

public class ICTArea extends Facility {
    /********** Properties **********/
    private int totalComputers;
    private Seat[] seats;
    private static int totalICTArea = 0;

    /********** Constructors **********/
    public ICTArea() {
        super();
        totalComputers = 0;
        seats = null;
        totalICTArea++;
    }

    public ICTArea(String facilityName, String facilityID, String facilityType, String equipments, int totalComputers) {
        super(facilityName, facilityID, facilityType, equipments);
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
    @Override
    public void makeAppointment() {
        // TODO Auto-generated method stub

    }

    public void createSeats() {
        seats = new Seat[totalComputers];
        for (int i = 0; i < seats.length; i++) {
            seats[i].setSeatNO(String.format("%03d", i));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Computers: " + totalComputers;
    }
}
