/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import model.BuilderModel;
import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.CSS_CLASS_DIALOG;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_CONTROLLER;
import static desinfeuilles.StartupConstants.PATH_ICONS;
import static desinfeuilles.StartupConstants.PATH_SLIDESHOW_IMAGES;
import static desinfeuilles.StartupConstants.PATH_TEMPLATES;
import desinfeuilles.template.Header;
import desinfeuilles.template.ImageComponent;
import desinfeuilles.template.LayoutComponent;
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
import desinfeuilles.template.ListComponent;
import desinfeuilles.template.Paragraph;
import desinfeuilles.template.StyleTemplate;
import desinfeuilles.view.AddPageDialog;
import desinfeuilles.view.ColorChooserDialog;
import desinfeuilles.view.CustomDialog;
import desinfeuilles.view.EditHeaderDialog;
import desinfeuilles.view.EditListDialog;
import desinfeuilles.view.EditParagraphDialog;
import desinfeuilles.view.FontChooserDialog;
import desinfeuilles.view.ImageDialog;
import java.io.File;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
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
    BuilderModel model;
    
    ArrayList<ImageView> imgs;
    int selectedTemplate;
    
    private static int listElements = 0;
    
    ArrayList<CustomDialog> dialogs;
    
    public StyleController(SiteBuilder sb) {
        main = new HBox();
        main.getStyleClass().add(CSS_CLASS_STYLE_CONTROLLER);
        siteBuilder = sb;
        dialogs = new ArrayList<>();
        model = sb.getModel();
    }
    
    public void setView(BuilderView v) {
        view = v;
    }
    
    public void openStyleChooser() {
        ArrayList<StyleTemplate> styles = siteBuilder.getStyles();
        ChoiceDialog<StyleTemplate> chooser = new ChoiceDialog<StyleTemplate>(model.getStyle(), styles);
        chooser.getDialogPane().getStyleClass().add(CSS_CLASS_DIALOG);
        chooser.setTitle("Style Selector");
        chooser.setHeaderText("Choose a Style Template");
        Optional<StyleTemplate> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            view.setStyleTemplate(selection.get());
        }
        if(siteBuilder.getTutorial() != null) {
            siteBuilder.getTutorial().stopAnimations();
            siteBuilder.getTutorial().pointToStyleToolbar(view.getLayoutB(), "You are genuine artiste. Now choose a layout.");
        }
    }
    
    public void openLayoutChooser(String newPage) {
        siteBuilder.reloadLayoutSelection();
        ArrayList<LayoutTemplate> layouts = siteBuilder.getLayouts();
        ChoiceDialog<LayoutTemplate> chooser = new ChoiceDialog<LayoutTemplate>(layouts.get(0), layouts);
        chooser.setTitle("Layout Chooser");
        chooser.setHeaderText("Choose a Layout Template");
        Optional<LayoutTemplate> selection = chooser.showAndWait();
        if(selection.isPresent()) {
            view.setLayout(selection.get(), newPage);
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
        LayoutComponent selected = view.getLayout().getSelectedComponent();
        CustomDialog editD;
        if(selected.getType().equals("h")) {
            editD = new EditHeaderDialog((Header)selected);
            editD.setTitle("Edit Header");
        }
        else if(selected.getType().equals("p")) {
            editD = new EditParagraphDialog((Paragraph)selected);
        }
        else if(selected.getType().equals("l")) {
            editD = new EditListDialog((ListComponent)selected);
        }
        else editD = new CustomDialog();
        editD.prepareToShow();
        editD.sizeNice();
        editD.showAndWait();
    }

    public void openBackgroundImageChooser() {
        LayoutComponent selected = view.getLayout().getSelectedComponent();
        if(selected.getType() != null && selected.getType().equals("img")) {
            ImageDialog imageD = new ImageDialog((ImageComponent)selected);
            imageD.prepareToShow();
            imageD.showAndWait();
            return;
        }
        //dialog with browse button and options (repeat, 100%)
        FileChooser bc = new FileChooser();
        bc.setTitle("Choose Image");
        File imgFile = bc.showOpenDialog(view.getStage());
        String filePath = imgFile.toURI().toString();
        selected.getComponent().setStyle("-fx-background-image: url(" + filePath + ");");
    }

    public void openColorChooser() {
        ColorChooserDialog colorD = new ColorChooserDialog(view.getLayout().getSelectedComponent());
        colorD.sizeNice();
        colorD.show();
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
        LayoutComponent selected = view.getLayout().getSelectedComponent();
        FontChooserDialog fontD = new FontChooserDialog(selected, siteBuilder.getFonts());
        fontD.prepareToShow();
        fontD.sizeNice();
        fontD.showAndWait();
    }

    public void openAddContentDialog() {
        //content type selection (dropdown?)
        //text, list, image, video, slideshow -> open editor for selection
        ArrayList<String> contentTypes = new ArrayList<>();
        contentTypes.add("Header");
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
                case "Header":
                    openHeaderDialog();
                    break;
                case "Paragraph": 
                    openParagraphDialog();
                    break;
                case "List": 
                    openListDialog();
                    break;
                case "Image":
                    openAddImageDialog();
                    break;
                case "Slide Show":
                    openSlideShowDialog();
                    break;
                case "Video": 
                    openVideoDialog();
                    break;
                default:
                    break;
            }
        }
    }

    public void openAddPageDialog() {
        //page name
        AddPageDialog pageDialog = new AddPageDialog(view.getLayout());
        pageDialog.prepareToShow();
        pageDialog.sizeNice();
        pageDialog.showAndWait();
        String newPage = view.getLayout().getNavBar().getNavBarModel().getNewestPageName();
        openStyleChooser();
        openLayoutChooser(newPage);
    }
    
    private void openHeaderDialog() {
        EditHeaderDialog hDialog = new EditHeaderDialog(view.getLayout());
        hDialog.prepareToShow();
        hDialog.showAndWait();
    }

    private void openParagraphDialog() {
        EditParagraphDialog pDialog = new EditParagraphDialog(view.getLayout());
        pDialog.prepareToShow();
        pDialog.showAndWait();
    }

    private void openListDialog() {
        listElements = 1;
        
        EditListDialog lDialog = new EditListDialog(view.getLayout());
        lDialog.prepareToShow();
        lDialog.sizeNice();
        lDialog.setTitle("List Editor");
        lDialog.showAndWait();
    }

    private void openAddImageDialog() {
        ImageDialog imageDialog = new ImageDialog(view.getLayout());
        imageDialog.prepareToShow();
        imageDialog.showAndWait();
    }

    private void openSlideShowDialog() {
        listElements = 1; 
        
        CustomDialog ssDialog = new CustomDialog();
        ssDialog.getIcons().add(new Image("file:" + PATH_ICONS + "Slides.png"));
        
        HBox element1 = new HBox();
        Label l1 = new Label("Slide 1 Caption: ");
        TextField t1 = new TextField();
        Button b1 = new Button("Browse Image");
        ImageView im1 = new ImageView(new Image("file:" + PATH_SLIDESHOW_IMAGES + "DefaultStartSlide.png"));
        element1.getChildren().addAll(l1, t1, b1, im1);
        ssDialog.addNode(element1);
        
        Button add = new Button("Add Slide");
        ssDialog.addNode(add);
        
        ArrayList<HBox> elements = new ArrayList<>();
        elements.add(element1);
        
        add.setOnAction(e -> {
           Label l = new Label("Slide " + (++listElements) + " Caption: ");
           TextField t = new TextField();
           Button b = new Button("Browse Image");
           ImageView im = new ImageView(new Image("file:" + PATH_SLIDESHOW_IMAGES + "DefaultStartSlide.png"));
           HBox el = new HBox();
           el.getChildren().addAll(l, t, b, im);
           elements.add(el);
           ssDialog.getRoot().getChildren().clear();
           for(HBox h : elements) {
               ssDialog.addNode(h);
           }
           ssDialog.addNode(add);
           ssDialog.addConfirm();
           element1.impl_processCSS(true);
           ssDialog.addHeight(element1.getHeight());
        });
        ssDialog.prepareToShow();
        ssDialog.show();
    }

    private void openVideoDialog() {
        CustomDialog videoDialog = new CustomDialog();
        videoDialog.getIcons().add(new Image("file:" + PATH_ICONS + "videoplay2.png"));
        GridPane g = new GridPane();
        g.setHgap(10);
        g.setVgap(10);
        Button browse = new Button("Browse Video");
        GridPane.setConstraints(browse, 0, 0);
        Label l = new Label("Caption: ");
        TextField cap = new TextField();
        GridPane.setConstraints(cap, 1, 1);
        GridPane.setConstraints(l, 0, 1);
        Label w = new Label("Width: ");
        TextField wi = new TextField();
        wi.setMaxWidth(50);
        Label h = new Label("Height: ");
        TextField he = new TextField();
        he.setMaxWidth(50);
        GridPane.setConstraints(w, 0, 2);
        GridPane.setConstraints(wi, 1, 2);
        GridPane.setConstraints(h, 2, 2);
        GridPane.setConstraints(he, 3, 2);
        /*Label fl = new Label("Float: ");
        ToggleGroup group = new ToggleGroup();
        RadioButton left = new RadioButton("Left");
        left.setToggleGroup(group);
        left.setSelected(true);
        RadioButton right = new RadioButton("Right");
        right.setToggleGroup(group);
        RadioButton ne = new RadioButton("Neither");
        ne.setToggleGroup(group);
        GridPane.setConstraints(fl, 0, 3);
        GridPane.setConstraints(left, 1, 3);
        GridPane.setConstraints(right, 2, 3);
        GridPane.setConstraints(ne, 3, 3);*/
        g.getChildren().addAll(browse, l, cap, w, wi, h, he);
        videoDialog.addNode(g);
        videoDialog.prepareToShow();
        videoDialog.show();
    }

    public void openRemoveDialog() {
        Alert removeAlert = new Alert(AlertType.CONFIRMATION);
        removeAlert.setTitle("Remove Content");
        removeAlert.setHeaderText("Really Remove Content?");
        removeAlert.setContentText("This cannot be undone");
        Optional<ButtonType> response = removeAlert.showAndWait();
        if(response.get() == ButtonType.OK) {
            LayoutComponent selected = view.getLayout().getSelectedComponent();
            if(selected.getType().equals("PageLabel")) {
                int index = view.getLayouts().indexOf((view.getLayout())); 
                view.setLayout(view.getLayouts().get(0),"");
                view.getLayouts().remove(index);
                view.getPageLabels().remove(index);
                view.getPages().remove(index);
            }
            else if(selected.getParent() != null) {
                ((Pane)selected.getParent().getComponent()).getChildren().remove(selected.getComponent());
                view.getLayout().getComponents().remove(selected);
            }
        }
    }
}
