/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Benito
 */
public class ListElement extends HBox {
    TextField t;
    Label l;
    Button removeB;
    
    public ListElement(int i) {
        l = new Label("Element " + i);
        t = new TextField();
        removeB = new Button("Remove");
        getChildren().addAll(l, t, removeB);
    }
    
    public String toString() {
        return t.getText();
    }
}
