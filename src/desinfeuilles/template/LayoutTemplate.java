/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

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
    public abstract Pane getMainPane();
    public abstract ContentPane getContentPane();
    public abstract NavBarView getNavBar();
    public abstract Banner getBanner();
    public abstract Footer getFooter();
    public abstract Pane getSelectedPane();
    public abstract void applyStyle(StyleTemplate style);
    @Override
    public abstract String toString();
}
