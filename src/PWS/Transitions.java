package PWS;

import javafx.util.Duration;

public class Transitions {

    private String startString; // defining variables
    private int startInt;
    private int duration;

    public Transitions(String start, int duration){
        this.duration = duration;
        try{
            startInt = Integer.parseInt(start); //turn string into integer
            startString = null;
        }
        catch(NumberFormatException nfe){
            startInt = 0;
            startString = "trigger"; // transitions manually triggered
        }
    }

    public Duration getDuration() { //getters
        if(duration < 0){
            return Duration.INDEFINITE; //no duration set
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
