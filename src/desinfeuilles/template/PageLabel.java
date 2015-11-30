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
import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import javafx.scene.control.Label;

/**
 *
 * @author Benito
 */
public class PageLabel extends LayoutComponent {
    
    public PageLabel(String label) {
        isSelected = false;
        component = new Label(label);
        initComponent();
    }
    
    public PageLabel() {
        
    }
    
    public boolean isSelected() {
        return isSelected;
    }

}
