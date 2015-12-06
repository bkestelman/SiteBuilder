/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

/**
 *
 * @author bkestelman
 */
public class ContentPane extends LayoutComponent {
    //public ObservableList<ContentComponent> content;
            
    public ContentPane(LayoutTemplate template) {
        component = new VBox();
        initComponent(template);
    }
    
    public void addContent(ContentComponent component) {
        
    }
    
    public void revive() {
        component = new VBox();
        initComponent(template);
    }
}
