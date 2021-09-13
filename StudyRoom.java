package holoLib;

public class StudyRoom extends Facility {
    /********** Properties **********/
    private int roomCapacity;
    private Seat[] seats;
    private static int totalStudyArea = 0;

    /********** Constructors **********/
    public StudyRoom() {
        roomCapacity = 0;
        seats = null;
        totalStudyArea++;
    }

    public StudyRoom(String facilityName, String facilityID, String facilityType, String equipments, int roomCapacity) {
        super(facilityName, facilityID, facilityType, equipments);
        this.roomCapacity = roomCapacity;
        createSeats();
        totalStudyArea++;
    }

    /********** Accessors & Mutators **********/
    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public static int getTotalStudyArea() {
        return totalStudyArea;
    }

    /********** Methods **********/
    @Override
    public void makeAppointment() {
        // TODO Auto-generated method stub

    }

    public void createSeats() {
        seats = new Seat[roomCapacity];
        for (int i = 0; i < seats.length; i++) {
            seats[i].setSeatNO(String.format("%03d", i));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nRoom Capacity: " + roomCapacity;
    }
}
