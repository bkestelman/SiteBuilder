/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author bkestelman
 */
public abstract class LayoutTemplate {
    /*Pane mainPane;
    NavBar nav;
    Banner banner;
    ContentPane content;
    Footer footer;*/
    StyleTemplate style;
    ContentPane contentPane;
    LayoutComponent selectedComponent; 
    ArrayList<LayoutComponent> components = new ArrayList<>();
    public static boolean balls = false;
    
    public void setSelectedComponent(LayoutComponent n) {
        selectedComponent = n;
    }
    public LayoutComponent getSelectedComponent() {
        return selectedComponent;
    }
    public abstract void addPage(String pageName, String pageLink);
    public abstract void addBanner(Banner banner);
    public abstract void addNav(NavBar nav);
    public abstract void addFooter(Footer footer);
    public abstract void addContentPane(ContentPane cpane);
    public abstract Pane getMainPane();
    public ContentPane getContentPane() {return contentPane;}
    public abstract NavBar getNavBar();
    public abstract Banner getBanner();
    public abstract Footer getFooter();
    public abstract Pane getSelectedPane();
    public abstract void applyStyle(StyleTemplate style);
    @Override
    public abstract String toString();
    public void addComponent(LayoutComponent component) {
        components.add(component);
    }
    public ArrayList<LayoutComponent> getComponents() {
        return components;
    }
    public void unselectStuff() { 
        for(LayoutComponent c : components) {
            if(!c.isSelected()) {
                //c.getComponent().impl_processCSS(true);
                c.getComponent().getStyleClass().remove(CSS_CLASS_SELECTED);
            }
        }
    }

    public void addParagraph(String pText) {
        Paragraph p = new Paragraph(pText, this);
        components.add(p);
        p.setParent(contentPane);
        ((VBox)(contentPane.getComponent())).getChildren().add(p.getComponent());
    }
    
    public void addHeader(String hText) {
        Header h = new Header(hText, this);
        components.add(h);
        h.setParent(contentPane);
        ((VBox)(contentPane.getComponent())).getChildren().add(h.getComponent());
    }
}
