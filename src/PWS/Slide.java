package PWS;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Slide {
    Fonts fonts; //defining variables
    Colors colors;
    Transitions transitions;

    ArrayList<TextView> textViewArrayList;
    ArrayList<ShapePws> shapePwsArrayList;
    ArrayList<ImagePws> imageArrayList;
    ArrayList<Audio> audioArrayList;
    ArrayList<VideoPlayer> videoArrayList;

    Pane pane;

    public Slide(Fonts fonts, Colors colors, Transitions transitions){ //constructor
        this.fonts = fonts;
        this.colors = colors;
        this.transitions = transitions;

        this.audioArrayList = new ArrayList<>();
        this.imageArrayList = new ArrayList<>();
        this.shapePwsArrayList = new ArrayList<>();
        this.textViewArrayList = new ArrayList<>();
        this.videoArrayList = new ArrayList<>();
    }

    public void add(Audio audio){
        this.audioArrayList.add(audio);
    } //adding elements contained in slide

    public void add(ImagePws image){
        this.imageArrayList.add(image);
    }

    public void add(ShapePws shapePws){
        this.shapePwsArrayList.add(shapePws);
    }

    public void add(TextView textView){
        this.textViewArrayList.add(textView);
    }

    public void add(VideoPlayer videoPlayer){
        this.videoArrayList.add(videoPlayer);
    }

    public Pane getSlidePane(){ //getter method
        pane = new Pane();
        for(TextView textView : textViewArrayList){
            pane.getChildren().add(textView.getTextFlowNode());
        }
        for(ShapePws shapePws : shapePwsArrayList){
            pane.getChildren().add(shapePws.getShape());
        }
        for(ImagePws image : imageArrayList){
            pane.getChildren().add(image.getImageView());
        }
        for(VideoPlayer videoPlayer : videoArrayList){
            pane.getChildren().add(videoPlayer.getPane());
        }
        return pane;
    }
}
