/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import GUI.MainWindow;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author brend
 */
public class CharacterRute1 extends Character {

    private int x;
    private int y;
    private ImageIO imageIO;
    private ArrayList<Image> sprite;
    private boolean curve = false;
    private int indexPosition;
    private int run;
    private int speed;
    private ArrayList PositionX;
    private ArrayList PositionY;
    private ArrayList sprites;
    private int rememberX;
    private int rememberY;

    public CharacterRute1(int x, int y, int imgNum) throws FileNotFoundException, IOException, InterruptedException {
        super(x, y, imgNum);
        setSprite();
        this.x = x;
        this.y = y;
        this.rememberX = 0;
        this.rememberY = 0;
        this.run = 1;
        this.speed = 60;
        this.PositionX = new ArrayList();
        this.PositionY = new ArrayList();
        this.sprites = new ArrayList();
        rute1();

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

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (run == 1) {
            try {
                Thread.sleep(speed);
                try {
                    if (!MainWindow.getInstance().isReverseRute()) {
                        int i;
                        if (PositionX.contains(rememberX) && PositionY.contains(rememberY)) {
                            i = PositionX.indexOf(rememberX);
                        } else {
                            i = 0;
                        }

                        for (i = i; i <= this.PositionX.size() - 1; i++) {
                            Thread.sleep(speed);
                            super.setX((int) this.PositionX.get(i));
                            super.setY((int) this.PositionY.get(i));
                            if (i < 237) {
                                super.setImage(sprite.get((int) sprites.get(i)));
                            } else {
                                i = 0;
                                super.setImage(sprite.get((int) sprites.get(i)));
                            }
                            if (MainWindow.getInstance().isReverseRute()) {
                                rememberX = (int) this.PositionX.get(i);
                                rememberY = (int) this.PositionY.get(i);
                                break;
                            }
                        }

                    } else if (MainWindow.getInstance().isReverseRute()) {
                        int i;
                        if (PositionX.contains(rememberX) && PositionY.contains(rememberY)) {
                            i = PositionX.indexOf(rememberX);
                        } else {
                            i = PositionX.size() - 1;
                        }

                        for (i = i; i >= 0; i--) {
                            Thread.sleep(speed);
                            super.setX((int) this.PositionX.get(i));
                            super.setY((int) this.PositionY.get(i));
                            super.setImage(sprite.get((int) sprites.get(i)));
                            if (MainWindow.getInstance().isReverseRute() == false) {
                                rememberX = (int) this.PositionX.get(i);
                                rememberY = (int) this.PositionY.get(i);
                                break;
                            }
                        }
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

    public void rute1() {
        PositionX.add(x);
        PositionY.add(y);
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);
        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);
        }

        for (int i = 0; i < 5; i++) {
            x = x + 1;
            y = y - 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 2;
            y = y - 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 1;
            y = y - 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 2;
            y = y - 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 12; i++) {
            x = x - 2;
            y = y - 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }

        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }

        for (int i = 10; i < 20; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 18; i++) {
            x = x - 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 20; i++) {
            x = x - 2;
            y = y + 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 10; i < 15; i++) {
            x = x - 3;
            y = y + 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 9; i++) {
            x = x + 1;
            y = y + 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 7; i++) {
            x = x + 1;
            y = y + 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 3; i++) {
            x = x + 2;
            y = y + 3;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 8; i++) {
            x = x + 2;
            y = y + 1;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }
        for (int i = 0; i < 10; i++) {
            x = x + 5;
            sprites.add(i);
            PositionX.add(x);
            PositionY.add(y);

        }

    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, 32, 32);
    }

    private boolean collision() {
//        try {
//            if(example1.getBounds()!=null){
//                
//            }
//            return this.getBounds().intersects(example1.getBounds());
//        } catch (NullPointerException e) {
//        
//        
//        }

        return false;
    }
}
