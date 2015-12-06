/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.layout.Pane;

/**
 *
 * @author Leora
 */
public class EmptyLayout extends LayoutTemplate {
    Pane main;
    StyleTemplate style;
    
    public EmptyLayout() {
        main = new Pane();
    }

    @Override
    public Pane getMainPane() {
        return main;
    }

    @Override
    public ContentPane getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NavBar getNavBar() {
        return null;
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
    
    public void applyStyle(StyleTemplate style) {
        this.style = style;
        style.applyMainStyle(this);
        //main.setStyle("-fx-background-image: url(file:" + style.getMainImagePath() + ")");
        //main.setStyle("-fx-background-color: blue;");
    }
    
    @Override
    public String toString() {
        return "Empty";
    }

    @Override
    public void addPage(String pageName, String pageLink) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void addParagraph(String p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHeader(String h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
