package holoLib;

public class MeetingRoom extends Facility {
    /********** Properties **********/
    private Schedule meetingRoomSchedule = null;
    private int roomCapacity = 0;
    private static int totalRooms = 0;

    /********** Constructors **********/
    public MeetingRoom() {
        super();
        totalRooms++;
    }

    public MeetingRoom(String facilityName, String facilityID, String facilityType, Schedule meetingRoomSchedule,
            int roomCapacity) {
        super(facilityName, facilityID, facilityType);
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
    public String toString() {
        return super.toString() + "\nSchedule Info: " + meetingRoomSchedule.toString() + "Room Capacity: "
                + roomCapacity;
    }
}
