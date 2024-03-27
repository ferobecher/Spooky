package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
*
*panel vykres?ujúci menite?nú postavu, momentálne ale bez možnosti výberu
*@version 1.0
*@author František Becher <becherferko@gmail.com>
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
