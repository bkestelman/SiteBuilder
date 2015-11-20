/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import java.util.HashMap;
import javafx.scene.control.Label;

/**
 *
 * @author bkestelman
 */
public abstract class NavBar {
    HashMap<Label, String> pages; //also contain links
    
    public void addPage(String pageName, String pageLink) {
        Label pageLabel = new Label(pageName);
        pages.put(pageLabel, pageLink);
        addToNavBar(pageLabel);
    }
    
    public HashMap<Label, String> getPages() {
        return pages;
    }
    
    public abstract void addToNavBar(Label pageLabel);
    public abstract void initPageClickHandler(Label pageLabel); //must be called by addToNaveBar()
}
