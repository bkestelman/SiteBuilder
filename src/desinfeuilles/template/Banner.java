/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_BANNER;
import static desinfeuilles.StartupConstants.CSS_CLASS_BANNER_HEADER;
import static desinfeuilles.StartupConstants.CSS_CLASS_EMPTY_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED_IMAGE;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author bkestelman
 */
public class Banner extends LayoutComponent {
    Header bannerHeader;
    public ImageView bannerImage;
    boolean bannerHeaderSelected;
    boolean bannerSelected;
    
    public Banner(String bannerH) {
        component = new HBox();
        initComponent();
        setHeader(bannerH);
        component.getStyleClass().add(CSS_CLASS_BANNER);
        ((HBox)component).setPrefHeight(210);
        bannerHeaderSelected = bannerSelected = false;
    }

    Banner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setBannerImage(ImageView imv) {
        bannerImage = imv;
    }
    
    public void setHeader(String bannerH) {
        bannerHeader = new Header(bannerH);
        ((HBox)component).getChildren().add(bannerHeader.getComponent());
    }
    
    public Header getHeader() {
        return bannerHeader;
    }

}
