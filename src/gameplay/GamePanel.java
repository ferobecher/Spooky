package gameplay;

import entity.Enemy;
import entity.Player;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
*
*Trieda, kt. sa star� o vykreslenie objektov v hracom panely a star� sa o chod hry 
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class GamePanel extends JPanel implements Runnable {
    private Thread gameThread;
    private final KeyInput keyInput = new KeyInput();
    private final int fps = 60;
    private final Player player = new Player(this.keyInput);
    private final Enemy enemy = new Enemy();
    private final Background bg = new Background();

    /**
    *
    *Nastav� panelu vlastnosti a za?ne game thread
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public GamePanel() throws Exception {

        this.setLayout(null);
        this.setBounds(0, 0, 1600, 900);
        this.setDoubleBuffered(true);
        this.addKeyListener(this.keyInput);
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setVisible(false);
        //
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }
    /**
    *
    *Met�da na obmedzenie fps na 60 prevzat� z youtube tutori�lu
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (this.gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                this.update();
                this.repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }
    /**
    *
    *volan� 60kr�t za sekundu upravuje vlastnosti hr�?a a nepriate?a pod?a stavu hry
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public void update() {
        this.player.update();
        this.enemy.update();
        if (Player.getX() > 1550) {
            Player.setX(0);
            Background.change();
            Player.setY(Background.getY());
        }
        if (Player.getX() < -200) {
            Player.setX(1400);
            Background.change();
            Player.setY(Background.getY());
        }
    }
    /**
    *
    *vykresluje aktu�lny stav hr�?a, nepriate?a a pozadia na pl�tno
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        this.bg.draw(g2);
        this.player.draw(g2);
        if (Background.hasEnemy()) {
            this.enemy.draw(g2);
        }
        g2.dispose();
    }
}
