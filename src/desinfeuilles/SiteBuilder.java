/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import desinfeuilles.animation.Tutorial;
import desinfeuilles.controller.FileController;
import desinfeuilles.view.BuilderView;
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
    
    public BuilderView view;
    public FileController fileController;
    public Tutorial tutorial;
    
    @Override
    public void start(Stage xStage) {
        fileController = new FileController();
        view = new BuilderView(fileController);
        tutorial = new Tutorial(view);
        tutorial.run();
        view.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
