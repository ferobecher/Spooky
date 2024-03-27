package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sounds.Sounds;
/**
*
*tla?idlo sl��iace na otv�ranie nastaven� hry, ?o moment�lne nieje implementovan� a do?asne sl��i na testovanie prehr�vania zvuku me?a
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class OptionsButton extends MenuButtons implements ActionListener {
    public OptionsButton() {
        this.addActionListener(this);

        this.setText("OPTIONS");
        this.setBounds(200, 220, 100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Sounds.playSwordSound();
    }
}