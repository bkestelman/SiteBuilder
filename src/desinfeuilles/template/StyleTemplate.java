/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

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
    String styleName, mainImagePath;
    
    public StyleTemplate(String style) {
        styleName = style;
    }
    
    public void setMainImage(String imagePath) {
        //main = new ImageView(new Image(PATH_IMAGES + imagePath));
        //layout.getMainPane().setStyle("-fx-background-image: " + PATH_IMAGES + imagePath);
        mainImagePath = imagePath;
    }
    
    public String getMainImagePath() {
        return mainImagePath;
    }
    
    @Override
    public String toString() {
        return styleName;
    }
}
