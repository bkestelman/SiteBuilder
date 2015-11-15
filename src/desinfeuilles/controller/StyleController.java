/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_CONTROLLER;
import desinfeuilles.view.BuilderView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Benito
 */
public class StyleController {
    BuilderView view;
    HBox main;
    SiteBuilder siteBuilder;
    float height;
    
    public StyleController(SiteBuilder sb) {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
        siteBuilder = sb;
        height = 0;
    }
    
    public void setView(BuilderView v) {
        view = v;
    }
    
    public void openTemplateChooser() {
        view.getBorderPane().setBottom(main);
        Rectangle t1 = new Rectangle();
        t1.setWidth(75);
        t1.setHeight(75);
        t1.setFill(Color.WHITE);
        t1.setStroke(Color.BLACK);
        height += 75;
        main.getChildren().add(t1);
        if(siteBuilder.getTutorial() != null) {
            siteBuilder.getTutorial().pointToStyleController();
        }
    }
    
    public HBox getMain() {
        return main;
    }
    
    public float getHeight() {
        return height;
    }
}
