package holoLib;

public abstract class Facility {
    /********** Properties **********/
    protected String facilityName;
    protected String facilityID;
    protected String facilityType;
    protected String equipments;
    protected double reservationFees;
    protected Member[] reservationList;
    protected static int totalFacilities = 0;

    /********** Constructors **********/
    protected Facility() {
        this("", "", "", "", 0.0, new Member[]{});
        totalFacilities++;
    }

    protected Facility(String facilityName, String facilityID, String facilityType, String equipments,
            double reservationFees, Member[] reservationList) {
        this.facilityName = facilityName;
        this.facilityID = facilityID;
        this.facilityType = facilityType;
        this.equipments = equipments;
        this.reservationFees = reservationFees;
        this.reservationList = reservationList;
        totalFacilities++;
    }

    /********** Accessors & Mutators **********/
    // public String getFacilityName() {
    //     return facilityName;
    // }

    // public void setFacilityName(String facilityName) {
    //     this.facilityName = facilityName;
    // }

    // public String getFacilityID() {
    //     return facilityID;
    // }

    // public void setFacilityID(String facilityID) {
    //     this.facilityID = facilityID;
    // }

    // public String getFacilityType() {
    //     return facilityType;
    // }

    // public void setFacilityType(String facilityType) {
    //     this.facilityType = facilityType;
    // }

    // public static int getTotalFacilityQTY() {
    //     return totalFacilities;
    // }

    // public String getEquipments() {
    //     return equipments;
    // }

    // public void setEquipments(String equipments) {
    //     this.equipments = equipments;
    // }

    // public double getReservationFees() {
    //     return reservationFees;
    // }

    // public void setReservationFees(double reservationFees) {
    //     this.reservationFees = reservationFees;
    // }

    // public Member[] getReservationList() {
    //     return reservationList;
    // }

    // public void setReservationList(Member[] reservationList) {
    //     this.reservationList = reservationList;
    // }

    // public static int getTotalFacilities() {
    //     return totalFacilities;
    // }

    /********** Methods **********/
    public abstract void makeReservation(Member member);

    // toString() method
    @Override
    public String toString() {
        return "Facility Name: " + facilityName + "\nFacility ID: " + facilityID + "\nFacility Type: " + facilityType
                + "\nReservation Fees: " + reservationFees + "\nEquipments: " + equipments;
    }
}
