package menu;

import main.GameFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
/**
*
*panel na zobrazenie tla?idiel a slideru na hlasitoš? hudby
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class Menu extends JLayeredPane {
    /**
    *
    *zobrazí tla?idlá a slider na hlasitos? hudby
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public Menu(GameFrame gameFrame) {
        
        JLabel name = new JLabel();
        name.setLayout(new BorderLayout());
        name.setText("SPOOOOKY");
        name.setFont(new Font("MV Boli", Font.BOLD, 80));
        name.setForeground(Color.white);
        name.setVerticalTextPosition(JLabel.TOP);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setOpaque(false);
        name.setBackground(null);

        JLabel buttons = new JLabel(); 
        buttons.setBounds(300, 180, 200, 400);
        buttons.setLayout(new GridLayout(4, 1, 0, 30));
        buttons.add(new StartButton(gameFrame));
        buttons.add(new OptionsButton());
        buttons.add(new ExitButton());
        buttons.setOpaque(false);
        buttons.setBackground(null);

        MusicSlider musicSlider = new MusicSlider();
        buttons.add(musicSlider.getSlider());

        this.add(name);
        this.add(buttons);
    }
}
