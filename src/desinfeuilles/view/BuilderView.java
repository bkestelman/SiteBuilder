/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

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
        primaryStage.setScene(scene);
    }
    
    public void show() {
        primaryStage.show();
    }
    
    public void initFileToolbar() {
        newB = initButton("New.png", "New", false);
        openB = initButton("Load.png", "Open", false);
        saveB = initButton("Save.png", "Save", false);
        exitB = initButton("Exit.png", "Exit", false);
        fileToolbar = new ToolBar(newB, openB, saveB, exitB);
        root.setTop(fileToolbar);
    }
    
    public void initStyleToolbar() {
        styleToolbar = new ToolBar();
        root.setLeft(styleToolbar);
    }
    
    public Button initButton(String iconFileName, 
            String tooltip,
            boolean disabled) {
        Button b = new Button();
        Image bImage = new Image("file:" + PATH_ICONS + iconFileName);
        b.setGraphic(new ImageView(bImage));
        b.setTooltip(new Tooltip("tooltip"));
        b.setDisable(disabled);
        return b;
    }
}
