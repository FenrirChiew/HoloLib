package holoLib;

public class Schedule {
    /********** Properties **********/
    private String scheduleID = null;
    private String scheduleName = null;
    private Timeslot[][] timeslots = null;
    private static int totalSchedule = 0;
    private static final int TOTAL_OPERATION_DAYS_PER_WEEK = 7;
    private static final int TOTAL_TIMESLOTS_PER_DAY = 12;

    /********** Constructors **********/
    public Schedule() {
        createTimeslots();
        totalSchedule++;
    }

    public Schedule(String scheduleID, String scheduleName) {
        this.scheduleID = scheduleID;
        this.scheduleName = scheduleName;
        createTimeslots();
        totalSchedule++;
    }

    /********** Accessors & Mutators **********/
    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public static int getTotalSchedule() {
        return totalSchedule;
    }

    /********** Methods **********/
    public void createTimeslots() {
        timeslots = new Timeslot[TOTAL_OPERATION_DAYS_PER_WEEK][TOTAL_TIMESLOTS_PER_DAY];
        for (int i = 0; i < timeslots.length; i++) {
            for (int j = 0; j < timeslots[i].length; j++) {
                timeslots[i][j] = new Timeslot(new int[] { i, j });
            }
        }
    }

    public int checkTotalAvailableTimeslots() {
        int availableTimeSlots = 0;

        for (int i = 0; i < timeslots.length; i++) {
            for (int j = 0; j < timeslots[i].length; j++) {
                availableTimeSlots += timeslots[i].length;

                if (timeslots[i][j].isReserved() == true) {
                    availableTimeSlots--;
                }
            }
        }

        return availableTimeSlots;
    }

    public void displaySchedule() {

    }

    /********** toString() method **********/
    public String toString() {
        return "Schedule ID: " + scheduleID + "\nSchedule Name: " + "\nTotal Available Timeslots: "
                + checkTotalAvailableTimeslots();
    }
}
