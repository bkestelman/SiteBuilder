/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.control.Label;

/**
 *
 * @author Benito
 */
public class PageLabel extends Label {
    boolean selected;
    
    public PageLabel(String l) {
        super(l);
        selected = false;
    }
    
    public PageLabel() {
        
    }
    
    public void invertSelected() {
        selected = !selected;
    }
    
    public boolean isSelected() {
        return selected;
    }
}
