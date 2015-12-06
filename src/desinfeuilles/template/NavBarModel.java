/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author bkestelman
 */
public class NavBarModel extends LayoutComponent {
    ArrayList<PageLabel> pages; //also contain links
    String newestPage;
    
    public NavBarModel(LayoutTemplate template) {
        pages = new ArrayList<>();
        this.template = template;
    }
    
    public void addPage(String pageName, String pageLink) {
        newestPage = pageName;
        PageLabel pageLabel = new PageLabel(pageName, template);
        pages.add(pageLabel);
    }
    
    public String getNewestPageName() {
        return newestPage;
    }
    
    public void addPage(PageLabel pageLabel) {
        pages.add(pageLabel);
        newestPage = ((Label)pageLabel.getComponent()).getText();
    }
    
    public ArrayList<PageLabel> getPages() {
        return pages;
    }

}
