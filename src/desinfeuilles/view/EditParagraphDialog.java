/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.LayoutTemplate;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 *
 * @author Benito
 */
public class EditParagraphDialog extends CustomDialog {
    LayoutTemplate layout;
    TextArea pText;
    Button hyperlink;
    
    public EditParagraphDialog(LayoutTemplate layout) {
        this.layout = layout;
        pText = new TextArea();
        pText.setPrefColumnCount(25);
        pText.setPrefRowCount(30);
        addNode(pText);
        hyperlink = new Button("Make selected text hyperlink");
        addNode(hyperlink);
        setTitle("Edit Paragraph");
        getIcons().add(new Image("file:" + PATH_ICONS + "Edit.png"));
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            layout.addParagraph(pText.getText());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
        hyperlink.setOnAction(e -> {
            CustomDialog linkD = new CustomDialog();
            Label sel = new Label("Selected text: " + pText.getSelectedText());
            HBox urlH = new HBox();
            Label enterUrl = new Label("URL: ");
            TextField url = new TextField();
            urlH.getChildren().addAll(enterUrl, url);
            linkD.addNode(sel);
            linkD.addNode(urlH);
            linkD.prepareToShow();
            linkD.show();
        });
    }
}
