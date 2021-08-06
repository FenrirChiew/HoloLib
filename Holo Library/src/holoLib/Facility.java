package holoLib;

public abstract class Facility {
    /********** Properties **********/
    private String facilityName = null;
    private String facilityID = null;
    private Schedule facilitySchedule = null;
    private static int totalFacilities = 0;

    /********** Constructors **********/
    protected Facility() {
        totalFacilities++;
    }

    protected Facility(String facilityName, String facilityID, Schedule facilitySchedule) {
        this.facilityName = facilityName;
        this.facilityID = facilityID;
        this.facilitySchedule = facilitySchedule;
        totalFacilities++;
    }

    /********** Accessors & Mutators **********/
    public String getFacilityName() {
        return facilityName;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public Schedule getFacilitySchedule() {
        return facilitySchedule;
    }

    public static int getTotalFacilityQTY() {
        return totalFacilities;
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

    /********** Methods **********/
    // Pending construction

    /********** toString() method **********/
    public String toString() {
        return "Facility Name: " + facilityName + "\nFacility ID: " + facilityID + "\nSchedule Info: "
                + facilitySchedule.toString();
    }
}
