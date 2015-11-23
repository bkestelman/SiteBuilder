/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.CSS_CLASS_DIALOG;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Benito
 */
public class CustomDialog extends Stage {
    Scene scene;
    VBox root;
    Button ok, cancel;
    HBox confirm;
    boolean response;
    
    public static final boolean OK = true;
    public static final boolean CANCEL = false;
    
    public CustomDialog() {
        super();
        root = new VBox();
        scene = new Scene(root);
        setScene(scene);
        confirm = new HBox();
        ok = new Button("Ok");
        cancel = new Button("Cancel");
        confirm.getChildren().addAll(ok, cancel);
        confirm.setAlignment(Pos.CENTER_RIGHT);
        initEventHandlers();
        scene.getStylesheets().add(CSS_SHEET);
        root.getStyleClass().add(CSS_CLASS_DIALOG);
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
    
    public void addNode(Node n) {
        root.getChildren().add(n);
    }
    
    public void prepareToShow() {
        root.getChildren().add(confirm);
    }
}
