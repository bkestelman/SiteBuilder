/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.Paragraph;
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
    Paragraph p;
    Button hyperlink;
    
    public EditParagraphDialog(Paragraph p) {
        super();
        this.p = p;
        pText = new TextArea();
        pText.setPrefColumnCount(25);
        pText.setPrefRowCount(30);
        pText.setText(p.getText());
        addNode(pText);
        hyperlink = new Button("Make selected text hyperlink");
        addNode(hyperlink);
        setTitle("Edit Paragraph");
        getIcons().add(new Image("file:" + PATH_ICONS + "Edit.png"));
    }
    
    public EditParagraphDialog(LayoutTemplate layout) {
        super();
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
            if(layout != null) layout.addParagraph(pText.getText());
            else p.setText(pText.getText());
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
