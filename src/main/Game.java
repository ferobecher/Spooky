package main;

import sounds.Sounds;
public class Game {
    /**
    *
    *Hlavn� met�da na spustenie programu, inicializuje Frame a spust� hudbu
    *@version 1.0
    *@author Franti�ek Becher <becherferko@gmail.com>
    *
    */
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        new Sounds();
        Sounds.playMusic();
    }
}
