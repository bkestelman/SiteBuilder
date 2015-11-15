/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_CONTROLLER;
import static desinfeuilles.StartupConstants.PATH_TEMPLATES;
import desinfeuilles.view.BuilderView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Benito
 */
public class StyleController {
    public static final float HEIGHT = 150;
    public static final int TEMPLATES = 1;
    
    BuilderView view;
    HBox main;
    SiteBuilder siteBuilder;
    
    public StyleController(SiteBuilder sb) {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
        siteBuilder = sb;
    }
    
    public void setView(BuilderView v) {
        view = v;
    }
    
    public void openTemplateChooser() {
        view.getBorderPane().setBottom(main);
        Rectangle offset = new Rectangle();
        offset.setWidth(view.getStyleToolbar().getWidth() + 20);
        offset.setHeight(HEIGHT);
        offset.setFill(Color.WHITE);
        offset.setStroke(Color.WHITE);
        main.getChildren().add(offset);
        
        generateTemplateOptions();
        
        if(siteBuilder.getTutorial() != null) {
            siteBuilder.getTutorial().pointToStyleController();
        }
    }
    
    public void generateTemplateOptions() {
        for(int i = 1; i <= TEMPLATES; i++) {
            ImageView im = new ImageView(new Image("file:" + PATH_TEMPLATES + "template" + i + ".png"));
            main.getChildren().add(im);
        }
    }
    
    public HBox getMain() {
        return main;
    }
    
    public float getHeight() {
        return HEIGHT;
    }
}
