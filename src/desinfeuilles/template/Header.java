/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.control.Label;

/**
 *
 * @author Benito
 */
public class Header extends LayoutComponent {
    

    public Header(String bannerH, LayoutTemplate template) {
        component = new Label(bannerH);
        initComponent(template);
        text = bannerH;
        type = "h";
    }
    
    public void setText(String s) {
        text = s;
        ((Label)component).setText(s);
    }
    
    public void revive() {
        super.revive();
        component = new Label(text);
        initComponent(template);
        applyCss();
    }
    
    public String getHTML() {
        return "<h>" + text + "</h>";
    }
}
