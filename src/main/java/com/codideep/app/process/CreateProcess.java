/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.process;

import com.codideep.app.object.Asteroid;
import com.codideep.app.object.AsteroidAssociated;
import com.codideep.app.view.FrmGeneral;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author KAAF0
 */
public class CreateProcess extends Thread {

    private JFrame frm = null;
    private List<AsteroidAssociated> listAsteroidAssociated = null;
    private int asteroidLength = 0;
    private int projectilLength = 0;

    public CreateProcess(JFrame frm) {
        this.frm = frm;
        listAsteroidAssociated = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            asteroidLength = listAsteroidAssociated.size();
            projectilLength = FrmGeneral.listProjectilAssociated.size();
            
            for (int i = 0; i < asteroidLength; i++) {
                if (listAsteroidAssociated.get(i).getAsteroid().isRemove()) {
                    listAsteroidAssociated.get(i).getAsteroid().setStopThread();
                    frm.remove(listAsteroidAssociated.get(i).getAsteroid().component);
                    listAsteroidAssociated.get(i).setNull();

                    listAsteroidAssociated.remove(i);

                    asteroidLength--;
                }
            }
            
            for (int i = 0; i < projectilLength; i++) {
                if (FrmGeneral.listProjectilAssociated.get(i).getProjectil().isRemove()) {
                    FrmGeneral.listProjectilAssociated.get(i).getProjectil().setStopThread();
                    frm.remove(FrmGeneral.listProjectilAssociated.get(i).getProjectil().component);
                    FrmGeneral.listProjectilAssociated.get(i).setNull();

                    FrmGeneral.listProjectilAssociated.remove(i);

                    projectilLength--;
                }
            }

            Asteroid asteroid = new Asteroid();
            Thread thread = new Thread(asteroid);

            listAsteroidAssociated.add(new AsteroidAssociated(asteroid, thread));

            frm.add(asteroid.component);

            frm.repaint();

            thread.start();

            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
