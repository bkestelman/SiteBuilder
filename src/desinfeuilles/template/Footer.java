/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_AQUA_FOOTER;
import static desinfeuilles.StartupConstants.CSS_CLASS_FOOTER_TEXT;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author bkestelman
 */
public class Footer extends LayoutComponent {
    Header footerHeader; 
    
    public Footer(String footerText) {
        component = new HBox();
        initComponent();
        addHeader(footerText);
        component.getStyleClass().add(CSS_CLASS_AQUA_FOOTER);
        ((HBox)component).setMinHeight(50);
    }
    
    public void addHeader(String headerText) {
        footerHeader = new Header(headerText); 
        footerHeader.setParent(this);
        ((HBox)component).getChildren().add(footerHeader.getComponent());
        (footerHeader.getComponent()).getStyleClass().add(CSS_CLASS_FOOTER_TEXT);
    }
}
