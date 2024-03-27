package menu;

import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
*
*menite?ná postava, zatia? iba jedna varianta
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class CharSelection extends JLabel {

    public CharSelection() {
        
        ImageIcon imageIcon = new ImageIcon("res/pics/player/idle2/4.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(46 * 4, 73 * 4,  java.awt.Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
        this.setText("Igor");
        this.setFont(new Font("MV Boli", Font.BOLD, 30));
        this.setForeground(Color.white);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setSize(600, 600);
        this.setOpaque(false);
    }
}
