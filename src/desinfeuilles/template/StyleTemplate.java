/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_BANNER_HEADER;
import static desinfeuilles.StartupConstants.PATH_IMAGES;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Leora
 */
public class StyleTemplate {
    //ImageView mainImage, bannerImage;
    //LayoutTemplate layout;
    String styleName, mainImagePath, bannerImagePath;
    
    public StyleTemplate(String style) {
        styleName = style;
    }
    
    public void applyFullStyle(LayoutTemplate layout) {
        applyMainStyle(layout);
        applyBannerStyle(layout);
    }
    
    public void applyMainStyle(LayoutTemplate layout) {
        layout.getMainPane().setStyle("-fx-background-image: url(file:" + mainImagePath + ");");
    }
    
    public void applyBannerStyle(LayoutTemplate layout) {
        layout.getBanner().getComponent().setStyle("-fx-background-image: url(file:" + bannerImagePath + ");");
        layout.getBanner().getHeader().getComponent().getStyleClass().add(CSS_CLASS_BANNER_HEADER);
    }
    
    public void setMainImagePath(String imagePath) {
        //main = new ImageView(new Image(PATH_IMAGES + imagePath));
        //layout.getMainPane().setStyle("-fx-background-image: " + PATH_IMAGES + imagePath);
        mainImagePath = imagePath;
    }
    
    public void setBannerImagePath(String imagePath) {
        bannerImagePath = imagePath;
    }
    
    public String getMainImagePath() {
        return mainImagePath;
    }
    
    @Override
    public String toString() {
        return styleName;
    }
}
