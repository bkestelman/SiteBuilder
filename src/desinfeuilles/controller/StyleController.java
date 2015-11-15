/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_CONTROLLER;
import desinfeuilles.view.BuilderView;
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
    
    public StyleController() {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
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
        main.getChildren().add(t1);
    }
}
