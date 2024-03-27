package main;
import gameplay.GamePanel;
import menu.MenuPanel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
/**
*
*Trieda na vytvorenie a spravovanie framov a panelov
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class GameFrame extends JFrame {
    private final JPanel cardPanel;
    private final MenuPanel menuPanel;
    private final GamePanel gamePanel;
    private final CardLayout cardLayout;
    /**
    *
    *Vytvorí panely a pridá ich do framu
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public GameFrame() throws Exception {
        this.setFrame();

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(this.cardLayout);
        this.menuPanel = new MenuPanel(this);
        this.gamePanel = new GamePanel();

        this.cardPanel.add(this.menuPanel, "menu");
        this.cardPanel.add(this.gamePanel, "game");

        setContentPane(this.cardPanel);
    }
    private void setFrame() {
        //frame
        this.setTitle("Spooky");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1600, 900);
        this.setBackground(null);
        this.setLayout(null);
        
        //icon
        ImageIcon icon = new ImageIcon("res/pics/icon.jpg");
        this.setIconImage(icon.getImage());
    }
    /**
    *
    *zmení viditelný panel z menu na game
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public void showGamePanel() {
        this.cardLayout.show(this.cardPanel, "game");
        this.gamePanel.setFocusable(true);
        this.gamePanel.requestFocusInWindow();
    }

}
