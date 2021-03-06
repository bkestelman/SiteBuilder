/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_NAV_SIMPLE;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public class NavBarV extends NavBar{
    
    public NavBarV(LayoutTemplate template) {
        super();
        component = new VBox();
        initComponent(template);
        component.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        navM = new NavBarModel(template);
    }


    @Override
    public VBox getNavBarPane() {
        return (VBox)component;
    }
    
    public void revive() {
        super.revive();
        component = new VBox();
        initComponent(template); 
        component.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        for(PageLabel p : navM.getPages()) {
            p.revive();
            ((VBox)component).getChildren().add(p.getComponent());
        }
        applyCss();
    }
}
