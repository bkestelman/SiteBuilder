/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author bkestelman
 */
public class NavBarH extends NavBar {
    HBox navBar;
    
    public NavBarH() {
        super();
        navBar = new HBox();
    }
    
    public HBox getNavBar() {
        return navBar;
    }

    @Override
    public void initPageClickHandler(Label pageLabel) {
        pageLabel.setOnMouseClicked(e -> {
            
        });
    }

    @Override
    public void addToNavBar(Label pageLabel) {
        navBar.getChildren().add(pageLabel);
        initPageClickHandler(pageLabel);
    }
}
