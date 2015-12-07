/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leora
 */
public abstract class NavBar extends LayoutComponent {
    NavBarModel navM;
    
    public NavBarModel getNavBarModel() {
        return navM;
    }
    
    public void addPage(String pageName, String pageLink) {
        PageLabel pageLabel = new PageLabel(pageName, template);
        pageLabel.setParent(this);
        ((Pane)component).getChildren().add(pageLabel.getComponent());
        getNavBarModel().addPage(pageLabel);
    }
    //public abstract void initPageClickHandler(Label pageLabel); //must be called by addToNavBar()
    public abstract Pane getNavBarPane();

    public String getHTML() {
        String s = "<nav><ul>";
        for(PageLabel p : navM.getPages()) {
            s += "<li><a href='" + p.getLink() + "'>" + p.getText() + "</a></li>";
        }
        return s + "</ul></nav>";
    }
    
}
