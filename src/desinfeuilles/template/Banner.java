/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_BANNER;
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
public class Banner extends HBox {
    public Label bannerHeader;
    public ImageView bannerImage;
    
    public Banner(String bannerH) {
        bannerHeader = new Label(bannerH);
        this.getChildren().add(bannerHeader);
        this.getStyleClass().add(CSS_CLASS_BANNER);
        initSelectEventHandlers();
        setPrefHeight(210);
    }

    Banner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setBannerImage(ImageView imv) {
        bannerImage = imv;
    }
    
    public Label getHeader() {
        return bannerHeader;
    }
    
    public void initSelectEventHandlers() {
        bannerHeader.setOnMouseClicked(e -> {
            bannerHeader.getStyleClass().add(CSS_CLASS_SELECTED);
        });
        this.setOnMouseClicked(e -> {
            getStyleClass().add(CSS_CLASS_SELECTED);
        });
    }
}
