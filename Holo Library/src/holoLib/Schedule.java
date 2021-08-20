package holoLib;

public class Schedule {
    /********** Properties **********/
    private String scheduleID;
    private Timeslot[][] timeslots;
    private static final int TOTAL_OPERATION_DAYS_PER_WEEK = 7;
    private static final int TOTAL_TIMESLOTS_PER_DAY = 12;
    private static int totalSchedule = 0;

    /********** Constructors **********/
    public Schedule() {
        scheduleID = null;
        createTimeslots();
        totalSchedule++;
    }

    public Schedule(String scheduleID) {
        this.scheduleID = scheduleID;
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

    public void displayScheduleTempleted() {
        System.out.printf("++===========");
        for (int j = 0; j < timeslots[0].length; j++) {
            System.out.printf("+=======");
        }
        System.out.printf("++\n");

        System.out.printf("||           ");
        for (int j = 0; j < timeslots[0].length; j++) {
            System.out.printf("| %02d:00 ", timeslots[0][j].getStartTime(), timeslots[0][j].getEndTime());
        }
        System.out.printf("||\n");

        System.out.printf("||           ");
        for (int j = 0; j < timeslots[0].length; j++) {
            System.out.printf("|   ~   ");
        }
        System.out.printf("||\n");

        System.out.printf("||           ");
        for (int j = 0; j < timeslots[0].length; j++) {
            System.out.printf("| %02d:00 ", timeslots[0][j].getEndTime());
        }
        System.out.printf("||\n");

        for (int i = 0; i < timeslots.length; i++) {
            System.out.printf("++-----------");
            for (int j = 0; j < timeslots[0].length; j++) {
                System.out.printf("+-------");
            }
            System.out.printf("++\n");

            System.out.printf("||           ");
            for (int j = 0; j < timeslots[i].length; j++) {
                System.out.printf("| %5s ", timeslots[i][j].getSlotID());
            }
            System.out.printf("||\n");

            System.out.printf("|| %-9s ", Weekdays.values()[i]);
            for (int j = 0; j < timeslots[i].length; j++) {
                System.out.printf("|       ");
            }
            System.out.printf("||\n");

            System.out.printf("||           ");
            for (int j = 0; j < timeslots[i].length; j++) {
                System.out.printf("|   %c   ", timeslots[i][j].isReserved() == true ? '\u2718' : '\u2714');
            }
            System.out.printf("||\n");
        }

        System.out.printf("++===========");
        for (int j = 0; j < timeslots[0].length; j++) {
            System.out.printf("+=======");
        }
        System.out.printf("++\n");
    }

    public Timeslot searchTimeslotbySlotID(String slotID) {
        for (int i = 0; i < timeslots.length; i++) {
            for (int j = 0; j < timeslots[i].length; j++) {
                if (timeslots[i][j].getSlotID().matches(slotID)) {
                    return timeslots[i][j];
                }
            }
        }

        return null;
    }

    public boolean reserveTimeslot(String slotID) {
        if (searchTimeslotbySlotID(slotID) == null) {
            return false;
        } else {
            searchTimeslotbySlotID(slotID).setReserved(true);
            return true;
        }
    }

    /********** toString() method **********/
    @Override
    public String toString() {
        return "Schedule ID: " + scheduleID + "\nTotal Available Timeslots: " + checkTotalAvailableTimeslots();
    }
}
