package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
*
*vytv�ra objekt ��pu na obrazovke s dynamicky sa meniacimni vlastnostami
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class Arrow {
    private static int x;
    private static int y;
    private static boolean isShot;
    private final BufferedImage image;
    /**
    *
    *na?�tanie obr�zka zo s�boru
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public Arrow() throws IOException {
        this.image = ImageIO.read(new File("res/pics/player/arrow/1.png"));
    }
    /**
    *
    *settery pre premenn� triedy
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static void setX(int a) {
        x = a;
    }
    public static void setY(int a) {
        y = a;
    }
    public static void setShot(boolean shot) {
        isShot = shot;
    }
    /**
    *
    *gettery pre premenn� triedy
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static int getX() {
        return x;
    }
    public static int getY() {
        return y;
    }
    public int getWidth() {
        return this.image.getWidth();
    }
    public int getHeight() {
        return this.image.getHeight();
    }
    public BufferedImage getImage() {
        return this.image;
    }
    public static boolean isShot() {
        return isShot;
    }

}
