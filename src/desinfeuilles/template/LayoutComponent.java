/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 *
 * @author Benito
 */
public class LayoutComponent implements Serializable {
    boolean isSelected;
    transient Node component; //not all layout components will use this field (for instance, NavBars have their own HBox or VBox component)
    LayoutComponent parent;
    LayoutTemplate template;
    String text;
    String type; //h=header, p=paragraph, l=list, v=video, s=slideshow, b=banner, f=footer, img=image
    String fontStyleClass;
    ArrayList<String> cssClasses;
    ArrayList<String> styles;
    String html;
    
    public LayoutComponent() {
        cssClasses = new ArrayList<>();
        styles = new ArrayList<>();
    }
    
    public void initComponent(LayoutTemplate template) {
        isSelected = false;
        initClickListener();
        this.template = template;
        template.addComponent(this);
        component.getStyleClass().add("component");
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

    public String getFontStyleClass() {
        return fontStyleClass;
    }

    public void setFontStyleClass(String fontStyleClass) {
        this.fontStyleClass = fontStyleClass;
    }
    
    //override
    public void revive() {
        
    }
    
    public void applyCss() {
        for(String c : cssClasses) {
            component.getStyleClass().add(c);
        }
        for(String s : styles) {
            component.setStyle(s);
        }
    }
    
}
