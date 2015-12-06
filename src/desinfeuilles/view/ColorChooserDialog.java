/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.LayoutComponent;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;

/**
 *
 * @author Benito
 */
public class ColorChooserDialog extends CustomDialog {
    String colorChoice; 
    LayoutComponent selected;
    ColorPicker palette;
    
    public ColorChooserDialog(LayoutComponent selected) {
        super();
        this.selected = selected;
        palette = new ColorPicker();
        addNode(palette);
        prepareToShow();
        setTitle("Color Picker");
        getIcons().add(new Image("file:" + PATH_ICONS + "Paint.png"));
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            selected.getComponent().setStyle("-fx-font-color: '" + palette.getValue() + "';");
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
