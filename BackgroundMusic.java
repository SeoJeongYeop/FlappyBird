package flappyBird;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/* BGM and Sound Effect Play Class
 *  
 * MenuPage BGM: 	Menu - Drawn to Life Soundtrack 		(https://www.youtube.com/watch?v=y05eGkzppD8)
 * StagePage BGM: 	Creationhall - Drawn to Life Soundtrack (https://www.youtube.com/watch?v=pAhrEdoHoEA)
 * GamePage BGM: 	Title Theme - Drawn to Life Soundtrack 	(https://www.youtube.com/watch?v=VQVooI4NUhk)
 * ResultPage BGM: 	Gameover - Drawn to Life Soundtrack 	(https://www.youtube.com/watch?v=nNrd7aj38eQ)
 */
public class BackgroundMusic {

	public Clip clip;
	public boolean isPlayed = true;

	public void stopMusic() {
		// stop music
		if (clip != null) {
			clip.stop();
		}
	}

	public void playMusic(String music, boolean repeat) {
		if (!isPlayed) {
			return;
		}
		stopMusic();

		try {
			AudioInputStream audioInput; // for reading audio file, open
			audioInput = AudioSystem.getAudioInputStream(getClass().getResource("./musics/" + music));
			clip = AudioSystem.getClip();
			clip.open(audioInput); // play music
			clip.start(); // play music at the same time. need to sound effect
			if (repeat) { // if repeat is true, music play loop.
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			audioInput.close();
		} catch (Exception e) {
			// Most of Exception occurs when file isn't exist.
			System.out.println(music + " file isn't exist on the path! check file name and .wav");
		}
	}

}
