/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author bkestelman
 */
public class NavBarModel {
    HashMap<Label, String> pages; //also contain links
    
    public NavBarModel() {
        pages = new HashMap<>();
    }
    
    public void addPage(String pageName, String pageLink) {
        Label pageLabel = new Label(pageName);
        pages.put(pageLabel, pageLink);
    }
    
    public HashMap<Label, String> getPages() {
        return pages;
    }
    
    //public abstract void addToNavBar(Label pageLabel);
    //public abstract void initPageClickHandler(Label pageLabel); //must be called by addToNavBar()
}