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
public class NavBarV extends NavBarView{
    VBox navBar;
    
    public NavBarV() {
        super();
        navBar = new VBox();
        navBar.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
    }

    @Override
    public void initPageClickHandler(Label pageLabel) {
        pageLabel.setOnMouseClicked(e -> {
            
        });
    }

    @Override
    public void addPage(String pageName, String pageLink) {
        Label pageLabel = new Label(pageName);
        navBar.getChildren().add(pageLabel);
        initPageClickHandler(pageLabel);
    }

    @Override
    public VBox getNavBarPane() {
        return navBar;
    }
}
