package PWS;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Slide {
    Fonts fonts;
    Colors colors;
    Transitions transitions;

    ArrayList<TextView> textViewArrayList;
    ArrayList<Shape> shapeArrayList;
    ArrayList<Image> imageArrayList;
    ArrayList<Audio> audioArrayList;
//    ArrayList<Video> videoArrayList;

    Pane pane;

    public Slide(Fonts fonts, Colors colors, Transitions transitions){
        this.fonts = fonts;
        this.colors = colors;
        this.transitions = transitions;

        this.audioArrayList = new ArrayList<>();
        this.imageArrayList = new ArrayList<>();
        this.shapeArrayList = new ArrayList<>();
        this.textViewArrayList = new ArrayList<>();
//        this.videoArrayList = new ArrayList<>();
    }

    public void add(Audio audio){
        this.audioArrayList.add(audio);
    }

    public void add(Image image){
        this.imageArrayList.add(image);
    }

    public void add(Shape shape){
        this.shapeArrayList.add(shape);
    }

    public void add(TextView textView){
        this.textViewArrayList.add(textView);
    }

//    public void add(Video video){
//        this.videoArrayList.add(video);
//    }

    public Pane getSlidePane(){
        pane = new Pane();
        for(TextView textView : textViewArrayList){
            pane.getChildren().add(textView);
        }
        for(Shape shape : shapeArrayList){
            pane.getChildren().add(shape.getShape());
        }
        for(Image image : imageArrayList){
            pane.getChildren().add(image.getImageView());
        }
//        for(Video video : videoViewArrayList){
//            pane.getChildren().add(video);
//        }
        return pane;
    }
}
