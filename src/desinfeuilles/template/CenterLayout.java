/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_CENTER_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_CLASS_EMPTY_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public class CenterLayout extends LayoutTemplate {
    BorderPane main;
    Banner banner;
    NavBarH nav;
    ContentPane contentPane;
    Footer footer;
    VBox top;
    
    public CenterLayout() {
        main = new BorderPane();
        top = new VBox();
        banner = new Banner("Original Website");
        nav = new NavBarH();
        top.getChildren().addAll(banner, nav.getNavBarPane());
        main.setTop(top);
        main.getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
        footer = new Footer("This is a footer");
        main.setBottom(footer);
    }
    
    @Override
    public BorderPane getMainPane() {
        return main;
    }

    @Override
    public ContentPane getContentPane() {
        return contentPane;
    }

    @Override
    public Banner getBanner() {
        return banner;
    }

    @Override
    public Footer getFooter() {
        return footer;
    }

    @Override
    public Pane getSelectedPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "CenterLayout";
    }

    @Override
    public NavBarView getNavBar() {
        return nav;
    }

    @Override
    public void applyStyle(StyleTemplate style) {
        this.style = style;
        style.applyFullStyle(this);
    }
}
