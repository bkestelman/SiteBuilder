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
    int number;
    EditListDialog list;
    
    public ListElement(int i, EditListDialog list) {
        this.list = list;
        number = i;
        l = new Label("Element " + i);
        t = new TextField();
        removeB = new Button("Remove");
        getChildren().addAll(l, t);
        if(i != 1) {
            getChildren().add(removeB);
        }
        initRemoveBHandler();
    }
    
    public void initRemoveBHandler() {
        removeB.setOnAction(e -> {
            list.getRoot().getChildren().clear();
            list.getElements().remove(this);
            list.elementsCount--;
            for(ListElement el : list.getElements()) {
                if(el.number >= number) el.decNum();
                list.addNode(el);
            }
            list.readdAddB();
            list.addConfirm();
        });
    }
    
    public void setList(EditListDialog list) {
        this.list = list;
    }
    
    public void decNum() {
        l.setText("Element " + --number);
    }
    
    public String toString() {
        return t.getText();
    }
}
