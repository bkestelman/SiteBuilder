/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_CENTER_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_CLASS_EMPTY_LAYOUT;
import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public class LeftNavLayout extends LayoutTemplate {
    
    public LeftNavLayout() {
        //components = new ArrayList<>();
        main = new BorderPane();
        banner = new Banner("My Website", this);
        nav = new NavBarV(this);
        main.setTop(banner.getComponent());
        main.setLeft(nav.getNavBarPane());
        main.getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
        footer = new Footer("This is a footer", this);
        main.setBottom(footer.getComponent());
        contentPane = new ContentPane(this);
        main.setCenter(contentPane.getComponent());
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
    
    public String toString() {
        return "LeftNavLayout";
    }

    @Override
    public NavBar getNavBar() {
        return nav;
    }

    @Override
    public void applyStyle(StyleTemplate style) {
        this.style = style;
        style.applyFullStyle(this);
    }

    @Override
    public void addPage(String pageName, String pageLink) {
        super.addPage(pageName, pageLink);
        nav.getNavBarModel().addPage(pageName, pageLink);
    }

    @Override
    public void addBanner(Banner banner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNav(NavBar nav) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFooter(Footer footer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addContentPane(ContentPane cpane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void revive() {
        super.revive();
        main.setLeft(nav.getComponent());
        main.setTop(banner.getComponent());
        main.getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
    }
}
