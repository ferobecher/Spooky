package gameplay;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
*
*na?íta a mení pozadie hracieho po?a
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class Background {
    private static BufferedImage spooky;
    private static BufferedImage forest;
    private static BufferedImage bg;
    private static int y;
    private static int counter;
    private static boolean hasEnemy;
    /**
    *
    *na?íta obrázky pre pozadie
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public Background() throws IOException {
        spooky = ImageIO.read(new File("res/pics/bg/spooky.png"));
        forest = ImageIO.read(new File("res/pics/bg/forest.png"));
        change();
    }
    /**
    *
    *vykreslí pozadie
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public void draw(Graphics2D g2) {
        g2.drawImage(bg, 0, 0, 1600, 900, null);
    }
    /**
    *
    *zmení obrázok pozadia a upravý pozíciu hrá?a a nepriate?a
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void change() {
        if (counter == 0) {
            bg = spooky;
            hasEnemy = true;
            counter = 1;
            y = 530;
        } else if (counter == 1) {
            bg = forest;
            hasEnemy = false;
            counter = 0;
            y = 600;
        }
    }
    /**
    *
    *vráti y súradnicu, kde by mal hrá? stá? pod?a zvoleného pozadia
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static int getY() {
        return y;
    }
    /**
    *
    *odpovie pod?a zvoleného pozadia ?i tam je nepriate? alebo nie
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static boolean hasEnemy() {
        return hasEnemy;
    }
}