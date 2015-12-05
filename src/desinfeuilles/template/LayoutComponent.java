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
    LayoutComponent parent;
    LayoutTemplate template;
    String text;
    String type; //h=header, p=paragraph, l=list, v=video, s=slideshow, b=banner, f=footer
    
    public void initComponent(LayoutTemplate template) {
        isSelected = false;
        initClickListener();
        this.template = template;
        template.addComponent(this);
    }
    
    public void invertSelected() {
        isSelected = !isSelected;
        if(isSelected) {
            if(!template.balls) {
            LayoutComponent preSelected = template.getSelectedComponent();
            if(preSelected != null) preSelected.deselect();
            template.setSelectedComponent(this);
            }
            component.getStyleClass().add(CSS_CLASS_SELECTED);
        }
        else {
            component.getStyleClass().remove(CSS_CLASS_SELECTED);
        }
    }
    
    public void deselect() {
        isSelected = false;
        component.getStyleClass().remove(CSS_CLASS_SELECTED);
    }

    public void initClickListener()  {
        component.setOnMouseClicked(e -> {
            //template.unselectStuff();
            invertSelected(); 
            if(parent != null) {
                template.balls = true;
                parent.invertSelected();
                template.balls = false;
            }
        });
    }
    
    public boolean isSelected() {
        return isSelected;
    }

    public Node getComponent() {
        return component;
    }
    
    public void setParent(LayoutComponent parent) {
        this.parent = parent;
    }
    
    public LayoutComponent getParent() {
        return parent;
    }
    
    public LayoutTemplate getTemplate() {
        return template;
    }
    
    public void setTemplate(LayoutTemplate template) {
        this.template = template;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String s) {
        text = s;
    }
    
    public String getType() {
        return type;
    }
}
