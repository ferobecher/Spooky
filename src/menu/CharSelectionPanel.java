package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
*
*panel vykres?uj�ci menite?n� postavu, moment�lne ale bez mo�nosti v�beru
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class CharSelectionPanel extends JPanel {
    public CharSelectionPanel() {
        this.setBackground(null);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setSize(600, 600);
        this.add(new CharSelection());
    }
}
