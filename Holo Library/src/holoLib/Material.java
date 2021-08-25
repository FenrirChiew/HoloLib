package holoLib;

import java.util.GregorianCalendar;

public abstract class Material {
    /********** Properties **********/
    protected String materialTitle;
    protected String materialID;
    protected String materialAuthor;
    protected String materialPublisher;
    protected GregorianCalendar materialPublicationDate;
    protected double borrowFees;
    protected String borrowStatus;
    private static int totalMaterials = 0;
    private static int MAX_GRACE_PERIOD_IN_DAY = 30;

    /********** Constructors **********/
    protected Material() {
        this("", "", "", "", null, 0.0, "");
        totalMaterials++;
    }

    protected Material(String materialTitle, String materialID, String materialAuthor, String materialPublisher,
            GregorianCalendar materialPublicationDate, double borrowFees, String borrowStatus) {
        this.materialTitle = materialTitle;
        this.materialID = materialID;
        this.materialAuthor = materialAuthor;
        this.materialPublisher = materialPublisher;
        this.materialPublicationDate = materialPublicationDate;
        this.borrowFees = borrowFees;
        this.borrowStatus = borrowStatus;
        totalMaterials++;
    }

    /********** Accessors & Mutators **********/

    /********** Methods **********/
}
