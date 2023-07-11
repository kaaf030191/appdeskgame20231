/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.object;

import com.codideep.app.generic.ObjectAttribute;
import com.codideep.app.process.ShipProcess;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author KAAF0
 */
public class Asteroid extends ObjectAttribute implements Runnable {

    private java.awt.Dimension screenSize = null;

    public Asteroid() {
        this.component = new JLabel();

        Random random = new Random();

        int randomDimension = random.nextInt(70 - 20 + 1) + 20;

        this.dimension[0] = randomDimension;
        this.dimension[1] = randomDimension;

        delay = random.nextInt(30 - 20 + 1) + 20;

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.position[0] = random.nextInt((screenSize.width - this.dimension[0]) - 0 + 1) + 0;
        this.position[1] = -90;

        ImageIcon imageIcon = new ImageIcon("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\asteroid.png");

        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(this.dimension[0], this.dimension[1], java.awt.Image.SCALE_SMOOTH));

        this.component.setBounds(this.position[0], this.position[1], this.dimension[0], this.dimension[1]);
        this.component.setIcon(imageIcon);
    }

    private void move() {
        position[1] += 5;
        this.component.setBounds(position[0], position[1], dimension[0], dimension[1]);
    }

    public boolean isRemove() {
        return screenSize.height + 100 < position[1];
    }

    @Override
    public void run() {
        while (true) {
            move();

            try {
                sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
