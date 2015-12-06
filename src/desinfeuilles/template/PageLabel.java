/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import static desinfeuilles.StartupConstants.CSS_CLASS_PAGE_LABEL;
import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import javafx.scene.control.Label;

/**
 *
 * @author Benito
 */
public class PageLabel extends LayoutComponent {
    
    public PageLabel(String label, LayoutTemplate template) {
        isSelected = false;
        component = new Label(label);
        text = label;
        initComponent(template);
        component.getStyleClass().add(CSS_CLASS_PAGE_LABEL);
        type = "PageLabel";
    }
    
    public boolean isSelected() {
        return isSelected;
    }
    
    public void select() {
        component.getStyleClass().add(CSS_CLASS_SELECTED);
        template.setSelectedComponent(this);
    }

    public void revive() {
        component = new Label(text);
        initComponent(template);
        component.getStyleClass().add(CSS_CLASS_PAGE_LABEL);
    }
}
