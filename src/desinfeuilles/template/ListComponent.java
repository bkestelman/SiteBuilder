/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import desinfeuilles.view.ListElement;
import java.util.ArrayList;
import javafx.scene.control.Label;

/**
 *
 * @author Benito
 */
public class ListComponent extends LayoutComponent {
    ArrayList<ListElement> elements;
    
    public ListComponent(ArrayList<ListElement> elements, LayoutTemplate template) {
        this.elements = elements;
        component = new Label();
        initComponent(template);
        for(ListElement el : elements) {
            ((Label)component).setText(((Label)component).getText() + el + "\n");
        }
    }
}
