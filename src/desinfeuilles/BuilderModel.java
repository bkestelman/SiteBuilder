/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import desinfeuilles.template.StyleTemplate;

/**
 *
 * @author Benito
 */
public class BuilderModel {
    SiteBuilder siteBuilder;
    
    StyleTemplate style;

    public BuilderModel(SiteBuilder sb) {
        siteBuilder = sb;
    }
    
    public void setStyle(StyleTemplate style) {
        this.style = style;
    }
    
    public StyleTemplate getStyle() {
        return style;
    }
    
}
