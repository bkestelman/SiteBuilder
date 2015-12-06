/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.LayoutTemplate;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 *
 * @author Benito
 */
public class AddPageDialog extends CustomDialog {
    LayoutTemplate layout;
    TextField name;
    
    public AddPageDialog(LayoutTemplate layout) {
        super();
        this.layout = layout;
        setTitle("Add Page");
        HBox nameSet = new HBox();
        getIcons().add(new Image("file:" + PATH_ICONS + "AddPage.png"));
        Label l = new Label("Page Name: ");
        name = new TextField();
        nameSet.getChildren().addAll(l,  name);
        addNode(nameSet);
    } 
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            layout.getNavBar().addPage(name.getText(), name.getText().replaceAll("\\s", "") + ".html");
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
