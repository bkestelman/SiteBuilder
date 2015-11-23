/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import static desinfeuilles.StartupConstants.PATH_IMAGES;
import static desinfeuilles.StartupConstants.PATH_TEMPLATES;
import desinfeuilles.animation.Tutorial;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import desinfeuilles.template.CenterLayout;
import desinfeuilles.view.BuilderView;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import desinfeuilles.template.LeftNavLayout;
import java.util.Iterator;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.StyleTemplate;

/**
 *
 * @author Benito
 */
public class SiteBuilder extends Application {
    
    public BuilderView view;
    public FileController fileController;
    public StyleController styleController;
    public Tutorial tutorial;
    public ArrayList<LayoutTemplate> layouts;
    public LayoutTemplate l1, l2;
    public ArrayList<StyleTemplate> styles;
    
    @Override
    public void start(Stage stage) {
        layouts = new ArrayList<>();
        l1 = new LeftNavLayout();
        l2 = new CenterLayout();
        layouts.add(l1);
        layouts.add(l2);
        styles = new ArrayList<>();
        styles.add(new StyleTemplate("Aqua"));
        initStyle(styles.get(0), "water.jpg");
        fileController = new FileController(this);
        styleController = new StyleController(this);
        view = new BuilderView(this, fileController, styleController);
        Alert useTutorial = new Alert(AlertType.CONFIRMATION, "Would you like to go through the tutorial?");
        useTutorial.setHeaderText("Tutorial");
        view.show();
        Optional<ButtonType> result = useTutorial.showAndWait();
        if(result.get() == ButtonType.OK) {
            tutorial = new Tutorial(view);
            tutorial.run();
        }
        //view.show();
    }
    
    public void initStyle(StyleTemplate style, String mainImageName) {
        style.setMainImage(PATH_TEMPLATES + mainImageName);
    }
    
    public ArrayList<StyleTemplate> getStyles() {
        return styles;
    }
    
    public ArrayList<LayoutTemplate> getLayouts() {
        return layouts;
    }
    
    public Tutorial getTutorial() {
        return tutorial;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
