package holoLib;

public class Timeslot {
    /********** Properties **********/
    private String slotID;
    private int[] slotCoordinate;
    private Weekdays weekdays;
    private int startTime;
    private int endTime;
    private boolean isReserved;
    private static final int INITIAL_OPERATION_HOUR = 8;
    private static final int TIMESLOT_DURATION = 1;
    private static int totalSlots = 0;

    /********** Constructors **********/
    public Timeslot() {
        slotID = "";
        slotCoordinate = null;
        weekdays = null;
        startTime = 0;
        endTime = 0;
        isReserved = false;
        totalSlots++;
    }

    public Timeslot(String slotID, int[] slotCoordinate) {
        this.slotID = slotID;
        this.slotCoordinate = slotCoordinate;
        weekdays = Weekdays.values()[slotCoordinate[0]];
        startTime = slotCoordinate[1] + INITIAL_OPERATION_HOUR;
        endTime = startTime + TIMESLOT_DURATION;
        isReserved = false;
        totalSlots++;
    }

    /********** Accessors & Mutators **********/
    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
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

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    /********** Methods **********/
    public void displayTimeslots() {
        System.out.printf("+-------+\n");
        System.out.printf("| %5s |\n", slotID);
        System.out.printf("|       |\n");
        System.out.printf("|   %c   |\n", isReserved == true ? '\u2718' : '\u2714');
        System.out.printf("+-------+\n");
    }

    @Override
    public String toString() {
        return "Slot ID: " + slotID + "\nWeekday: " + weekdays + "\nStart Time: " + startTime + "\nEnd Time: " + endTime
                + "\nReserved Status: " + isReserved;
    }
}
