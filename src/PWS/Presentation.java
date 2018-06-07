package PWS;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Presentation {

    private Fonts fonts; //variables
    private Colors colors;

    private ArrayList<Meta> metaArrayList;
    private ArrayList<Slide> slideArrayList;

    private int slideNumber;

    public Presentation(Fonts fonts, Colors colors){ //constructor
        this.fonts = fonts;
        this.colors = colors;

        this.metaArrayList = new ArrayList<>();
        this.slideArrayList = new ArrayList<>();
    }

    public void add(Meta meta){
        this.metaArrayList.add(meta);
    } // adding meta and slides to presentation

    public void add(Slide slide){
        this.slideArrayList.add(slide);
    }

    public Pane getFirstSlide() { //defining slide 1 from sequence
        slideNumber = 0;
        return slideArrayList.get(slideNumber).getSlidePane();
    }

    public Pane getNextSlide() {
        if(slideNumber < slideArrayList.size() - 1){ //stops breaking out
            slideNumber++; //increases value to iterate through
        }
        return slideArrayList.get(slideNumber).getSlidePane();
    }

    public Pane getPreviousSlide() {
        if(slideNumber > 0){ // stops breaking out
            slideNumber--; // decreases to iterate
        }
        return slideArrayList.get(slideNumber).getSlidePane();
    }
}
