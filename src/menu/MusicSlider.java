package menu;
import sounds.Sounds;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
/**
*
*slider na zmenu hlasitosti hudby
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class MusicSlider implements ChangeListener {
    private JSlider slider;
    /**
    *
    *nastaví polohu a vlastnosti slidera
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public MusicSlider() {

        this.slider = new JSlider(0, 100, 20);
        this.slider.setPreferredSize(new Dimension(400, 200));
        this.slider.setOrientation(SwingConstants.HORIZONTAL);
        this.slider.addChangeListener(this);
        this.slider.setBackground(null);
        this.slider.setOpaque(false);
    }
    /**
    *
    *pri interakcii so sliderom zmení hlasitos? hudby
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    @Override
    public void stateChanged(ChangeEvent e) {
        Sounds.changeMusicVolume(this.slider.getValue());
    }
    /**
    *
    *vráti slider pre použitie v iných triedach
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public JSlider getSlider() {
        return this.slider;
    }
}
