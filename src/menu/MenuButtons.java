package menu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
*
*rodi?ovsk� trieda nastavuj�ca premenn� tla?idiel
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class MenuButtons extends JButton {
    public MenuButtons() {

        this.setFocusable(false);
        this.setFont(new Font("MV Boli", Font.BOLD, 15));
        this.setForeground(Color.black);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}
