package holoLib;

public class Room extends Facility {
    /********** Properties **********/
    private int roomCapacity;
    private Schedule schedule;
    private static int totalRooms = 0;

    /********** Constructors **********/
    public Room() {
        this("", "", "", "", 0.0, null, 0);
        createSchedule();
        totalRooms++;
    }

    public Room(String facilityName, String facilityID, String facilityType, String equipments,
            double reservationFees, Member[] reservationList, int roomCapacity) {
        super(facilityName, facilityID, facilityType, equipments, reservationFees, reservationList);
        this.roomCapacity = roomCapacity;
        createSchedule();
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

    public void createSchedule() {
        schedule = new Schedule(String.format("SD%03d", Schedule.getTotalSchedule()));
    }

    public static int getTotalRooms() {
        return totalRooms;
    }

    /********** Methods **********/
    public void displayPendingReservation() {
        System.out.print("Pending Reservation");

        if (reservationList.length == 0) {
            System.out.println(": null");
        } else {
            for (int i = 0; i < reservationList.length; i++) {
                System.out.println("\n===================");
                if (schedule.searchTimeslotbySlotID(String.format("TS%03d", i + 1)).isReserved() == true) {
                    System.out.println(String.format("TS%03d", i + 1) + " ("
                            + String.format("%-9s",
                                    schedule.searchTimeslotbySlotID(String.format("TS%03d", i + 1)).getWeekdays())
                            + String.format("%02d:00",
                                    schedule.searchTimeslotbySlotID(String.format("TS%03d", i + 1)).getStartTime())
                            + " ~ "
                            + String.format("%02d:00",
                                    schedule.searchTimeslotbySlotID(String.format("TS%03d", i + 1)).getEndTime())
                            + "): " + reservationList[i].getMemberID());
                }
            }
        }
    }

    @Override
    public void makeReservation(Member member) {
        // schedule.searchTimeslotbySlotID(slotID);
        reservationList[reservationList.length] = member;
    }

    @Override
    public void displayFacilityDetails() {
        System.out.println(toString());
        System.out.println(schedule.toString());
        displayPendingReservation();
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nRoom Capacity: " + roomCapacity;
    }
}
