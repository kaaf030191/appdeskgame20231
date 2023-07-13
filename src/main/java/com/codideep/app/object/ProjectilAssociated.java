/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.object;

/**
 *
 * @author KAAF0
 */
public class ProjectilAssociated {
    private Projectil projectil = null;
    private Thread thread = null;

    public ProjectilAssociated(Projectil asteroid, Thread thread) {
        this.projectil = asteroid;
        this.thread = thread;
    }

    public Projectil getProjectil() {
        return this.projectil;
    }

    public Thread getThread() {
        return this.thread;
    }

    public void setNull() {
        this.thread = null;
        this.projectil = null;
    }
}
