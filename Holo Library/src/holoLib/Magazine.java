package holoLib;

import java.util.Date;

public class Magazine extends ReadingMaterial{
    /*Data Field*/
    private int magazineVolume;

    /*Constructor*/
    public Magazine(){}

    public Magazine(String readingMaterialCode, String readingMaterialTitle, String readingMaterialLanguage, String readingMaterialAuthor, String readingMaterialPublisher, Date readingMaterialPublicationDate, double readingMaterialPrice, String readingMaterialStatus, int magazineVolume) {
        super(readingMaterialCode, readingMaterialTitle, readingMaterialLanguage, readingMaterialAuthor, readingMaterialPublisher, readingMaterialPublicationDate, readingMaterialPrice, readingMaterialStatus);
        this.magazineVolume = magazineVolume;
    }

    /*Getter & Setter*/
    public int getMagazineVolume() {
        return magazineVolume;
    }

    public void setMagazineVolume(int magazineVolume) {
        this.magazineVolume = magazineVolume;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Magazine Volume: No." + magazineVolume;
    }
}
