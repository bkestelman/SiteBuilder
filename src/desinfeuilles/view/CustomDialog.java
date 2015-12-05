/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.CSS_CLASS_CONFIRM_BUTTON;
import static desinfeuilles.StartupConstants.CSS_CLASS_DIALOG;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import java.util.ArrayList;
import javafx.geometry.Insets;
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
    String simpleResponse;
    ArrayList<String> stringResponses;
    
    public static final boolean OK = true;
    public static final boolean CANCEL = false;
    
    public CustomDialog() {
        super();
        root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        scene = new Scene(root);
        setScene(scene);
        confirm = new HBox(10);
        confirm.setPadding(new Insets(10, 0, 0, 10));
        ok = new Button("Ok");
        cancel = new Button("Cancel");
        confirm.getChildren().addAll(ok, cancel);
        confirm.setAlignment(Pos.CENTER_RIGHT);
        initEventHandlers();
        scene.getStylesheets().add(CSS_SHEET);
        root.getStyleClass().add(CSS_CLASS_DIALOG);
    }
    
    public CustomDialog(boolean minimalConstructor) { //just call this with any boolean value for a minimal constructor :P 
        super();
        root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        scene = new Scene(root);
        setScene(scene);
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
    
    public void sizeNice() {
        setWidth(500);
    }
    
    public void addHeight(double h) {
        setHeight(getHeight() + h);
    }
    
    public void addConfirm() {
        addNode(confirm);
    }
    
    public VBox getRoot() {
        return root;
    }
    
    public void addNode(Node n) {
        root.getChildren().add(n);
    }
    
    public void prepareToShow() {
        root.getChildren().add(confirm);
    }
}
