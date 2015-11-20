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
public interface Template {
    
    public MainPane getMainPane();
    public ContentPane getContentPane();
    public NavBar getNavBar();
    public BannerPane getBanner();
    public Footer getFooter();
    public Pane getSelectedPane();
}
