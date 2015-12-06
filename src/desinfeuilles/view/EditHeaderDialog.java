/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.Header;
import desinfeuilles.template.LayoutComponent;
import desinfeuilles.template.LayoutTemplate;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 *
 * @author Benito
 */
public class EditHeaderDialog extends CustomDialog {
    
    TextField t;
    LayoutComponent h;
    LayoutTemplate layout;
    
    public EditHeaderDialog(LayoutComponent h) {
        super();
        this.h = h;
        Label l = new Label("Edit some text here:");
        t = new TextField();
        t.setText(h.getText());
        addNode(l);
        addNode(t);
        getIcons().add(new Image("file:" + PATH_ICONS + "Edit.png"));
    }
    
    public EditHeaderDialog(LayoutTemplate layout) {
        super();
        this.layout = layout;
        Label l = new Label("Edit some text here:");
        t = new TextField();
        addNode(l);
        addNode(t);
        getIcons().add(new Image("file:" + PATH_ICONS + "Edit.png"));
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            if(layout == null) 
                h.setText(t.getText());
            else
                layout.addHeader(t.getText());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
