/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
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
    HashMap<PageLabel, String> pages; //also contain links
    
    public NavBarModel() {
        pages = new HashMap<>();
    }
    
    public void addPage(String pageName, String pageLink) {
        PageLabel pageLabel = new PageLabel(pageName);
        pages.put(pageLabel, pageLink);
    }
    
    public void addPage(PageLabel pageLabel) {
        pages.put(pageLabel, "bluh.html");
    }
    
    public HashMap<PageLabel, String> getPages() {
        return pages;
    }

}
