package PWS;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Presentation {

    private Fonts fonts;
    private Colors colors;

    private ArrayList<Meta> metaArrayList;
    private ArrayList<Slide> slideArrayList;

    private int slideNumber;

    public Presentation(Fonts fonts, Colors colors){
        this.fonts = fonts;
        this.colors = colors;

        this.metaArrayList = new ArrayList<>();
        this.slideArrayList = new ArrayList<>();
    }

    public void add(Meta meta){
        this.metaArrayList.add(meta);
    }

    public void add(Slide slide){
        this.slideArrayList.add(slide);
    }

    public Pane getFirstSlide() {
        slideNumber = 0;
        return slideArrayList.get(slideNumber).getSlidePane();
    }

    public Pane getNextSlide() {
        if(slideNumber < slideArrayList.size() - 1){
            slideNumber++;
        }
        return slideArrayList.get(slideNumber).getSlidePane();
    }

    public Pane getPreviousSlide() {
        if(slideNumber > 0){
            slideNumber--;
        }
        return slideArrayList.get(slideNumber).getSlidePane();
    }
}
