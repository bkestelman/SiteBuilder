/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_NAV_SIMPLE;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author bkestelman
 */
public class NavBarH extends NavBar {
    public NavBarH() {
        super();
        component = new HBox();
        initComponent();
        component.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        navM = new NavBarModel();
    }
    
    @Override
    public void addPage(String pageName, String pageLink) {
        PageLabel pageLabel = new PageLabel(pageName);
        pageLabel.setParent(this);
        ((HBox)component).getChildren().add(pageLabel.getComponent());
        getNavBarModel().addPage(pageLabel);
    }

    @Override
    public HBox getNavBarPane() {
        return (HBox)component;
    }
}
