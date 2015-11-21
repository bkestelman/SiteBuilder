/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.layout.Pane;

/**
 *
 * @author bkestelman
 */
public interface LayoutTemplate {
    /*Pane mainPane;
    NavBar nav;
    Banner banner;
    ContentPane content;
    Footer footer;*/
    
    //public abstract Pane getMainPane();
    public ContentPane getContentPane();
    public NavBar getNavBar();
    public Banner getBanner();
    public Footer getFooter();
    public Pane getSelectedPane();
    public String toString();
}
