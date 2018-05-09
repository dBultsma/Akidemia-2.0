package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

//	Sound newSound = new Sound("../resources/example.mp3");
//	newSound.play();

public class Sound{
	private static MediaPlayer mediaPlayer;
	private boolean looping;

	public Sound(String path, boolean loop) {
		this.looping = loop;
		this.mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(path).toExternalForm()));
		this.mediaPlayer.setOnEndOfMedia(() -> {
			this.mediaPlayer.stop();
			if (this.looping) {
				this.mediaPlayer.play();
			}
		});
	}

	public void play(){
		this.mediaPlayer.stop();
		this.mediaPlayer.play();
	}

	public void stop(){
		this.mediaPlayer.stop();
	}

	public void stopAudioLoop() {
		this.looping = false;
	}

}