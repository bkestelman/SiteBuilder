/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import desinfeuilles.animation.Tutorial;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import desinfeuilles.view.BuilderView;
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

/**
 *
 * @author Benito
 */
public class SiteBuilder extends Application {
    
    public BuilderView view;
    public FileController fileController;
    public StyleController styleController;
    public Tutorial tutorial;
    
    @Override
    public void start(Stage stage) {
        fileController = new FileController(this);
        styleController = new StyleController(this);
        view = new BuilderView(fileController, styleController);
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
