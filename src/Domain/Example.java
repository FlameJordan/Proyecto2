/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import GUI.MainWindow;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
 * @author jordan
 */
public class Example extends Character {

    private boolean reverse = false;
    private int x;
    private int y;
    private ImageIO imageIO;
    private ArrayList<Image> sprite;
    private boolean curve = false;
    private ArrayList reverseRutePositionX = new ArrayList();
    private ArrayList reverseRutePositionY = new ArrayList();
    private ArrayList spriteReverseRute = new ArrayList();
    private int counter = 0;
    int countSprite = 0;
    int countSpriteR = 10;
    private int run=1;

    public Example(int x, int y, int imgNum) throws FileNotFoundException, IOException {
        super(x, y, imgNum);
        setSprite();
        this.x = x;
        this.y = y;

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
        while (run==1) {
            try {

                super.setX(x);
                super.setY(y);
                this.counter = this.spriteReverseRute.size() - 1;
               
                if (MainWindow.getInstance().isReverseRute() == false) {
                    rute1(20, 1);
                } else {

                    for (int i = (reverseRutePositionX.size() + reverseRutePositionY.size()) - 1; i >= 0; i--) {
                        Thread.sleep(38);
                        super.setX((int) reverseRutePositionX.get(i / 2));
                        super.setY((int) reverseRutePositionY.get(i / 2));
                        if (MainWindow.getInstance().isReverseRute() == false) {
                            break;
                        }
                        
//                        super.setImage(sprite.get((int) spriteReverseRute.get(counter)));
//                        if (counter > 0) {
//                            counter--;
//                        } else {
//                            counter = spriteReverseRute.size() - 1;
//
//                        }
                    }
                    
                }
               
            } catch (BootstrapMethodError | InternalError br) {
            } catch (InterruptedException ex) {
                Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
                Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void rute1(int repeat, int dir) throws InterruptedException, Throwable {

        if (dir == 1) {

            Thread.sleep(60);
            if (this.reverse == false) {
                if (this.countSprite >= 10) {
                    this.countSprite = 0;
                }
                this.spriteReverseRute.add(this.countSprite);
                super.setImage(sprite.get(this.countSprite));
            } else {
                if (this.countSpriteR >= 19) {
                    this.countSpriteR = 10;
                }
                this.spriteReverseRute.add(this.countSpriteR);
                super.setImage(this.sprite.get(this.countSpriteR));
            }
            if (x < 560 && y > 160 && x >= 190 && curve == false) {
                x += 5;
                this.reverseRutePositionX.add(x);
                this.reverseRutePositionY.add(y);
                super.setX(x);
                super.setY(y);
            }

            if (x >= 550 && y <= 266 && y >= 210 && curve == false) {
                x += 6;
                y -= 5;
                reverseRutePositionX.add(x);
                reverseRutePositionY.add(y);
                super.setX(x);
                super.setY(y);
            }
            if (y <= 228 && x >= 550 && y >= 163 && curve == false) {
                x -= 4;
                y -= 5;

                reverseRutePositionX.add(x);
                reverseRutePositionY.add(y);
                reverse = true;
                super.setX(x);
                super.setY(y);
            }
            if (y <= 162 && x >= 190 && curve == false) {
                if (x >= 550) {
                    y -= 3;
                }
                x -= 6;
                reverseRutePositionX.add(x);
                reverseRutePositionY.add(y);
                super.setX(x);
                super.setY(y);
            }

            if (x <= 190 && x >= 145 && y <= 200) {
                if (y <= 225 && x <= 215) {
                    curve = true;
                    y += 4;
                    x -= 4;
                    reverseRutePositionX.add(x);
                    reverseRutePositionY.add(y);
                    super.setY(y);
                    super.setX(x);
                }
            }

            if (x >= 135 && x <= 210 && y >= 195) {
                y += 3;
                x += 4;
                reverseRutePositionX.add(x);
                reverseRutePositionY.add(y);
                super.setY(y);
                super.setX(x);
                reverse = false;
            } else if (x >= 210 && curve) {
                x += 5;
                reverseRutePositionX.add(x);
                reverseRutePositionY.add(y);
                super.setX(x);
            }

            if (countSprite >= 9) {
                countSprite = 0;
            } else if (reverse == false) {
                countSprite++;
            }

            if (countSpriteR >= 19) {
                countSpriteR = 10;
            } else if (reverse) {
                countSpriteR++;
            }

        }
    }

}
