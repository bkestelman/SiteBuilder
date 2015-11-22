/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Leora
 */
public abstract class NavBarView {
    NavBarModel navM;
    
    public NavBarModel getNavBarModel() {
        return navM;
    }
    
    public abstract void addPage(String pageName, String pageLink);
    public abstract void initPageClickHandler(Label pageLabel); //must be called by addToNavBar()
    public abstract Pane getNavBarPane();
}
