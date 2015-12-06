/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.ImageComponent;
import desinfeuilles.template.LayoutComponent;
import desinfeuilles.template.LayoutTemplate;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 *
 * @author Benito
 */
public class ImageDialog extends CustomDialog {
    ImageComponent imageComponent;
    LayoutTemplate layout;
    Button browse;
    File imgFile;
    TextField wi, he, cap;
    
    public ImageDialog() {
        super();
        getIcons().add(new Image("file:" + PATH_ICONS + "Background.png"));
        GridPane g = new GridPane();
        g.setHgap(10);
        g.setVgap(10);
        browse = new Button("Browse Image");
        GridPane.setConstraints(browse, 0, 0);
        Label l = new Label("Caption: ");
        cap = new TextField();
        GridPane.setConstraints(cap, 1, 1);
        GridPane.setConstraints(l, 0, 1);
        Label w = new Label("Width: ");
        wi = new TextField();
        wi.setMaxWidth(50);
        Label h = new Label("Height: ");
        he = new TextField();
        he.setMaxWidth(50);
        GridPane.setConstraints(w, 0, 2);
        GridPane.setConstraints(wi, 1, 2);
        GridPane.setConstraints(h, 2, 2);
        GridPane.setConstraints(he, 3, 2);
        Label fl = new Label("Float: ");
        ToggleGroup group = new ToggleGroup();
        RadioButton left = new RadioButton("Left");
        left.setToggleGroup(group);
        left.setSelected(true);
        RadioButton right = new RadioButton("Right");
        right.setToggleGroup(group);
        RadioButton ne = new RadioButton("Neither");
        ne.setToggleGroup(group);
        GridPane.setConstraints(fl, 0, 3);
        GridPane.setConstraints(left, 2, 3);
        GridPane.setConstraints(right, 3, 3);
        GridPane.setConstraints(ne, 1, 3);
        g.getChildren().addAll(browse, l, cap, w, wi, h, he, fl, left, right, ne);
        addNode(g);
    }
    
    public ImageDialog(ImageComponent l) {
        this();
        imageComponent = l;
    }
    
    public ImageDialog(LayoutTemplate layout) {
        this();
        this.layout = layout;
    }
    
    public void initEventHandlers() {
        browse.setOnAction(e -> {
            FileChooser bc = new FileChooser();
            bc.setTitle("Choose Image");
            imgFile = bc.showOpenDialog(this);
        });
        ok.setOnAction(e -> {
            response = OK;
            if(layout != null) {
                ImageView iv = new ImageView(new Image(imgFile.toURI().toString()));
                imageComponent = layout.addImage(iv, cap.getText());
            }
            else {
                if(imgFile != null) imageComponent.setImage(imgFile.toURI().toString());
            }
            imageComponent.setWH(wi.getText(), he.getText());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
