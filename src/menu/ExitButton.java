package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sounds.Sounds;
/**
*
*tla?idlo na zatvorenie hry, moment�lne ale sl��i len na vypnutie zvukov
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class ExitButton extends MenuButtons implements ActionListener {
    public ExitButton() {
        this.addActionListener(this);

        this.setText("EXIT");
        this.setBounds(200, 290, 100, 50);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Sounds.quitSounds();
    }
}