package holoLib;

public class Room extends Facility {
    /********** Properties **********/
    private int roomCapacity;
    private Schedule schedule;
    private static int totalRooms = 0;

    /********** Constructors **********/
    public Room() {
        this("", "", "", "", 0.0, new Member[] {}, 0, new Schedule());
        totalRooms++;
    }

    public Room(String facilityName, String facilityID, String facilityType, String equipments, double reservationFees,
            Member[] reservationList, int roomCapacity, Schedule schedule) {
        super(facilityName, facilityID, facilityType, equipments, reservationFees, reservationList);
        this.roomCapacity = roomCapacity;
        this.schedule = schedule;
        totalRooms++;
    }

    /********** Accessors & Mutators **********/
    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public static int getTotalRooms() {
        return totalRooms;
    }

    /********** Methods **********/
    public void displayPendingReservation() {
        System.out.println("Pending Reservation");
        System.out.println("===================");

        for (int i = 1; i < reservationList.length; i++) {
            if (schedule.searchTimeslotbySlotID(String.format("S00%02d", i)).isReserved() == true) {
                System.out
                        .println(String.format("S00%02d", i) + " ("
                                + String.format("%-9s",
                                        schedule.searchTimeslotbySlotID(String.format("S00%02d", i)).getWeekdays())
                                + String.format("%02d:00",
                                        schedule.searchTimeslotbySlotID(String.format("S00%02d", i)).getStartTime())
                                + " ~ "
                                + String.format("%02d:00",
                                        schedule.searchTimeslotbySlotID(String.format("S00%02d", i)).getEndTime())
                                + "): " + reservationList[i].getMemberID());
            }
        }
    }

    @Override
    public void makeReservation(Member member) {
        // schedule.searchTimeslotbySlotID(slotID);
        reservationList[reservationList.length] = member;
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nRoom Capacity: " + roomCapacity;
    }
}
