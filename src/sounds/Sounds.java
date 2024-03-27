package sounds;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
/**
*
*trieda zabezpe?ujúca zvukové efekty
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class Sounds {
    private static Clip clipBgMusic;
    private static Clip clipSwordSound;
    /**
    *
    *na?íta zvukové efekty zo súborov
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public Sounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File swordSound = new File("res/sounds/Sword.wav");
        File bgMusic = new File("res/sounds/Music.wav");

        AudioInputStream audioStreamSwordSound = AudioSystem.getAudioInputStream(swordSound);
        AudioInputStream audioStreamBgMusic = AudioSystem.getAudioInputStream(bgMusic);

        clipSwordSound = AudioSystem.getClip();
        clipBgMusic = AudioSystem.getClip();

        clipSwordSound.open(audioStreamSwordSound);
        clipBgMusic.open(audioStreamBgMusic);

        setVolume(clipBgMusic, 0.2f);
        setVolume(clipSwordSound, 1.0f);
    }
    /**
    *
    *spustí hudbu 
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void playMusic() {
        clipBgMusic.start();
    }
    /**
    *
    *spustí zvukový efekt seknutia me?om 
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void playSwordSound() {
        clipSwordSound.setMicrosecondPosition(0);
        clipSwordSound.start();
    }
    /**
    *
    *ukon?í prehrávanie zvuku
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void quitSounds() {
        clipBgMusic.close();
        clipSwordSound.close();
    }
    /**
    *
    *chatgpt kod na zmenu hlasitosti, chcel som to spravit sam ale bol potrebny prepocet s logaritmami
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void setVolume(Clip clip, float volume) {
        if (clip != null) {
            if (volume < 0.0f) {
                volume = 0.0f;
            } else if (volume > 1.0f) {
                volume = 1.0f;
            }

            FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float)(Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }
    /**
    *
    *zmení hlasitos? na želanú úrove?
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void changeMusicVolume(int value) {
        setVolume(clipBgMusic, ((float)value) / 100);
    }
}
