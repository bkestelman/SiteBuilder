/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.style.MyFont;
import desinfeuilles.template.LayoutComponent;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;

/**
 *
 * @author Benito
 */
public class FontChooserDialog extends CustomDialog {
    LayoutComponent layoutComponent;
    ComboBox<MyFont> cb;
    
    public FontChooserDialog(LayoutComponent layoutComponent, ArrayList<MyFont> fonts) {
        super();
        this.layoutComponent = layoutComponent;
        setTitle("Choose Font");
        getIcons().add(new Image("file:" + PATH_ICONS + "Font.png"));
        cb = new ComboBox<>();
        cb.getItems().add(new MyFont("System (Default)",""));
        for(MyFont f : fonts) {
            cb.getItems().add(f);
        }
        addNode(cb);
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            layoutComponent.getComponent().getStyleClass().remove(layoutComponent.getFontStyleClass());
            layoutComponent.getComponent().getStyleClass().add(cb.getValue().getCssClass());
            layoutComponent.setFontStyleClass(cb.getValue().getCssClass());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
