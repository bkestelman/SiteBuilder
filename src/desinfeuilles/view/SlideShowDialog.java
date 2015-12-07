/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import static desinfeuilles.StartupConstants.PATH_SLIDESHOW_IMAGES;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Benito
 */
public class SlideShowDialog extends CustomDialog {
    int listElements;
    
    public SlideShowDialog() {
        super();
        listElements = 1;
        getIcons().add(new Image("file:" + PATH_ICONS + "Slides.png"));
        
        HBox element1 = new HBox();
        Label l1 = new Label("Slide 1 Caption: ");
        TextField t1 = new TextField();
        Button b1 = new Button("Browse Image");
        ImageView im1 = new ImageView(new Image("file:" + PATH_SLIDESHOW_IMAGES + "DefaultStartSlide.png"));
        element1.getChildren().addAll(l1, t1, b1, im1);
        addNode(element1);
        
        Button add = new Button("Add Slide");
        addNode(add);
        
        ArrayList<HBox> elements = new ArrayList<>();
        elements.add(element1);
        
        add.setOnAction(e -> {
           Label l = new Label("Slide " + (++listElements) + " Caption: ");
           TextField t = new TextField();
           Button b = new Button("Browse Image");
           ImageView im = new ImageView(new Image("file:" + PATH_SLIDESHOW_IMAGES + "DefaultStartSlide.png"));
           HBox el = new HBox();
           el.getChildren().addAll(l, t, b, im);
           elements.add(el);
           getRoot().getChildren().clear();
           for(HBox h : elements) {
               addNode(h);
           }
           addNode(add);
           addConfirm();
           element1.impl_processCSS(true);
           addHeight(element1.getHeight());
        });
    }
}
