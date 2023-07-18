/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.object;

import com.codideep.app.generic.ObjectAttribute;
import com.codideep.app.process.ShipProcess;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author KAAF0
 */
public class Projectil extends ObjectAttribute implements Runnable {

    public int[] position = {0, 0};
    public int[] dimension = {0, 0};

    public static boolean createProjectil = false;
    public boolean stopThread = false;

    public Projectil() {
        this.component = new JLabel();

        this.dimension[0] = 20;
        this.dimension[1] = 40;

        delay = 7;

        this.position[0] = (Ship.position[0] + (Ship.dimension[0] / 2)) - (this.dimension[0] / 2) - 1;
        this.position[1] = Ship.position[1];

        ImageIcon imageIcon = new ImageIcon("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\missile.png");

        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(this.dimension[0], this.dimension[1], java.awt.Image.SCALE_SMOOTH));

        this.component.setBounds(this.position[0], this.position[1], this.dimension[0], this.dimension[1]);
        this.component.setIcon(imageIcon);
    }

    private void move() {
        position[1] -= 5;
        this.component.setBounds(position[0], position[1], dimension[0], dimension[1]);
    }

    public boolean isRemove() {
        return -50 > position[1];
    }

    public void setStopThread() {
        this.stopThread = true;
    }

    @Override
    public void run() {
        while (true) {
            if (this.stopThread) {
                return;
            }

            move();

            try {
                sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
