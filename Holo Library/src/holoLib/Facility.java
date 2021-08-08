package holoLib;

public abstract class Facility {
    /********** Properties **********/
    private String facilityName = null;
    private String facilityID = null;
    private String facilityType = null;
    private static int totalFacilities = 0;

    /********** Constructors **********/
    protected Facility() {
        totalFacilities++;
    }

    protected Facility(String facilityName, String facilityID, String facilityType) {
        this.facilityName = facilityName;
        this.facilityID = facilityID;
        this.facilityType = facilityType;
        totalFacilities++;
    }

    /********** Accessors & Mutators **********/
    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public static int getTotalFacilityQTY() {
        return totalFacilities;
    }

    /********** Methods **********/
    public String toString() {
        return "Facility Name: " + facilityName + "\nFacility ID: " + facilityID + "\nFacility Type: " + facilityType;
    }
}
