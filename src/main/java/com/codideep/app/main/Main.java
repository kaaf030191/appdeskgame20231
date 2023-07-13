/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.main;

import com.codideep.app.object.Asteroid;
import com.codideep.app.object.Projectil;
import com.codideep.app.object.Ship;
import com.codideep.app.process.CreateProcess;
import com.codideep.app.process.ShipProcess;
import com.codideep.app.view.FrmGeneral;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author KAAF0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;

        FrmGeneral frmGeneral = new FrmGeneral();

        frmGeneral.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon backgroundImage = new ImageIcon(ImageIO.read(new File("D:\\Multiple projects\\unamba-training\\appdeskgame20231\\images\\fondo.jpg")));

        backgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(screenWidth, screenHeight, java.awt.Image.SCALE_SMOOTH));

        frmGeneral.setContentPane(new JLabel(backgroundImage));

        frmGeneral.setVisible(true);

        Ship ship = new Ship();

        frmGeneral.add(ship.component);

        frmGeneral.repaint();

        new ShipProcess(ship).start();
        
        new CreateProcess(frmGeneral).start();
    }
}
