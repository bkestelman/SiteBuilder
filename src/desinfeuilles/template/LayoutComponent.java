/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 *
 * @author Benito
 */
public class LayoutComponent {
    boolean isSelected;
    Node component; //not all layout components will use this field (for instance, NavBars have their own HBox or VBox component)
    
    public void initComponent() {
        isSelected = false;
        initClickListener();
    }
    
    public void invertSelected() {
        isSelected = !isSelected;
        if(isSelected) {
            component.getStyleClass().add(CSS_CLASS_SELECTED);
        }
        else {
            component.getStyleClass().remove(CSS_CLASS_SELECTED);
        }
    }

    public void initClickListener()  {
        component.setOnMouseClicked(e -> {
           invertSelected(); 
        });
    }

    public Node getComponent() {
        return component;
    }
}
