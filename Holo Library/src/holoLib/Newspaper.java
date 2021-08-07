package holoLib;

public class Newspaper extends ReadingMaterial{
    /*Data Field*/
    private String type;

    /*Getter & Setter*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Newspaper Type: " + type;
    }
}
