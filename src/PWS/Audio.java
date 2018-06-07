package PWS;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

//	Sound newSound = new Sound("../resources/example.mp3");
//	newSound.play();

public class Audio {
	private static MediaPlayer mediaPlayer;
	private boolean looping; // Setting up variable to toggle looping

	public Audio(String path, boolean loop) {
		this.looping = loop;
		this.mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(path).toExternalForm()));
		this.mediaPlayer.setOnEndOfMedia(() -> {
			this.mediaPlayer.stop(); //ends the audio stream after media duration is completed
			if (this.looping) { //immediate replay if looping is toggled on
				this.mediaPlayer.play();
			}
		});
	}

	public void play(){
		this.mediaPlayer.stop(); //stops playing previous instance of audio
		this.mediaPlayer.play(); //plays audio file
	}

	public void stop(){
		this.mediaPlayer.stop();
	} //stops audio

	public void stopAudioLoop() {
		this.looping = false;
	} //sets boolean to false to end looping

}