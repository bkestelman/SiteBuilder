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
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import desinfeuilles.template.LayoutTemplate;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;

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
    
    ArrayList<ImageView> imgs;
    int selectedTemplate;
    
    public StyleController(SiteBuilder sb) {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
        siteBuilder = sb;
    }
    
    public void setView(BuilderView v) {
        view = v;
    }
    
    public void openLayoutChooser() {
        ArrayList<LayoutTemplate> layouts = siteBuilder.getLayouts();
        ChoiceDialog<LayoutTemplate> chooser = new ChoiceDialog<LayoutTemplate>(layouts.get(0), layouts);
        chooser.setTitle("Choose a Layout");
        Optional<LayoutTemplate> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            view.setLayout(selection.get());
        }
    }
    
    public void generateTemplateOptions() {
        imgs = new ArrayList<ImageView>();
        for(int i = 1; i <= TEMPLATES; i++) {
            ImageView im = new ImageView(new Image("file:" + PATH_TEMPLATES + "template" + i + ".png"));
            imgs.add(im);
            main.getChildren().add(im);
        }
    }
    
    public int getSelectedTemplate() {
        return selectedTemplate;
    }
    
    public HBox getMain() {
        return main;
    }
    
    public float getHeight() {
        return HEIGHT;
    }
}
