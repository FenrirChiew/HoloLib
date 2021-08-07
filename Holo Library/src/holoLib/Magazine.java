package holoLib;

public class Magazine extends ReadingMaterial{
    /*Data Field*/
    private int volume;

    /*Constructor*/
    public Magazine(){}

    public Magazine(int volume) {
        this.volume = volume;
    }

    /*Getter & Setter*/
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /*Method*/
    @Override
    public String toString() {
        return super.toString() +
                "Magazine Volume: No." + volume;
    }
}
