package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sounds.Sounds;
/**
*
*tla?idlo slúžiace na otváranie nastavení hry, ?o momentálne nieje implementované a do?asne slúži na testovanie prehrávania zvuku me?a
*@version 1.0
*@author František Becher <becherferko@gmail.com>
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