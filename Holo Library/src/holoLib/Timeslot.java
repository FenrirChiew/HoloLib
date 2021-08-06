package holoLib;

public class Timeslot {
    /********** Properties **********/
    private String slotID = null;
    private int[] slotCoordinate = new int[] { 0, 0 };
    private Weekdays weekdays = null;
    private int startTime = 0;
    private int endTime = 0;
    private boolean isReserved = false;
    private static final int INITIAL_OPERATION_HOUR = 8;
    private static final int TIMESLOT_DURATION = 1;
    private static int totalSlots = 0;

    /********** Constructors **********/
    public Timeslot() {
        slotID = String.format("S00%02d", totalSlots + 1);
        totalSlots++;
    }

    public Timeslot(int[] slotCoordinate) {
        slotID = String.format("S00%02d", totalSlots + 1);
        this.slotCoordinate = slotCoordinate;
        weekdays = Weekdays.values()[slotCoordinate[0]];
        startTime = slotCoordinate[1] + INITIAL_OPERATION_HOUR;
        endTime = startTime + TIMESLOT_DURATION;
        totalSlots++;
    }

    /********** Accessors & Mutators **********/
    public String getSlotID() {
        return slotID;
    }

    public int[] getSlotCoordinate() {
        return slotCoordinate;
    }

    public Weekdays getWeekdays() {
        return weekdays;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    /********** Methods **********/

    /********** toString() method **********/
    public String toString() {
        return "Slot ID: " + slotID + "\nWeekday: " + weekdays + "\nStart Time: " + startTime + "\nEnd Time: " + endTime
                + "\nReserved Status: " + isReserved;
    }
}
