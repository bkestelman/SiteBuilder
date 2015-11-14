/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import static desinfeuilles.StartupConstants.PATH_ICONS;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Benito
 */
public class BuilderView {
    Stage primaryStage;
    
    BorderPane root;
    
    ToolBar fileToolbar, styleToolbar;
    
    Button newB, openB, saveB, exitB;
    
    public BuilderView() {
        initView();
    }
    
    public void initView() {
        primaryStage = new Stage();
        root = new BorderPane();
        
        initFileToolbar();
        initStyleToolbar();
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("DesinFeuilles SiteBuilder");
        primaryStage.setMaximized(true);
        scene.getStylesheets().add(CSS_SHEET);
        primaryStage.setScene(scene);
    }
    
    public void show() {
        primaryStage.show();
    }
    
    public void initFileToolbar() {
        newB = initButton("New.png", "New", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        openB = initButton("Load.png", "Open", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        saveB = initButton("Save.png", "Save", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exitB = initButton("Exit.png", "Exit", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        fileToolbar = new ToolBar(newB, openB, saveB, exitB);
        fileToolbar.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);
        root.setTop(fileToolbar);
    }
    
    public void initStyleToolbar() {
        styleToolbar = new ToolBar();
        root.setLeft(styleToolbar);
    }
    
    public Button initButton(String iconFileName, 
            String tooltip,
            String cssClass,
            boolean disabled) {
        Button b = new Button();
        Image bImage = new Image("file:" + PATH_ICONS + iconFileName);
        b.setGraphic(new ImageView(bImage));
        b.setTooltip(new Tooltip("tooltip"));
        b.getStyleClass().add(cssClass);
        b.setDisable(disabled);
        return b;
    }
}
