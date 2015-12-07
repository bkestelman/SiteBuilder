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
    transient Label caption;
    transient ImageView img;
    int w, h;
    String cap, imgPath;
    
    public ImageComponent(String imgPath, String cap, LayoutTemplate template) {
        super();
        this.imgPath = imgPath;
        img = new ImageView(new Image(imgPath));
        this.cap = cap;
        this.caption = new Label(cap);
        component = new VBox();
        ((VBox)component).getChildren().addAll(img, caption);
        initComponent(template);
        img.getStyleClass().add(CSS_CLASS_IMG_COMPONENT);
        type = "img";
        w = h = 0;
    }
    
    public void setImage(String path) {
        imgPath = path;
        img.setImage(new Image(path));
    }
    
    public void setCaption(String cap) {
        caption.setText(cap);
        this.cap = cap;
    }
    
    public void setWH(int w, int h) {
        this.w = w;
        this.h = h;
        if(w != 0) img.setFitWidth(w);
        if(h != 0) img.setFitHeight(h);
        if(w == 0 || h == 0) img.setPreserveRatio(true);
    }
    
    public void revive() {
        super.revive();
        component = new VBox();
        initComponent(template);
        caption = new Label(cap);
        img = new ImageView(imgPath);
        setWH(w, h);
    }
    
    public String getHTML() {
        return "<img src=>";
    }
}
