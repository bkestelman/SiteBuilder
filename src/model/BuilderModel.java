/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import desinfeuilles.SiteBuilder;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.StyleTemplate;

/**
 *
 * @author Benito
 */
public class BuilderModel {
    SiteBuilder siteBuilder;
    
    StyleTemplate style;
    LayoutTemplate layout;

    public BuilderModel(SiteBuilder sb) {
        siteBuilder = sb;
    }
    
    public void setStyle(StyleTemplate style) {
        this.style = style;
    }
    
    public StyleTemplate getStyle() {
        return style;
    }

    public LayoutTemplate getLayout() {
        return layout;
    }

    public void setLayout(LayoutTemplate layout) {
        this.layout = layout;
    }
    
    
    
}
