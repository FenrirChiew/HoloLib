package holoLib;

import java.util.GregorianCalendar;

public class Material {
    /********** Properties **********/
    protected String materialTitle;
    protected String materialID;
    protected String materialAuthor;
    protected String materialPublisher;
    protected GregorianCalendar materialPublicationDate;
    protected double materialPrice;
    private static int totalMaterials = 0;
    private static final int MAX_GRACE_PERIOD_IN_DAY = 30;

    /********** Constructors **********/
    protected Material() {
        this("", "", "", "", null, 0.0);
        totalMaterials++;
    }

    protected Material(String materialTitle, String materialID, String materialAuthor, String materialPublisher,
            GregorianCalendar materialPublicationDate, double materialPrice) {
        this.materialTitle = materialTitle;
        this.materialID = materialID;
        this.materialAuthor = materialAuthor;
        this.materialPublisher = materialPublisher;
        this.materialPublicationDate = materialPublicationDate;
        this.materialPrice = materialPrice;
        totalMaterials++;
    }

    /********** Accessors & Mutators **********/
    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getMaterialAuthor() {
        return materialAuthor;
    }

    public void setMaterialAuthor(String materialAuthor) {
        this.materialAuthor = materialAuthor;
    }

    public String getMaterialPublisher() {
        return materialPublisher;
    }

    public void setMaterialPublisher(String materialPublisher) {
        this.materialPublisher = materialPublisher;
    }

    public GregorianCalendar getMaterialPublicationDate() {
        return materialPublicationDate;
    }

    public void setMaterialPublicationDate(GregorianCalendar materialPublicationDate) {
        this.materialPublicationDate = materialPublicationDate;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public static int getTotalMaterials() {
        return totalMaterials;
    }

    public static int getMAX_GRACE_PERIOD_IN_DAY() {
        return MAX_GRACE_PERIOD_IN_DAY;
    }

    /********** Methods **********/
    @Override
    public String toString() {
        return "Material Title: " + materialTitle + "\nMaterial ID: " + materialID + "\nMaterial Author: "
                + materialAuthor + "\nMaterial Publisher: " + materialPublisher + "\nMaterial Publication Date: "
                + materialPublicationDate + "\nMaterial Price: " + materialPrice;
    }
}
