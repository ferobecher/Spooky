package main;

import sounds.Sounds;
public class Game {
    /**
    *
    *Hlavná metóda na spustenie programu, inicializuje Frame a spustí hudbu
    *@version 1.0
    *@author František Becher <becherferko@gmail.com>
    *
    */
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        new Sounds();
        Sounds.playMusic();
    }
}
