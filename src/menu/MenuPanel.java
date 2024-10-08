package menu;

import main.GameFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/**
*
*trieda na vytvorenie panelu zastre�uj�ceho ?al�ie menu panely
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class MenuPanel extends JLayeredPane {
    private JLabel bg;
    private GameFrame gameFrame;
    /**
    *
    *rozdel� obrazovku na 3 panely a zobraz� pozadie
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public MenuPanel(GameFrame gameFrame) throws Exception {
        this.gameFrame = gameFrame;
        this.setLayout(null);
        this.setBounds(0, 0, 1600, 900);

        //background
        this.bg = new JLabel("", new ImageIcon("res/pics/bg/spooky.png"), JLabel.CENTER);
        this.bg.setPreferredSize(new Dimension(100, 100));
        this.bg.setOpaque(true);
        this.bg.setBounds(0, 0, 1600, 900);
        add(this.bg, JLayeredPane.DEFAULT_LAYER);

        //name
        JLabel name = new JLabel();
        name.setSize(1600, 300);
        name.setText("SPOOOKY");
        name.setFont(new Font("MV Boli", Font.BOLD, 130));
        name.setForeground(Color.black);
        name.setVerticalTextPosition(JLabel.BOTTOM);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.BOTTOM);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setOpaque(false);
        name.setBackground(null);


        //creates three panels to split screen
        JPanel splitLeft = new JPanel();
        splitLeft.setLayout(new BorderLayout());
        splitLeft.setVisible(true);
        splitLeft.add(new CharSelectionPanel());
        splitLeft.setBackground(null);
        splitLeft.setBounds(0, 200, 800, 600);
        splitLeft.setOpaque(false);
        this.add(splitLeft, JLayeredPane.PALETTE_LAYER);

        JPanel splitRight = new JPanel();
        splitRight.setLayout(new BorderLayout());
        splitRight.setVisible(true);
        splitRight.add(new MenuButtonsPanel(gameFrame));
        splitRight.setBackground(null);
        splitRight.setBounds(800, 200, 800, 600);
        splitRight.setOpaque(false);
        this.add(splitRight, JLayeredPane.PALETTE_LAYER);

        JPanel splitTop = new JPanel();
        splitTop.setLayout(new BorderLayout());
        splitTop.setVisible(true);
        splitTop.add(name);
        splitTop.setBackground(null);
        splitTop.setBounds(0, 0, 1600, 300);
        splitTop.setOpaque(false);
        this.add(splitTop, JLayeredPane.PALETTE_LAYER);

    }
}   
