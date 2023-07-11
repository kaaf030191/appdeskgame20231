/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.object;

/**
 *
 * @author KAAF0
 */
public class AsteroidAssociated {

    private Asteroid asteroid = null;
    private Thread thread = null;

    public AsteroidAssociated(Asteroid asteroid, Thread thread) {
        this.asteroid = asteroid;
        this.thread = thread;
    }

    public Asteroid getAsteroid() {
        return this.asteroid;
    }

    public Thread getThread() {
        return this.thread;
    }

    public void setNull() {
        this.thread = null;
        this.asteroid = null;
    }
}
