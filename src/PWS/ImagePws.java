package PWS;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagePws {

    private ImageView imageView;

    private Position position;
    private String path;

    public ImagePws(Position position, String path) throws NullPointerException{
        this.imageView = new ImageView(new javafx.scene.image.Image(this.getClass().getResource(path).toExternalForm()));
        this.imageView.setX(position.getX());
        this.imageView.setY(position.getY());
        this.imageView.setFitWidth(position.getX2()-position.getX());
        this.imageView.setFitHeight(position.getY2()-position.getY());
        this.path = path;
        this.position = position;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
