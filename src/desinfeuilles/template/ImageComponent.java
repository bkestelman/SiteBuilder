/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_IMG_COMPONENT;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Benito
 */
public class ImageComponent extends LayoutComponent {
    Label caption;
    ImageView img;
    
    public ImageComponent(ImageView img, String cap, LayoutTemplate template) {
        super();
        this.img = img;
        this.caption = new Label(cap);
        component = new VBox();
        ((VBox)component).getChildren().addAll(img, caption);
        initComponent(template);
        img.getStyleClass().add(CSS_CLASS_IMG_COMPONENT);
        type = "img";
    }
    
    public void setImage(String path) {
        ((ImageView)component).setImage(new Image(path));
    }
    
    public void setCaption(String cap) {
        caption.setText(cap);
    }
    
    public void setWH(String w, String h) {
        if(w != null && h != null) {
                    ((ImageView)img).setFitWidth(Integer.parseInt(w));
                    ((ImageView)img).setFitHeight(Integer.parseInt(h));
                }
                else if(w == null && h != null) {
                    ((ImageView)img).setFitHeight(Integer.parseInt(h));
                    ((ImageView)img).setPreserveRatio(true);
                }
                else if(h == null && w != null) {
                    ((ImageView)img).setFitWidth(Integer.parseInt(w));
                    ((ImageView)img).setPreserveRatio(true);
                }
    }
}
