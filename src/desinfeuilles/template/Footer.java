/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_AQUA_FOOTER;
import static desinfeuilles.StartupConstants.CSS_CLASS_FOOTER_TEXT;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author bkestelman
 */
public class Footer extends HBox {
    Label footerLabel; 
    public Footer(String footerText) {
        footerLabel = new Label(footerText); 
        getChildren().add(footerLabel);
        footerLabel.getStyleClass().add(CSS_CLASS_FOOTER_TEXT);
        getStyleClass().add(CSS_CLASS_AQUA_FOOTER);
        setMinHeight(50);
    }
}
