/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.object;

import com.codideep.app.generic.ObjectAttribute;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author KAAF0
 */
public class Ship extends ObjectAttribute {

    public static int[] position = {0, 0};
    public static int[] dimension = {0, 0};
    
    private ImageIcon imageIconFront = null;
    private ImageIcon imageIconLeft = null;
    private ImageIcon imageIconRight = null;
    private ImageIcon imageIconDestroy = null;

    public static String move = null;/*static, left, right*/

    public Ship() {
        this.component = new JLabel();
        move = "static";

        Ship.dimension[0] = 40;
        Ship.dimension[1] = 60;
        
        delay = 7;

        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Ship.position[0] = (screenSize.width / 2) - (Ship.dimension[0] / 2);
        Ship.position[1] = screenSize.height - (Ship.dimension[1] + 50);

        imageIconFront = new ImageIcon("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\ship.png");
        imageIconLeft = new ImageIcon("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\shipLeft.png");
        imageIconRight = new ImageIcon("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\shipRight.png");
        imageIconDestroy = new ImageIcon("");

        imageIconFront = new ImageIcon(imageIconFront.getImage().getScaledInstance(Ship.dimension[0], Ship.dimension[1], java.awt.Image.SCALE_SMOOTH));
        imageIconLeft = new ImageIcon(imageIconLeft.getImage().getScaledInstance(Ship.dimension[0], Ship.dimension[1], java.awt.Image.SCALE_SMOOTH));
        imageIconRight = new ImageIcon(imageIconRight.getImage().getScaledInstance(Ship.dimension[0], Ship.dimension[1], java.awt.Image.SCALE_SMOOTH));

        this.component.setBounds(Ship.position[0], Ship.position[1], Ship.dimension[0], Ship.dimension[1]);
        this.component.setIcon(imageIconFront);
    }
    
    private void setImageLeft() {
        this.component.setIcon(imageIconLeft);
    }

    private void setImageRight() {
        this.component.setIcon(imageIconRight);
    }

    private void setImageDestroy() {
        this.component.setIcon(imageIconDestroy);
    }
    
    public void setImageFront() {
        this.component.setIcon(imageIconFront);
    }

    public void moveLeft() {
        position[0] -= 5;
        component.setBounds(position[0], position[1], dimension[0], dimension[1]);
        
        setImageLeft();
    }
    
    public void moveRight() {
        position[0] += 5;
        component.setBounds(position[0], position[1], dimension[0], dimension[1]);
        
        setImageRight();
    }
}
