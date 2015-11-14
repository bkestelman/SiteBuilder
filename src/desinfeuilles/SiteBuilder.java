/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Benito
 */
public class SiteBuilder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        Button newB = new Button("New");
        Button openB = new Button("Open");
        Button saveB = new Button("Save");
        Button saveAsB = new Button("Save As");
        Button exitB = new Button("Exit");
        ToolBar fileToolbar = new ToolBar(newB, openB, saveB, saveAsB, exitB);
        root.setTop(fileToolbar);
        
        ToolBar styleToolbar = new ToolBar();
        root.setLeft(styleToolbar);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("DesinFeuilles SiteBuilder");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
