/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

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
    static Node selectedNode; 
    
    public static void setSelectedNode(Node n) {
        selectedNode = n;
    }
    public static Node getSelectedNode() {
        return selectedNode;
    }
    public abstract void addPage(String pageName, String pageLink);
    public abstract void addBanner(Banner banner);
    public abstract void addNav(NavBar nav);
    public abstract void addFooter(Footer footer);
    public abstract void addContentPane(ContentPane cpane);
    public abstract void addParagraph(String p);
    public abstract void addHeader(String h);
    public abstract Pane getMainPane();
    public abstract ContentPane getContentPane();
    public abstract NavBar getNavBar();
    public abstract Banner getBanner();
    public abstract Footer getFooter();
    public abstract Pane getSelectedPane();
    public abstract void applyStyle(StyleTemplate style);
    @Override
    public abstract String toString();
}
