package holoLib;

public abstract class Facility {
    private String facilityName = "";
    private String facilityID = "";
    private Schedule facilitySchedule;
    private boolean isReserved = false;
    private static int totalFacilityQTY = 0;

    protected Facility() {
        totalFacilityQTY++;
    }

    protected Facility(String facilityName, String facilityID, Schedule facilitySchedule, boolean isReserved) {
        this.facilityName = facilityName;
        this.facilityID = facilityID;
        this.facilitySchedule = facilitySchedule;
        this.isReserved = isReserved;
        totalFacilityQTY++;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public Schedule getFacilitySchedule() {
        return facilitySchedule;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public static int getTotalFacilityQTY() {
        return totalFacilityQTY;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public void setFacilitySchedule(Schedule facilitySchedule) {
        this.facilitySchedule = facilitySchedule;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public static void setTotalFacilityQTY(int totalFacilityQTY) {
        Facility.totalFacilityQTY = totalFacilityQTY;
    }

    public String toString() {
        return "Facility Name: " + facilityName + "\nFacility ID: " + facilityID + "\nSchedule Info: "
                + facilitySchedule.toString() + "\nReserved Status: " + isReserved;
    }
}
