/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.process;

import com.codideep.app.object.Projectil;
import com.codideep.app.object.ProjectilAssociated;
import com.codideep.app.view.FrmGeneral;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author KAAF0
 */
public class ProjectilProcess extends Thread {

    private JFrame frm = null;
    
    public ProjectilProcess(JFrame frm) {
        this.frm = frm;
    }

    @Override
    public void run() {
        while (true) {
            if (Projectil.createProjectil) {
                Projectil projectil = new Projectil();
                frm.add(projectil.component);

                frm.repaint();

                Thread thread = new Thread(projectil);

                thread.start();

                FrmGeneral.listProjectilAssociated.add(new ProjectilAssociated(projectil, thread));
            }

            try {
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectilProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
