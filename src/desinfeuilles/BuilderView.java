/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
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
    
    Button newB, openB, saveB, saveAsB, exitB;
    
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
        newB = new Button("New");
        openB = new Button("Open");
        saveB = new Button("Save");
        saveAsB = new Button("Save As");
        exitB = new Button("Exit");
        fileToolbar = new ToolBar(newB, openB, saveB, saveAsB, exitB);
        root.setTop(fileToolbar);
    }
    
    public void initStyleToolbar() {
        styleToolbar = new ToolBar();
        root.setLeft(styleToolbar);
    }
}
