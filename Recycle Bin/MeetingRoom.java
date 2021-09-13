package holoLib;

public class MeetingRoom extends Facility {
    /********** Properties **********/
    private Schedule meetingRoomSchedule;
    private int roomCapacity;
    private static int totalRooms = 0;

    /********** Constructors **********/
    public MeetingRoom() {
        super();
        meetingRoomSchedule = null;
        roomCapacity = 0;
        totalRooms++;
    }

    public MeetingRoom(String facilityName, String facilityID, String facilityType, String equipments,
            Schedule meetingRoomSchedule, int roomCapacity) {
        super(facilityName, facilityID, facilityType, equipments);
        this.meetingRoomSchedule = meetingRoomSchedule;
        this.roomCapacity = roomCapacity;
        totalRooms++;
    }

    /********** Accessors & Mutators **********/
    public Schedule getFacilitySchedule() {
        return meetingRoomSchedule;
    }

    public void setMeetingRoomSchedule(Schedule meetingRoomSchedule) {
        this.meetingRoomSchedule = meetingRoomSchedule;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public static int getTotalRooms() {
        return totalRooms;
    }

    /********** Methods **********/
    @Override
    public void makeAppointment() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return super.toString() + "\nSchedule Info: " + meetingRoomSchedule.toString() + "Room Capacity: "
                + roomCapacity;
    }
}
