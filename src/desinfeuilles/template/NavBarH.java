/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_NAV_SIMPLE;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author bkestelman
 */
public class NavBarH extends NavBar {
    public NavBarH(LayoutTemplate template) {
        super();
        component = new HBox();
        initComponent(template);
        component.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        navM = new NavBarModel(template);
    }
    
    @Override
    public void addPage(String pageName, String pageLink) {
        PageLabel pageLabel = new PageLabel(pageName, template);
        pageLabel.setParent(this);
        ((HBox)component).getChildren().add(pageLabel.getComponent());
        getNavBarModel().addPage(pageLabel);
    }

    @Override
    public HBox getNavBarPane() {
        return (HBox)component;
    }
    
    public void revive() {
        super.revive();
        component = new HBox();
        initComponent(template); 
        component.getStyleClass().add(CSS_CLASS_NAV_SIMPLE);
        for(PageLabel p : navM.getPages()) {
            p.revive();
            ((HBox)component).getChildren().add(p.getComponent());
        }
        applyCss();
    }
    
    public String getHTML() {
        String s = "<nav><ul>";
        for(PageLabel p : navM.getPages()) {
            s += "<li><a href='" + p.getLink() + "'>" + p.getText() + "</a></li>";
        }
        return s + "</ul></nav>";
    }
}
