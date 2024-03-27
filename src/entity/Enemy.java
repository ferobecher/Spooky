package entity;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
/**
*
*trieda vykres?ujúca nepriate?a na obrazovku a pod?a hrá?ových akcií meniacia animácie
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public class Enemy  implements Entity{
    private static Action action;
    private static int x;
    private static int y;
    private BufferedImage shownImage;
    /**
    *
    *nastavenie premenných na základné hodnoty
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public Enemy() {
        x = 1200;
        y = 530;
        action = Action.ENEMY_IDLE;
    }
    /**
    *
    *pod?a pozície šípu zmení aktuálnu animáciu na smr?
    *@version 1.
    *@author František Becher <becherferko@gmail.com>
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
    *vykreslenie nepriate?a na pozíciu pod?a aktuálnych premmených
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public void draw(Graphics2D g2) {
        g2.drawImage(this.shownImage, x, y, this.shownImage.getWidth() * 3, this.shownImage.getHeight() * 3, null);
    }
    /**
    *
    *pripo?ítava hodnotu k y súradnici
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void changeY(int addition) {
        y += addition;
    }
    /**
    *
    *vráti aktuálnu hodnotu x súradnice
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static int getX() {
        return x;
    }
    /**
    *nastáví animáciu na smr?
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void die() {
        action = Action.ENEMY_DEAD;
    }
}
