/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.CharacterRute1;
import Domain.CharacterRute2;
import Domain.CharacterRute3;
import Domain.CharacterRute4;
import Domain.CharacterRute5;
import Domain.Example;
import Utilities.Variables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author brend
 */
public class MainWindow extends JFrame implements ActionListener {

    private static MainWindow mainWindow;
    private JButton jbtnCreate;
    private JButton jbtnBarrier;
    private JButton jbtnRevert;
    private JButton jbtnSimulation;
    private JButton jbtnInterrupt;
    private JTextField jtfSpeed;
    private JTextField jtfValue;
    private JTextField jtfLanes;
    private boolean reverseRute;
    private boolean flag;
    private MainJPanel mainJPanel;

    private MainWindow() throws IOException, FileNotFoundException, InterruptedException {
        this.setTitle("Proyecto 2");
        this.setSize(Variables.HEIGHT, Variables.WIDTH);
        this.setLayout(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.jbtnCreate = new JButton("Crear");
        this.jbtnBarrier = new JButton("Barrera");
        this.jbtnRevert = new JButton("Reversa");
        this.jbtnSimulation = new JButton("Simulación");
        this.jbtnInterrupt = new JButton("Interrumpir");
        this.jtfSpeed = new JTextField("Velocidad");
        this.jtfValue = new JTextField("Valor");
        this.jtfLanes = new JTextField("Carriles");
        this.reverseRute = false;

        init();
        this.setVisible(true);

        jbtnRevert.addActionListener(this);
    }

    public void init() throws IOException, FileNotFoundException, InterruptedException {

        this.jbtnCreate.setBounds(10, 520, 200, 30);
        this.jbtnBarrier.setBounds(240, 460, 100, 30);
        this.jbtnInterrupt.setBounds(473, 465, 300, 80);
        this.jbtnRevert.setBounds(360, 460, 100, 30);
        this.jbtnSimulation.setBounds(360, 520, 100, 30);
        this.jtfSpeed.setBounds(10, 460, 95, 30);
        this.jtfValue.setBounds(115, 460, 95, 30);
        this.jtfLanes.setBounds(240, 520, 95, 30);
        this.flag = false;

        this.add(this.jbtnCreate);
        this.add(this.jbtnBarrier);
        this.add(this.jbtnRevert);
        this.add(this.jbtnSimulation);
        this.add(this.jtfSpeed);
        this.add(this.jtfValue);
        this.add(this.jtfLanes);
        this.add(this.jbtnInterrupt);

        mainJPanel = new MainJPanel();
        this.add(mainJPanel);

    }

    public static synchronized MainWindow getInstance() throws IOException, FileNotFoundException, InterruptedException {
        if (mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbtnRevert && flag) {
            this.setReverseRute(false);
            this.flag = false;

        } else if (e.getSource() == jbtnRevert && flag == false) {
            this.setReverseRute(true);
            this.flag = true;

        }

    }

    private static class MainJPanel extends JPanel implements Runnable {

        private JLabel label;
        private Thread thread;
        private Graphics buff;
        private Image imageBackground;
        private Example example;
        private CharacterRute1 characterRute1;
        private CharacterRute2 characterRute2;
        private CharacterRute3 characterRute3;
        private CharacterRute4 characterRute4;
        private CharacterRute5 characterRute5;

        public MainJPanel() throws IOException, FileNotFoundException, InterruptedException {
            this.label = new JLabel("......................");
            this.setBackground(Color.yellow);
            this.label.setBounds(358, 9, 75, 10);
            this.setSize(783, 450);
            this.setLayout(null);
            this.setVisible(true);
            this.add(label);
            //posiciones de cada carril
//           (383, 386) carril 5
            //agregamos movimiento a la ruta2
            this.characterRute1 = new CharacterRute1(383, 260, 0);
            this.characterRute2 = new CharacterRute2(383, 292, 0);
            this.characterRute3 = new CharacterRute3(383, 325, 0);
            this.characterRute4 = new CharacterRute4(383, 355, 0);
            this.characterRute5 = new CharacterRute5(383, 386, 0);
            init();
            this.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    label.setText("X: " + e.getX() + "  " + "Y: " + e.getY());
                }
            });
        }

        private void init() {
            this.thread = new Thread(this);
            this.thread.start();
            this.characterRute1.start();
            this.characterRute2.start();
            this.characterRute3.start();
            this.characterRute4.start();
            this.characterRute5.start();
            

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension d = getSize();
            Image image = createImage(d.width, d.height);
            this.buff = image.getGraphics();
            draw(this.buff);
            g.drawImage(image, 0, 0, null);

            try {
                this.imageBackground = ImageIO.read(new FileInputStream("./src/Assets/Circuit.png"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void draw(Graphics g) {
            try {
                g.drawImage(imageBackground, 0, 0, this);
                g.drawImage(characterRute1.getImage(), characterRute1.getX(), characterRute1.getY(), this);
                g.drawImage(characterRute2.getImage(), characterRute2.getX(), characterRute2.getY(), this);
                g.drawImage(characterRute3.getImage(), characterRute3.getX(), characterRute3.getY(), this);
                g.drawImage(characterRute4.getImage(), characterRute4.getX(), characterRute4.getY(), this);
                g.drawImage(characterRute5.getImage(), characterRute5.getX(), characterRute5.getY(), this);
            } catch (NullPointerException npe) {

            }
        }

        @Override
        public void run() {
            long start;
            long elapsed;
            long wait;
            int fps = 60;
            long time = 2000 / fps;

            while (true) {
                try {
                    start = System.nanoTime();
                    elapsed = System.nanoTime() - start;
                    wait = time - elapsed / 2000000;
                    Thread.sleep(wait);
                    //Lugar de ejecucucion de codigo
                    draw(this.buff);
                    repaint();
                    //Lugar de ejecucucion de codigo
                } catch (InterruptedException ex) {
                }
            }

        }

    }

    public boolean isReverseRute() {
        return reverseRute;
    }

    public void setReverseRute(boolean reverseRute) {
        this.reverseRute = reverseRute;
    }

}
