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
import static desinfeuilles.StartupConstants.CSS_CLASS_ROOT;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import static desinfeuilles.StartupConstants.PATH_ICONS;
import static desinfeuilles.StartupConstants.TUTORIAL_FONT;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import desinfeuilles.template.LayoutTemplate;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
    
    LayoutTemplate layout;
    
    Button newB, openB, saveB, exportB, exitB;
    
    Button layoutB, addPageB;
    
    TilePane styleToolbar;
    TilePane fileToolbar;
    HBox toolbars;

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
        root.getStyleClass().add(CSS_CLASS_ROOT);
        toolbars = new HBox();
        root.setTop(toolbars);
        
        //fileToolbar = new ToolBar();
        //fileToolbar.setPadding(new Insets(10));
        //styleToolbar = new ToolBar();
        //styleToolbar.setPadding(new Insets(10));
        
        //toolbars.setMaxWidth(Double.MAX_VALUE);
        
        initFileToolbar();
        initStyleToolbar();
        
        toolbars.getChildren().add(fileToolbar);
        toolbars.getChildren().add(styleToolbar);
        
        scene = new Scene(root);
        
        primaryStage.setTitle("DesinFeuilles SiteBuilder");
        primaryStage.setMaximized(true);
        scene.getStylesheets().addAll(CSS_SHEET, TUTORIAL_FONT);
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
        layoutB.setOnAction(e -> {
           styleController.openLayoutChooser(); 
        });
    }
    
    public void initFileToolbar() {
        fileToolbar = new TilePane();
        fileToolbar.setHgap(10);
        //fileToolbar.setAlignment(Pos.CENTER);
        newB = initButton("New.png", "New", CSS_CLASS_FILE_TOOLBAR_BUTTON_FIRST, false);
        openB = initButton("Load.png", "Open", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        saveB = initButton("Save.png", "Save", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exportB = initButton("Export.png", "Export", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exitB = initButton("Exit.png", "Exit", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        fileToolbar.getChildren().addAll(newB, openB, saveB, exportB, exitB);
        fileToolbar.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);
        fileToolbar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(fileToolbar, Priority.ALWAYS);
        //HBox.setVgrow(fileToolbar, Priority.ALWAYS);
    }
    
    public void initStyleToolbar() {
        styleToolbar = new TilePane();
        styleToolbar.setHgap(10);
        layoutB = initButton("Template.png", "Choose Layout", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        addPageB = initButton("Add.png", "Add Page", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        styleToolbar.getChildren().addAll(layoutB, addPageB);
        styleToolbar.getStyleClass().add(CSS_CLASS_STYLE_TOOLBAR);
        styleToolbar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(styleToolbar, Priority.ALWAYS);
    }
    
    public Button initButton(String iconFileName, 
            String tooltip,
            String cssClass,
            boolean disabled) {
        Button b = new Button();
        Image bImage = new Image("file:" + PATH_ICONS + iconFileName);
        ImageView bImageView = new ImageView(bImage);
        bImageView.setFitHeight(18);
        bImageView.setPreserveRatio(true);
        b.setGraphic(bImageView);
        b.setTooltip(new Tooltip(tooltip));
        b.getStyleClass().add(cssClass);
        b.setDisable(disabled);
        b.setMaxWidth(Double.MAX_VALUE);
        b.setMaxHeight(Double.MAX_VALUE);
        //b.resize(24, 24);
        return b;
    }
    
    public void setLayout(LayoutTemplate l) {
        layout = l;
        root.setCenter(layout.getMainPane());
        initLayout();
    }
    
    public void initLayout() {
        layout.getNavBar().addPage("Home", "home.html");
    }
    
    public BorderPane getBorderPane() {
        return root;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public TilePane getStyleToolbar() {
        return styleToolbar;
    }
    
    public TilePane getFileToolbar() {
        return fileToolbar;
    }
    
    public StyleController getStyleController() {
        return styleController;
    }
    
    public Button getLayoutB() {
        return layoutB;
    }
}
