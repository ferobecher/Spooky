package menu;

import main.GameFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
*
*zobrazí tla?idlá
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class MenuButtonsPanel extends JPanel {
    public MenuButtonsPanel(GameFrame gameFrame) {
        this.setBackground(null);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setSize(800, 900);
        this.add(new Menu(gameFrame));
        this.setVisible(true);
    }
}