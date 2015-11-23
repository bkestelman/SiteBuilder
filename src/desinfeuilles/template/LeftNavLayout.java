/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_CENTER_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_CLASS_EMPTY_LAYOUT;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public class LeftNavLayout extends LayoutTemplate {
    BorderPane main;
    Banner banner;
    NavBarV nav;
    ContentPane contentPane;
    
    public LeftNavLayout() {
        main = new BorderPane();
        banner = new Banner("Benito Kestelman");
        nav = new NavBarV();
        main.setTop(banner);
        main.setLeft(nav.getNavBarPane());
        main.getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
    }
    
    @Override
    public BorderPane getMainPane() {
        return main;
    }

    @Override
    public ContentPane getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public String toString() {
        return "LeftNavLayout";
    }

    @Override
    public NavBarView getNavBar() {
        return nav;
    }

    @Override
    public void applyStyle(StyleTemplate style) {
        this.style = style;
        style.applyMainStyle(this);
    }
}
