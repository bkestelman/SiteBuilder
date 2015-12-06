/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.ImageComponent;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.VideoComponent;
import static desinfeuilles.view.CustomDialog.CANCEL;
import static desinfeuilles.view.CustomDialog.OK;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 *
 * @author Benito
 */
public class VideoDialog extends CustomDialog {
    VideoComponent videoComponent;
    LayoutTemplate layout;
    Button browse;
    File vidFile;
    TextField wi, he, cap;
    GridPane g;
    
    public VideoDialog() {
        super();
        getIcons().add(new Image("file:" + PATH_ICONS + "videoplay2.png"));
        g = new GridPane();
        g.setHgap(10);
        g.setVgap(10);
        browse = new Button("Browse Video");
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
    
    public VideoDialog(VideoComponent l) {
        this();
        videoComponent = l;
    }
    
    public VideoDialog(LayoutTemplate layout) {
        this();
        this.layout = layout;
    }
    
    public void initEventHandlers() {
        browse.setOnAction(e -> {
            FileChooser bc = new FileChooser();
            bc.setTitle("Choose Video");
            vidFile = bc.showOpenDialog(this);
            Label saved = new Label("Video Saved!");
            GridPane.setConstraints(saved, 1, 0);
            g.getChildren().add(saved);
        });
        ok.setOnAction(e -> {
            response = OK;
            if(layout != null) {
                videoComponent = layout.addVideo(vidFile, cap.getText());
            }
            else {
                if(vidFile != null) videoComponent.setVideo(vidFile.toURI().toString());
                videoComponent.setCaption(cap.getText());
            }
            videoComponent.setWH(wi.getText(), he.getText());
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
}
