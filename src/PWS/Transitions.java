package PWS;

public class Transitions {

    private String start;
    private int duration;

    public Transitions(String start, int duration){
        this.start = start;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getStart() {
        return start;
    }
}
