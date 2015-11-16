/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON_FIRST;
import static desinfeuilles.StartupConstants.CSS_CLASS_HBANNER;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Benito
 */
public class BuilderView {
    SiteBuilder siteBuilder;
    FileController fileController;
    StyleController styleController;
    
    Stage primaryStage;
    Scene scene;
    BorderPane root;
    
    ToolBar fileToolbar;
    Button newB, openB, saveB, exitB;
    
    ToolBar styleToolbar;
    Button templateB;
    
    //site divs
    VBox vmain, vnav, vbanner, vcontent;
    HBox hmain, hnav, hbanner, hcontent;
    TilePane nav;
    
    public BuilderView(SiteBuilder sb, FileController f, StyleController s) {
        siteBuilder = sb;
        fileController = f;
        styleController = s;
        s.setView(this);
        initView();
    }
    
    public void initView() {
        primaryStage = new Stage();
        root = new BorderPane();
        
        initFileToolbar();
        initStyleToolbar();
        
        scene = new Scene(root);
        
        primaryStage.setTitle("DesinFeuilles SiteBuilder");
        primaryStage.setMaximized(true);
        scene.getStylesheets().add(CSS_SHEET);
        primaryStage.setScene(scene);
        
        initEventHandlers();
    }
    
    public void show() {
        primaryStage.show();
    }
    
    public void initEventHandlers() {
        exitB.setOnAction(e -> {
            fileController.handleExitRequest();
        });
        templateB.setOnAction(e -> {
           styleController.openTemplateChooser(); 
        });
    }
    
    public void initFileToolbar() {
        newB = initButton("New.png", "New", CSS_CLASS_FILE_TOOLBAR_BUTTON_FIRST, false);
        openB = initButton("Load.png", "Open", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        saveB = initButton("Save.png", "Save", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exitB = initButton("Exit.png", "Exit", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        fileToolbar = new ToolBar(newB, openB, saveB, exitB);
        fileToolbar.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);
        root.setTop(fileToolbar);
    }
    
    public void initStyleToolbar() {
        templateB = initButton("Template.png", "Template", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        styleToolbar = new ToolBar(templateB);
        styleToolbar.setOrientation(Orientation.VERTICAL);
        styleToolbar.getStyleClass().add(CSS_CLASS_STYLE_TOOLBAR);
        root.setLeft(styleToolbar);
    }
    
    public Button initButton(String iconFileName, 
            String tooltip,
            String cssClass,
            boolean disabled) {
        Button b = new Button();
        Image bImage = new Image("file:" + PATH_ICONS + iconFileName);
        b.setGraphic(new ImageView(bImage));
        b.setTooltip(new Tooltip(tooltip));
        b.getStyleClass().add(cssClass);
        b.setDisable(disabled);
        return b;
    }
    
    public void setTemplate() {
        /*if(styleController.getSelectedTemplate() == 1) {
            vmain = new VBox();
            root.setCenter(vmain);
            hbanner = new HBox();
            hbanner.getStyleClass().add(CSS_CLASS_HBANNER);
            Label bannerLabel = new Label("This is some sweet banner dam");
            hbanner.getChildren().add(bannerLabel);
            nav = new TilePane();
            vcontent = new VBox();
            vmain.getChildren().addAll(hbanner, nav, vcontent);
        }*/
    }
    
    public BorderPane getBorderPane() {
        return root;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public ToolBar getStyleToolbar() {
        return styleToolbar;
    }
    
    public StyleController getStyleController() {
        return styleController;
    }
}
