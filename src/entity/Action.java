package entity;

import gameplay.Background;
import sounds.Sounds;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
*
*každá inštancia má svoje pole obrázkov cez ktoré iteruje ke? je zvolená 
*@version 1.0
*@author František Becher <becherferko@gmail.com>
*
*/
public enum Action {
    IDLE(new BufferedImage[6], "idle", 6, "player", 8),
    IDLE2(new BufferedImage[4], "idle2", 4, "player", 8),
    WALK(new BufferedImage[8], "walk", 8, "player", 6),
    RUN(new BufferedImage[8], "run", 8, "player", 5),
    DEAD(new BufferedImage[3], "dead", 3, "player", 10),
    HURT(new BufferedImage[3], "hurt", 3, "player", 8),
    ATTACK(new BufferedImage[4], "attack", 4, "player", 8),
    SHOT1(new BufferedImage[14], "shot1", 14, "player", 8),
    SHOT2(new BufferedImage[13], "shot2", 13, "player", 8),
    JUMP(new BufferedImage[9], "jump", 9, "player", 5),
    ENEMY_IDLE(new BufferedImage[6], "idle", 6, "enemy", 8),
    ENEMY_DEAD(new BufferedImage[4], "dead", 4, "enemy", 10);

    private BufferedImage[] images;
    private int iterator;
    private int counter;
    private boolean stopAnimation;
    private int animationSpeed;
    /**
    *
    *na?íta obrázky do pola zo súborov a incializuje premenné
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    Action(BufferedImage[] images, String actionName, int size, String entity, int animationSpeed) {

        //initialize variables
        this.images = images;
        this.stopAnimation = false;
        this.animationSpeed = animationSpeed;

        //load images
        for (int i = 0; i < size; i++) {
            try {
                this.images[i] = ImageIO.read(new File("res/pics/" + entity + "/" + actionName + "/" + (i + 1) + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
    *
    *iteruje medzi obrázkami a tým vytvára animáciu
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public BufferedImage animate() {
        if (!this.stopAnimation) {
            this.counter++;
            if (this.counter == this.animationSpeed) {
                if (this.iterator != this.images.length) {

                    //exceptions
                    if (this == Action.SHOT1 && this.iterator == 12) {
                        Arrow.setShot(true);
                        Sounds.playSwordSound();
                    }
                    if (this == Action.ENEMY_DEAD) {
                        switch (this.iterator) {
                            case 0: Enemy.changeY(20); 
                            break;
                            case 2: Enemy.changeY(100); 
                            break;
                        }
                    }
                    if (this == Action.DEAD) {
                        switch (this.iterator) {
                            case 0: Player.changeY(20); 
                            break;
                            case 1: Player.changeY(100); 
                            break;
                        }
                    }
                    if (this == Action.JUMP) {
                        switch (this.iterator) {
                            case 0: Player.setY(Background.getY()); 
                            break;
                            case 1: Player.changeY(-20); 
                            break;
                            case 2: Player.changeY(-50); 
                            break;
                            case 3: Player.changeY(-70); 
                            break;
                            case 4: Player.changeY(-20); 
                            break;
                            case 5: Player.changeY(20); 
                            break;
                            case 6: Player.changeY(70); 
                            break;
                            case 7: Player.changeY(50); 
                            break;
                            case 8: Player.changeY(20); 
                                Player.setJumping(false); 
                            break;
                        }
                    }
                    if (this == Action.ATTACK && this.iterator == 2) {
                        Sounds.playSwordSound();
                        if ((Player.getX() < Enemy.getX()) && (Player.getX() > (Enemy.getX() - 300))) {
                            Enemy.die();
                        }
                    }
                    this.iterator++;
                }
                if (this.iterator == this.images.length) {
                    this.iterator = 0;
                }
                this.counter = 0;
            }
        }
        if (!this.stopAnimation && ((this.iterator == 3 && this == Action.ENEMY_DEAD) || (this.iterator == 2 && this == Action.DEAD))) {
            this.stopAnimation = true;
        }

        return this.images[this.iterator];
    }
    /**
    *
    *resetuje itera?nú premennú
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public void resetIterator() {
        this.iterator = 0;
    }
}
