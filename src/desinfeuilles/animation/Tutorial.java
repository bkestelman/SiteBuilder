/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.animation;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import static desinfeuilles.StartupConstants.CSS_CLASS_ANIM_HBOX;
import desinfeuilles.view.BuilderView;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Benito
 */
public class Tutorial {
    BuilderView view; 
    
    HBox g;
    VBox left;
    HBox bot;
    ImageView arrow;
    
    TranslateTransition translation;
    
    public Tutorial(BuilderView v) {
        view = v;
        g = new HBox();
        g.getStyleClass().add(CSS_CLASS_ANIM_HBOX);
        arrow = new ImageView();
        //g.getChildren().add(arrow);
        view.getBorderPane().setCenter(g);
    }
    
    public void run() {
        arrow.setImage(new Image("file:" + PATH_ICONS + "Previous.png"));
        g.getChildren().add(arrow);
        /*Rectangle rect = new Rectangle();
        rect.setWidth(100);
        rect.setHeight(50);
        rect.setX(50);
        rect.setFill(Color.RED);
        g.getChildren().add(rect);*/
        /*FadeTransition ft = new FadeTransition(Duration.millis(1500), arrow);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(2);*/
        arrow.setRotate(90);
        translation = new TranslateTransition(Duration.millis(1500), arrow);
        double fromX = view.getFileToolbar().getWidth() + view.getLayoutB().getLayoutX() + view.getLayoutB().getWidth()/4;
        translation.setFromX(fromX);
        translation.setToX(fromX);
        translation.setFromY(view.getFileToolbar().getHeight() + 20);
        translation.setToY(view.getFileToolbar().getHeight() - 30);
        translation.setCycleCount(Timeline.INDEFINITE);
        translation.setAutoReverse(true);
        translation.play();
        /*ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(ft, tt);
        pt.setCycleCount(2);
        pt.play();*/
    }
    
    public void pointToStyleController() {
    }
    
    public void pointToBannerImage() {
        
    }
}
