/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.animation;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import static desinfeuilles.StartupConstants.CSS_CLASS_ANIM_HBOX;
import static desinfeuilles.StartupConstants.CSS_CLASS_TUTORIAL_TIP;
import desinfeuilles.view.BuilderView;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    Label tip;
    Pane animationPane;
    
    TranslateTransition translation;
    TranslateTransition tipPos;
    
    public Tutorial(BuilderView v) {
        view = v;
        //g = new HBox();
        //g.getStyleClass().add(CSS_CLASS_ANIM_HBOX);
        animationPane = (Pane) view.getBorderPane().getCenter();
        arrow = new ImageView();
        tip = new Label();
        tip.getStyleClass().add(CSS_CLASS_TUTORIAL_TIP);
        //g.getChildren().add(arrow);
        //view.getBorderPane().setCenter(g);
    }
    
    public void run() {
        arrow.setImage(new Image("file:" + PATH_ICONS + "Previous.png"));
        animationPane.getChildren().addAll(arrow, tip);
        pointToStyleToolbar(view.getStyleTemplateB(), "Click here to choose a style template");
    }
    
    public void pointToStyleToolbar(Button b, String tipMsg) {
        tip.setText(tipMsg);
        arrow.setRotate(90);
        translation = new TranslateTransition(Duration.millis(1500), arrow);
        double fromX = view.getFileToolbar().getWidth() + b.getLayoutX() + b.getWidth()/4;
        translation.setFromX(fromX - arrow.getFitWidth()/2);
        translation.setFromY(view.getFileToolbar().getHeight() + 20);
        translation.setToY(view.getFileToolbar().getHeight() - 15);
        translation.setCycleCount(Timeline.INDEFINITE);
        translation.setAutoReverse(true);
        translation.play();
        tipPos = new TranslateTransition(Duration.millis(1000), tip);
        tip.impl_processCSS(true);
        tipPos.setFromX(fromX - tip.prefWidth(-1)/2); //derp code lol
        tipPos.setCycleCount(Timeline.INDEFINITE);
        tipPos.play();
        /*ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(ft, tt);
        pt.setCycleCount(2);
        pt.play();*/
    }
    
    public void pointToBannerHeader(String msg) {
        animationPane = view.getLayout().getBanner();
        animationPane.getChildren().addAll(arrow, tip);
        tip.setText(msg);
        arrow.setRotate(0);
        double toX = view.getLayout().getBanner().getHeader().getLayoutX();
        translation.setFromX(toX + 30);
        translation.setToX(toX);
        translation.setFromY(0);
        translation.setToY(0);
        translation.play();
        tipPos.setFromX(toX + 30 + 20);
        tipPos.setFromY(0);
        tipPos.play();
    }
    
    public void stopAnimations() {
        translation.stop();
        tipPos.stop();
    }
    
    public void pointToStyleController() {
    }
    
    public void pointToBannerImage() {
        
    }
}
