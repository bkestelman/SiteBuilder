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
    transient ArrayList<ListElement> elements;
    ArrayList<String> stringElements;
    
    public ListComponent(ArrayList<ListElement> elements, LayoutTemplate template) {
        this.elements = elements;
        component = new Label();
        initComponent(template);
        for(ListElement el : elements) {
            text += ((Label)component).getText() + "\u2022" + el + "\n";
            ((Label)component).setText(((Label)component).getText() + "\u2022" + el + "\n");
        }
        type = "l";
    }
    
    public void reload() {
        text = "";
        ((Label)component).setText("");
        for(ListElement el : elements) {
            text += ((Label)component).getText() + "\u2022" + el + "\n";
            ((Label)component).setText(((Label)component).getText() + "\u2022" + el + "\n");
        }
    }
    
    public void revive() {
        super.revive();
        elements = new ArrayList<>();
        component = new Label(text);
        initComponent(template);
        applyCss();
    }
    
    public ArrayList<ListElement> getElements() {
        return elements;
    }
    
    public String getHTML() {
        String s = "<ul>";
        for(ListElement el : elements) {
            s += "<li>" + el + "</li>";
        }
        return s + "</ul>";
    }
}
