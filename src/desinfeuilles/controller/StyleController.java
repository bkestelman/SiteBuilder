/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.CSS_CLASS_DIALOG;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_CONTROLLER;
import static desinfeuilles.StartupConstants.PATH_TEMPLATES;
import desinfeuilles.view.BuilderView;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.StyleTemplate;
import desinfeuilles.view.CustomDialog;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Benito
 */
public class StyleController {
    public static final float HEIGHT = 150;
    public static final int TEMPLATES = 1;
    
    BuilderView view;
    HBox main;
    SiteBuilder siteBuilder;
    
    ArrayList<ImageView> imgs;
    int selectedTemplate;
    
    public StyleController(SiteBuilder sb) {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
        siteBuilder = sb;
    }
    
    public void setView(BuilderView v) {
        view = v;
    }
    
    public void openStyleChooser() {
        ArrayList<StyleTemplate> styles = siteBuilder.getStyles();
        ChoiceDialog<StyleTemplate> chooser = new ChoiceDialog<StyleTemplate>(styles.get(0), styles);
        chooser.getDialogPane().getStyleClass().add(CSS_CLASS_DIALOG);
        chooser.setTitle("Choose a Style Template");
        Optional<StyleTemplate> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            view.setStyleTemplate(selection.get());
        }
        if(siteBuilder.getTutorial() != null) {
            siteBuilder.getTutorial().stopAnimations();
            siteBuilder.getTutorial().pointToStyleToolbar(view.getLayoutB(), "You are genuine artiste. Now choose a layout.");
        }
    }
    
    public void openLayoutChooser() {
        ArrayList<LayoutTemplate> layouts = siteBuilder.getLayouts();
        ChoiceDialog<LayoutTemplate> chooser = new ChoiceDialog<LayoutTemplate>(layouts.get(0), layouts);
        chooser.setTitle("Choose a Layout");
        Optional<LayoutTemplate> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            view.setLayout(selection.get());
        }
        if(siteBuilder.getTutorial() != null) {
            siteBuilder.getTutorial().stopAnimations();
            siteBuilder.getTutorial().pointToBannerHeader("Click the banner header to select it.");
        }
    }
    
    public void generateTemplateOptions() {
        imgs = new ArrayList<ImageView>();
        for(int i = 1; i <= TEMPLATES; i++) {
            ImageView im = new ImageView(new Image("file:" + PATH_TEMPLATES + "template" + i + ".png"));
            imgs.add(im);
            main.getChildren().add(im);
        }
    }
    
    public int getSelectedTemplate() {
        return selectedTemplate;
    }
    
    public HBox getMain() {
        return main;
    }
    
    public float getHeight() {
        return HEIGHT;
    }

    public void openTextEditor() {
        //dialog with text area
    }

    public void openBackgroundImageChooser() {
        //dialog with browse button and options (repeat, 100%)
    }

    public void openColorChooser() {
        Stage colorStage = new Stage();
        VBox root = new VBox();
        ColorPicker palette = new ColorPicker();
        root.getChildren().add(palette);
        HBox confirm = new HBox();
        Button ok = new Button("Ok");
        Button cancel = new Button("Cancel");
        confirm.getChildren().addAll(ok, cancel);
        root.getChildren().add(confirm);
        confirm.setAlignment(Pos.CENTER);
        Scene s = new Scene(root);
        colorStage.setScene(s);
        colorStage.show();
        /*Alert colorDialog = new Alert(AlertType.CONFIRMATION);
        colorDialog.setHeaderText("Choose a color");
        colorDialog.setTitle("Color Picker");
        final ColorPicker palette = new ColorPicker();
        //palette.setPromptText("Color:");
        colorDialog.getDialogPane().getChildren().add(palette);
        palette.setLayoutY(100);
        palette.setMinWidth(100);
        palette.setMaxWidth(Double.MAX_VALUE);
        colorDialog.showAndWait();*/
    }

    public void openFontChooser() {
        //fonts in list, preview label in font
    }

    public void openAddContentDialog() {
        //content type selection (dropdown?)
        //text, list, image, video, slideshow -> open editor for selection
        ArrayList<String> contentTypes = new ArrayList<>();
        contentTypes.add("Paragraph");
        contentTypes.add("List");
        contentTypes.add("Image");
        contentTypes.add("Slide Show");
        contentTypes.add("Video");
        ChoiceDialog<String> chooser = new ChoiceDialog<>(contentTypes.get(0), contentTypes);
        chooser.setTitle("Add Content");
        Optional<String> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            String contentType = selection.get();
            switch(contentType) {
                case "Paragraph": 
                    openParagraphDialog();
                case "List": 
                    openListDialog();
                case "Image":
                    openImageDialog();
                case "Slide Show":
                    openSlideShowDialog();
                case "Video": 
                    openVideoDialog();
                default:
                    break;
            }
        }
    }

    public void openAddPageDialog() {
        //page name
        CustomDialog pageDialog = new CustomDialog();
        HBox nameSet = new HBox();
        Label l = new Label("Page Name: ");
        TextField name = new TextField();
        nameSet.getChildren().addAll(l,  name);
        pageDialog.addNode(nameSet);
        pageDialog.prepareToShow();
        pageDialog.show();
    }

    private void openParagraphDialog() {
        CustomDialog pDialog = new CustomDialog();
        TextArea pText = new TextArea();
        pText.setPrefColumnCount(25);
        pText.setPrefRowCount(30);
        pDialog.addNode(pText);
        pDialog.setTitle("Edit Paragraph");
        pDialog.prepareToShow();
        pDialog.show();
    }

    private void openListDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void openImageDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void openSlideShowDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void openVideoDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeComponent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void openRemoveDialog() {
        Alert removeAlert = new Alert(AlertType.CONFIRMATION);
        removeAlert.setTitle("Remove Content");
        removeAlert.setHeaderText("Really Remove Content?");
        removeAlert.setContentText("This cannot be undone");
        Optional<ButtonType> response = removeAlert.showAndWait();
    }
}
