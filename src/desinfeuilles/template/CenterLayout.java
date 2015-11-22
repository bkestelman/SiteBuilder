/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_CENTER_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public class CenterLayout implements LayoutTemplate {
    VBox main;
    NavBarH nav;
    
    public CenterLayout() {
        main = new VBox();
        nav = new NavBarH();
        main.getChildren().add(nav);
        main.getStyleClass().add(CSS_CLASS_CENTER_LAYOUT);
    }
    
    @Override
    public VBox getMainPane() {
        return main;
    }

    @Override
    public ContentPane getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NavBar getNavBar() {
        return nav;
    }

    @Override
    public Banner getBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Footer getFooter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pane getSelectedPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "CenterLayout";
    }
}
