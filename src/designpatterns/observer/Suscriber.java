/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Migue
 */
public class Suscriber implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Subriber: " + ((NewsPublisher) o).getNews());
    }
    
}
