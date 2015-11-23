/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_BANNER;
import javafx.scene.control.Label;
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
}
