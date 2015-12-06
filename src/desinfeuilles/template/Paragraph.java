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
public class Paragraph extends LayoutComponent {
    public Paragraph(String bannerH, LayoutTemplate template) {
        component = new Label(bannerH);
        initComponent(template);
        text = bannerH;
        type = "p";
    }
    
    public void setText(String s) {
        text = s;
        ((Label)component).setText(s);
    }
    
    public String getHTML() {
        return "<p>" + text + "</p>";
    }
}
