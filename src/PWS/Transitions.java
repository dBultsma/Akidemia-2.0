package PWS;

import javafx.util.Duration;

public class Transitions {

    private String startString;
    private int startInt;
    private int duration;

    public Transitions(String start, int duration){
        this.duration = duration;
        try{
            startInt = Integer.parseInt(start);
            startString = null;
        }
        catch(NumberFormatException nfe){
            startInt = 0;
            startString = "trigger";
        }
    }

    public Duration getDuration() {
        if(duration < 0){
            return Duration.INDEFINITE;
        }
        else{
            return Duration.millis(startInt + duration);
        }
    }

    public Duration getStart(){
        return Duration.millis(startInt);
    }

    public String getStartString() {
        return startString;
    }

    public int getStartInt() {
        return startInt;
    }
}
