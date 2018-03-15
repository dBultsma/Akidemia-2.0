package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

//	Sound newSound = new Sound("../resources/example.mp3");
//	newSound.play();

public class Sound{
	MediaPlayer mediaPlayer;

	public Sound(String path){
		mediaPlayer = new MediaPlayer(new Media(new File(path).toURI().toString()));
		this.mediaPlayer.setOnEndOfMedia(() -> this.mediaPlayer.stop());
	}

	public void play(){
		this.mediaPlayer.stop();
		this.mediaPlayer.play();
	}

}