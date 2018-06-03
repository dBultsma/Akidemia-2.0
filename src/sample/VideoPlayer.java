package sample;

//import com.oracle.tools.packager.Log;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;

import java.io.File;

/**
 * VideoPlayer class.
 *
 * The video player is created in a VBox and preserves the aspect ratio when you resize the pane or application window
 */
public class VideoPlayer {

    private Media media;
    private MediaPlayer player;
    private MediaView mediaView;
    private String fileName;
    private VBox vBox;
    private File file;
    private VideoControl controls;

    // Example media player

    /**
     * Creates an example video player.
     *
     * @param scene The scene that you want to place the video player on
     */

    public VideoPlayer(Scene scene) {
        this(scene, "example");
    }

    /**
     * Creates a video player for the provided file.
     *
     * Uses the current directory to mp4 files.
     * @param scene The scene that you want to place the video player on
     * @param fileName The mp4 file name, do not place the '.mp4' extension in the string provided
     */
    public VideoPlayer(Scene scene, String fileName) {
        this(scene, fileName, System.getProperty("user.dir"));
    }

    // Creates a video player for the provided file and file path


    /**
     * Creates a video player for the provided file and file path.
     *
     * @param scene The scene that you want to place the video player on
     * @param fileName The mp4 file name, do not place the '.mp4' extension in the string provided
     * @param filePath The file path for where the mp4 file is located
     */
    public VideoPlayer(Scene scene, String fileName, String filePath) {

        setFile(filePath);
        setFileName(fileName);

        vBox = new VBox();

        try{
            media = new Media(file.toURI().toURL().toString() + fileName + ".mp4");
            player = new MediaPlayer(media);
            mediaView = new MediaView(player);


            // Places media player into a new pane
            Pane mvPane = new Pane();
            mvPane.getChildren().add(mediaView);
            mvPane.setStyle("-fx-background-color: black;");
            vBox.getChildren().add(mvPane);

            // Preserves aspect ratio while resizing the window
            mediaView.fitWidthProperty().bind(vBox.widthProperty());
            mediaView.fitHeightProperty().bind(vBox.heightProperty());
            mediaView.setPreserveRatio(true);

            playVideo();
        }
        catch (Exception e) {
            System.out.println("Error: Invalid file path");
        }

    }

    /**
     * Returns the video player file
     * @return File object
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the video player file from the provided file path
     * @param filePath The file path the mp4 file is located
     */
    public void setFile(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Returns the video player pane
     * @return VBox object
     */
    public VBox getPane() {
        return vBox;
    }

    /**
     * Returns the file name of the video
     * @return String object
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name of the video
     * @param fileName The file name of the mp4 file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the Media object of the video player
     * @return Media object
     */
    public Media getMedia() {
        return media;
    }

    /**
     * Returns the MediaView object, the view of the media player
     * @return
     */
    public MediaView getMediaView() {
        return mediaView;
    }

    /**
     * Returns the MediaPlayer object, the player of the video
     * @return
     */
    public MediaPlayer getMediaPlayer() {
        return player;
    }

    /**
     * Stops the video
     */
    public void stopVideo() {
        player.stop();
    }

    /**
     * Plays the video
     */
    public void playVideo() {
        player.play();
    }

    /**
     * Pauses the video
     */
    public void pauseVideo() {
        player.pause();
    }

    /**
     * Enables the controls for the video
     *
     * DO NOT call this function if you are creating your own custom video player controller
     */
    public void enableVideoControls() {
        controls = new VideoControl(player, mediaView, vBox);
    }

}
