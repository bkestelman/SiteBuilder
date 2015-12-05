/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import desinfeuilles.template.Header;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Benito
 */
public class EditHeaderDialog extends CustomDialog {
    
    TextField t;
    Header h;
    
    public EditHeaderDialog(Header h) {
        super();
        this.h = h;
        Label l = new Label("Edit some text here:");
        t = new TextField();
        t.setText(h.getText());
        addNode(l);
        addNode(t);
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            h.setText(t.getText());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
