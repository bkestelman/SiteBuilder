/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_IMG_COMPONENT;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Benito
 */
public class ImageComponent extends LayoutComponent {
    
    public ImageComponent(ImageView img, LayoutTemplate template) {
        super();
        component = img;
        initComponent(template);
        img.getStyleClass().add(CSS_CLASS_IMG_COMPONENT);
        type = "img";
    }
    
    public void setImage(String path) {
        ((ImageView)component).setImage(new Image(path));
    }
    
    public void setWH(String w, String h) {
        if(w != null && h != null) {
                    ((ImageView)component).setFitWidth(Integer.parseInt(w));
                    ((ImageView)component).setFitHeight(Integer.parseInt(h));
                }
                else if(w == null && h != null) {
                    ((ImageView)component).setFitHeight(Integer.parseInt(h));
                    ((ImageView)component).setPreserveRatio(true);
                }
                else if(h == null && w != null) {
                    ((ImageView)component).setFitWidth(Integer.parseInt(w));
                    ((ImageView)component).setPreserveRatio(true);
                }
    }
}
