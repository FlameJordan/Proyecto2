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
public class CharacterRute5 extends Character {

    private ArrayList<Position> positions;
    private boolean reverse;
    private int x;
    private int y;
    private ImageIO imageIO;
    private ArrayList<Image> sprite;
    private boolean curve = false;
    private int indexPosition;

    public CharacterRute5(int x, int y, int imgNum) throws FileNotFoundException, IOException {
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

        this.positions.add(new Position(420, 380));
        this.positions.add(new Position(435, 380));
        this.positions.add(new Position(450, 380));
        this.positions.add(new Position(465, 380));
        this.positions.add(new Position(480, 380));
        this.positions.add(new Position(495, 380));
        this.positions.add(new Position(500, 380));
        this.positions.add(new Position(515, 380));
        this.positions.add(new Position(530, 380));
        this.positions.add(new Position(545, 380));
        this.positions.add(new Position(560, 380));
        this.positions.add(new Position(570, 380));
        //primera curva
        this.positions.add(new Position(580, 380));
        //dando la curva1
        this.positions.add(new Position(603, 379));
        this.positions.add(new Position(614, 382));
        this.positions.add(new Position(630, 379));
        this.positions.add(new Position(637, 369));
        this.positions.add(new Position(648, 357));
        this.positions.add(new Position(655, 349));
        this.positions.add(new Position(661, 341));
        this.positions.add(new Position(664, 334));
        this.positions.add(new Position(671, 327));
        this.positions.add(new Position(675, 318));
        this.positions.add(new Position(675, 318));
        this.positions.add(new Position(675, 310));
        this.positions.add(new Position(676, 310));
        this.positions.add(new Position(684, 291));
        this.positions.add(new Position(691, 277));
        this.positions.add(new Position(691, 263));
        this.positions.add(new Position(693, 257));
        this.positions.add(new Position(693, 240));
        this.positions.add(new Position(697, 219));
        this.positions.add(new Position(697, 196));
        this.positions.add(new Position(695, 180));
        this.positions.add(new Position(692, 157));
        this.positions.add(new Position(688, 144));
        this.positions.add(new Position(682, 129));
        this.positions.add(new Position(679, 120));
        this.positions.add(new Position(675, 115));
        this.positions.add(new Position(673, 105));
        this.positions.add(new Position(670, 95));
        this.positions.add(new Position(665, 86));
        this.positions.add(new Position(656, 74));
        this.positions.add(new Position(648, 66));
        this.positions.add(new Position(625, 48));
        this.positions.add(new Position(625, 46));
        this.positions.add(new Position(612, 42));
        this.positions.add(new Position(602, 39));
        //fin curva1
        //empieza recta de arriba, resto x

        this.positions.add(new Position(544, 30));
        this.positions.add(new Position(535, 30));
        this.positions.add(new Position(528, 30));
        this.positions.add(new Position(520, 30));
        this.positions.add(new Position(512, 30));
        this.positions.add(new Position(505, 30));
        this.positions.add(new Position(496, 30));
        this.positions.add(new Position(490, 30));
        this.positions.add(new Position(482, 30));
        this.positions.add(new Position(475, 30));
        this.positions.add(new Position(468, 30));
        this.positions.add(new Position(460, 30));
        this.positions.add(new Position(452, 30));
        this.positions.add(new Position(445, 30));
        this.positions.add(new Position(438, 30));
        this.positions.add(new Position(430, 30));
        this.positions.add(new Position(422, 30));
        this.positions.add(new Position(415, 30));
        this.positions.add(new Position(408, 30));
        this.positions.add(new Position(400, 30));
        this.positions.add(new Position(392, 30));
        this.positions.add(new Position(385, 30));
        this.positions.add(new Position(377, 30));
        this.positions.add(new Position(370, 30));
        this.positions.add(new Position(362, 30));
        this.positions.add(new Position(355, 30));
        this.positions.add(new Position(340, 30));
        this.positions.add(new Position(325, 30));
        this.positions.add(new Position(310, 30));
        this.positions.add(new Position(295, 30));
        this.positions.add(new Position(280, 30));
        this.positions.add(new Position(265, 30));
        this.positions.add(new Position(250, 30));
        this.positions.add(new Position(235, 30));
        this.positions.add(new Position(220, 30));
        this.positions.add(new Position(205, 30));
        this.positions.add(new Position(190, 30));
        this.positions.add(new Position(180, 30));
        //ultimo punto de recta arriba
        this.positions.add(new Position(177, 30));
        //empieza curva 2
        this.positions.add(new Position(146, 41));
        this.positions.add(new Position(136, 46));
        this.positions.add(new Position(123, 59));
        this.positions.add(new Position(110, 70));
        this.positions.add(new Position(102, 79));
        this.positions.add(new Position(96, 90));
        this.positions.add(new Position(90, 102));
        this.positions.add(new Position(84, 115));
        this.positions.add(new Position(79, 126));
        this.positions.add(new Position(76, 142));
        this.positions.add(new Position(71, 156));
        this.positions.add(new Position(70, 178));
        this.positions.add(new Position(70, 197));
        this.positions.add(new Position(70, 217));
        this.positions.add(new Position(72, 234));
        this.positions.add(new Position(72, 248));
        this.positions.add(new Position(73, 261));
        this.positions.add(new Position(77, 277));
        this.positions.add(new Position(84, 294));
        this.positions.add(new Position(87, 309));
        this.positions.add(new Position(92, 322));
        this.positions.add(new Position(94, 329));
        this.positions.add(new Position(99, 339));
        this.positions.add(new Position(106, 349));
        this.positions.add(new Position(117, 363));
        this.positions.add(new Position(128, 373));

        //termina curva 2, empieza recta final, sumo x
        this.positions.add(new Position(130, 380));
        this.positions.add(new Position(140, 380));
        this.positions.add(new Position(150, 380));
        this.positions.add(new Position(160, 380));
        this.positions.add(new Position(170, 380));
        this.positions.add(new Position(180, 380));
        this.positions.add(new Position(190, 380));
        this.positions.add(new Position(200, 380));

        this.positions.add(new Position(210, 380));
        this.positions.add(new Position(218, 380));
        this.positions.add(new Position(225, 380));
        this.positions.add(new Position(232, 380));
        this.positions.add(new Position(240, 380));
        this.positions.add(new Position(248, 380));
        this.positions.add(new Position(255, 380));
        this.positions.add(new Position(264, 380));
        this.positions.add(new Position(270, 380));
        this.positions.add(new Position(278, 380));
        this.positions.add(new Position(295, 380));
        this.positions.add(new Position(305, 380));
        this.positions.add(new Position(310, 380));
        this.positions.add(new Position(318, 380));
        this.positions.add(new Position(325, 380));
        this.positions.add(new Position(333, 380));
        this.positions.add(new Position(340, 380));
        this.positions.add(new Position(348, 380));
        this.positions.add(new Position(355, 380));
        this.positions.add(new Position(365, 380));
        this.positions.add(new Position(370, 380));
        this.positions.add(new Position(385, 380));
        this.positions.add(new Position(393, 380));
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
            if (i >= 11 && i <= 89) {
                super.setImage(sprite.get(countSprite));
                if (countSprite == 18) {
                    countSprite = 10;
                } else {
                    countSprite++;

                }
            } else if (i >= 90 || i <= 11) {

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
            if (i >= 35 && i <= 99) {
                countSprite = aux;
                if (countSprite == 9) {
                    countSprite = 0;
                    aux = 0;
                } else {
                    countSprite++;
                    aux = countSprite;
                }
                super.setImage(sprite.get(countSprite));
            } else if ((i <= 144 && i >= 100) || i <= 34) {

                super.setImage(sprite.get(countSprite));
                if (countSprite == 18) {
                    countSprite = 10;
                } else {
                    countSprite++;

                }
            }

            Thread.sleep(150);
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
