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
public class NavBarH extends NavBarView {
    HBox navBar;
    
    public NavBarH() {
        super();
        navBar = new HBox();
        navBar.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        navM = new NavBarModel();
    }
    
    @Override
    public void addPage(String pageName, String pageLink) {
        PageLabel pageLabel = new PageLabel(pageName);
        navBar.getChildren().add(pageLabel);
        getNavBarModel().addPage(pageLabel);
    }

    @Override
    public HBox getNavBarPane() {
        return navBar;
    }
}
