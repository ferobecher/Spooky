package entity;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
/**
*
*trieda vykres?uj�ca nepriate?a na obrazovku a pod?a hr�?ov�ch akci� meniacia anim�cie
*@version 1.0
*@author Franti�ek Becher <becherferko@gmail.com>
*
*/
public class Enemy  implements Entity{
    private static Action action;
    private static int x;
    private static int y;
    private BufferedImage shownImage;
    /**
    *
    *nastavenie premenn�ch na z�kladn� hodnoty
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public Enemy() {
        x = 1200;
        y = 530;
        action = Action.ENEMY_IDLE;
    }
    /**
    *
    *pod?a poz�cie ��pu zmen� aktu�lnu anim�ciu na smr?
    *@version 1.
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public void update() {
        this.shownImage = action.animate();
        if (action != Action.ENEMY_DEAD && Arrow.isShot() && Arrow.getX() > x) {
            action = Action.ENEMY_DEAD;
        }
    }
    /**
    *
    *vykreslenie nepriate?a na poz�ciu pod?a aktu�lnych premmen�ch
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public void draw(Graphics2D g2) {
        g2.drawImage(this.shownImage, x, y, this.shownImage.getWidth() * 3, this.shownImage.getHeight() * 3, null);
    }
    /**
    *
    *pripo?�tava hodnotu k y s�radnici
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static void changeY(int addition) {
        y += addition;
    }
    /**
    *
    *vr�ti aktu�lnu hodnotu x s�radnice
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static int getX() {
        return x;
    }
    /**
    *nast�v� anim�ciu na smr?
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static void die() {
        action = Action.ENEMY_DEAD;
    }
}
