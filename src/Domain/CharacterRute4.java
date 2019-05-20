/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jose0
 */
public class CharacterRute4 extends Character{
    private ArrayList<Position> positions;
    private boolean reverse;
    private int x;
    private int y;
    private ImageIO imageIO;
    private ArrayList<Image> sprite;
    private boolean curve = false;
    private int indexPosition;

    public CharacterRute4(int x, int y, int imgNum) throws FileNotFoundException, IOException {
        super(x, y, imgNum);
        this.positions = new ArrayList<>();
        setSprite();
        setPosition();
        this.x = x;
        this.y = y;
        this.reverse = false;

    }

    public void setSprite() throws FileNotFoundException, IOException {
        sprite = super.getSprite();

        for (int i = 0; i <= 9; i++) {
            sprite.add(imageIO.read(new FileInputStream("src/Assets/SpritesMegamanX/" + i + ".png")));
        }
        for (int i = 0; i <= 9; i++) {
            sprite.add(imageIO.read(new FileInputStream("src/Assets/SpritesMegamanX/" + i + "R" + ".png")));
        }

        super.setSprite(sprite);
    }

    public void setPosition() {
        
        this.positions.add(new Position(420, 350));
        this.positions.add(new Position(435, 350));
        this.positions.add(new Position(450, 350));
        this.positions.add(new Position(465, 350));
        this.positions.add(new Position(480, 350));
        this.positions.add(new Position(495, 350));
        this.positions.add(new Position(500, 350));
        this.positions.add(new Position(515, 350));
        this.positions.add(new Position(530, 350));
        this.positions.add(new Position(545, 350));
        this.positions.add(new Position(560, 350));
        this.positions.add(new Position(570, 350));
        //primera curva
        this.positions.add(new Position(580, 350));
        //dando la curva1
        this.positions.add(new Position(640, 340));
        this.positions.add(new Position(645, 330));
        this.positions.add(new Position(655, 300));
        this.positions.add(new Position(657, 266));
        this.positions.add(new Position(660, 251));
        this.positions.add(new Position(665, 235));
        this.positions.add(new Position(670, 209));
        this.positions.add(new Position(665, 177));
        this.positions.add(new Position(660, 150));
        this.positions.add(new Position(657, 130));
        this.positions.add(new Position(655, 110));
        this.positions.add(new Position(645, 100));
        this.positions.add(new Position(640, 90));
        //fin curva1
        //empieza recta de arriba, resto x
        this.positions.add(new Position(580, 60));
        this.positions.add(new Position(544, 60));
        this.positions.add(new Position(535, 60));
        this.positions.add(new Position(528, 60));
        this.positions.add(new Position(520, 60));
        this.positions.add(new Position(512, 60));
        this.positions.add(new Position(505, 60));
        this.positions.add(new Position(496, 60));
        this.positions.add(new Position(490, 60));
        this.positions.add(new Position(482, 60));
        this.positions.add(new Position(475, 60));
        this.positions.add(new Position(468, 60));
        this.positions.add(new Position(460, 60));
        this.positions.add(new Position(452, 60));
        this.positions.add(new Position(445, 60));
        this.positions.add(new Position(438, 60));
        this.positions.add(new Position(430, 60));
        this.positions.add(new Position(422, 60));
        this.positions.add(new Position(415, 60));
        this.positions.add(new Position(408, 60));
        this.positions.add(new Position(400, 60));
        this.positions.add(new Position(392, 60));
        this.positions.add(new Position(385, 60));
        this.positions.add(new Position(377, 60));
        this.positions.add(new Position(370, 60));
        this.positions.add(new Position(362, 60));
        this.positions.add(new Position(355, 60));
        this.positions.add(new Position(340, 60));
        this.positions.add(new Position(325, 60));
        this.positions.add(new Position(310, 60));
        this.positions.add(new Position(295, 60));
        this.positions.add(new Position(280, 60));
        this.positions.add(new Position(265, 60));
        this.positions.add(new Position(250, 60));
        this.positions.add(new Position(235, 60));
        this.positions.add(new Position(220, 60));
        this.positions.add(new Position(205, 60));
        this.positions.add(new Position(190, 60));
        //ultimo punto de recta arriba
        this.positions.add(new Position(177, 60));
        //empieza curva 2
        this.positions.add(new Position(144, 70));
        this.positions.add(new Position(120, 92));
        this.positions.add(new Position(115, 100));
        this.positions.add(new Position(110, 104));
        this.positions.add(new Position(105, 114));
        this.positions.add(new Position(100, 120));
        this.positions.add(new Position(95, 136));
        this.positions.add(new Position(89, 159));
        this.positions.add(new Position(83, 180));
        this.positions.add(new Position(82, 193));
        this.positions.add(new Position(80, 209));
        this.positions.add(new Position(82, 226));
        this.positions.add(new Position(83, 246));
        this.positions.add(new Position(89, 263));
        this.positions.add(new Position(108, 289));
        this.positions.add(new Position(109, 304));
        this.positions.add(new Position(123, 323));
        //termina curva 2, empieza recta final, sumo x
        
        this.positions.add(new Position(130, 353));
        this.positions.add(new Position(140, 353));
        this.positions.add(new Position(150, 353));
        this.positions.add(new Position(160, 353));
        this.positions.add(new Position(170, 353));
        this.positions.add(new Position(180, 353));
        this.positions.add(new Position(190, 353));
        this.positions.add(new Position(200, 353));
        
        this.positions.add(new Position(210, 353));
        this.positions.add(new Position(218, 353));
        this.positions.add(new Position(225, 353));
        this.positions.add(new Position(232, 353));
        this.positions.add(new Position(240, 353));
        this.positions.add(new Position(248, 353));
        this.positions.add(new Position(255, 353));
        this.positions.add(new Position(264, 353));
        this.positions.add(new Position(270, 353));
        this.positions.add(new Position(278, 353));
        this.positions.add(new Position(295, 353));
        this.positions.add(new Position(305, 353));
        this.positions.add(new Position(310, 353));
        this.positions.add(new Position(318, 353));
        this.positions.add(new Position(325, 353));
        this.positions.add(new Position(333, 353));
        this.positions.add(new Position(340, 353));
        this.positions.add(new Position(348, 353));
        this.positions.add(new Position(355, 353));
        this.positions.add(new Position(365, 353));
        this.positions.add(new Position(370, 353));
        this.positions.add(new Position(385, 353));
        this.positions.add(new Position(393, 353));
        //llegamos a la meta

    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                Thread.sleep(20);
                try {
                    while (!reverse) {
                        moveDEL();
                    }
                    while (reverse) {
                        moveTRAS();
                    }

                } catch (BootstrapMethodError | InternalError br) {
                } catch (Throwable ex) {
                    Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(CharacterRute2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void moveDEL() throws InterruptedException {
        int aux = 0;
        int countSprite = 0;
        for (int i = this.indexPosition; i < this.positions.size(); i++) {
            if (i >= 11 && i <= 68) {
                super.setImage(sprite.get(countSprite));
                if (countSprite == 18) {
                    countSprite = 10;
                } else {
                    countSprite++;

                }
            } else if (i >= 69 || i <= 11) {

                countSprite = aux;
                if (countSprite == 9) {
                    countSprite = 0;
                    aux = 0;
                } else {
                    countSprite++;
                    aux = countSprite;
                }
                super.setImage(sprite.get(countSprite));
            }
            Thread.sleep(100);
            super.setX(this.positions.get(i).getX());
            super.setY(this.positions.get(i).getY());
            this.indexPosition = i;
        }
    }

    public void moveTRAS() throws InterruptedException {
        int aux = 0;
        int countSprite = 10;
        super.setImage(sprite.get(1));
        for (int i = this.indexPosition; i >= 0; i--) {
            if (i >= 25 && i <= 69) {
                countSprite = aux;
                if (countSprite == 9) {
                    countSprite = 0;
                    aux = 0;
                } else {
                    countSprite++;
                    aux = countSprite;
                }
                super.setImage(sprite.get(countSprite));
            } else if ((i <= 100 && i >= 70) || i <= 24) {

                super.setImage(sprite.get(countSprite));
                if (countSprite == 18) {
                    countSprite = 10;
                } else {
                    countSprite++;

                }
            }

            Thread.sleep(100);
            super.setX(this.positions.get(i).getX());
            super.setY(this.positions.get(i).getY());
            this.indexPosition = i;
            //fin del metodo
        }
    }

    public int getIndexPosition() {
        return indexPosition;
    }

    public void setIndexPosition(int indexPosition) {
        this.indexPosition = indexPosition;
    }
}
