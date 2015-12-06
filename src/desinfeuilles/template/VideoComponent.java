/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_IMG_COMPONENT;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Benito
 */
public class VideoComponent extends LayoutComponent {
    Label caption;
    File media;
    String cap, mediaSource;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    
    public VideoComponent(File media, String cap, LayoutTemplate template) {
        super();
        this.cap = cap;
        this.media = media;
        mediaSource = media.toURI().toString();
        this.caption = new Label(cap);
        component = new VBox();
        mediaPlayer = new MediaPlayer(new Media(mediaSource));
        mediaView = new MediaView(mediaPlayer);
        ((VBox)component).getChildren().addAll(mediaView, caption);
        initComponent(template);
        type = "v";
    }
    
    public void setVideo(String path) {
        ((ImageView)component).setImage(new Image(path));
    }
    
    public void setCaption(String cap) {
        caption.setText(cap);
    }
    
    public void setWH(String w, String h) {
        if (w != null && h != null) {
            mediaView.setFitWidth(Integer.parseInt(w));
            mediaView.setFitHeight(Integer.parseInt(h));
        } else if (w == null && h != null) {
            mediaView.setFitHeight(Integer.parseInt(h));
            mediaView.setPreserveRatio(true);
        } else if (h == null && w != null) {
            mediaView.setFitWidth(Integer.parseInt(w));
            mediaView.setPreserveRatio(true);
        }
    }
}
