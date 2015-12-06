/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import model.BuilderModel;
import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.ANTON_FONT;
import static desinfeuilles.StartupConstants.CHEWY_FONT;
import static desinfeuilles.StartupConstants.CSS_CLASS_COLOR_PICKER;
import static desinfeuilles.StartupConstants.CSS_CLASS_EMPTY_LAYOUT;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_CLASS_FILE_TOOLBAR_BUTTON_FIRST;
import static desinfeuilles.StartupConstants.CSS_CLASS_HBANNER;
import static desinfeuilles.StartupConstants.CSS_CLASS_ROOT;
import static desinfeuilles.StartupConstants.CSS_CLASS_SPECIAL_BUTTON;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR;
import static desinfeuilles.StartupConstants.CSS_CLASS_STYLE_TOOLBAR_BUTTON;
import static desinfeuilles.StartupConstants.CSS_FONTS;
import static desinfeuilles.StartupConstants.CSS_SHEET;
import static desinfeuilles.StartupConstants.INDIE_FLOWER_FONT;
import static desinfeuilles.StartupConstants.PACIFICO_FONT;
import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import desinfeuilles.template.EmptyLayout;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.NavBar;
import desinfeuilles.template.PageLabel;
import desinfeuilles.template.StyleTemplate;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Benito
 */
public class BuilderView implements Serializable {
    SiteBuilder siteBuilder;
    FileController fileController;
    StyleController styleController;
    BuilderModel model;
    
    Stage primaryStage;
    Scene scene;
    BorderPane root;
    
    LayoutTemplate openLayout;
    StyleTemplate openStyle;
    ArrayList<LayoutTemplate> layouts;
    ArrayList<StyleTemplate> styles;
    
    Button newB, openB, saveB, saveAsB, exportB, exitB;
    
    Button styleTemplateB, layoutB, editTextB, backgroundImageB, colorB, fontB, addContentB, addPageB, removeB;
    
    Button viewB;
    
    TilePane styleToolbar;
    TilePane fileToolbar;
    HBox toolbars;
    
    ArrayList<String> pages;
    ArrayList<PageLabel> pageLabels;
    
    public BuilderView(SiteBuilder sb, FileController f, StyleController s, BuilderModel model) {
        siteBuilder = sb;
        fileController = f;
        styleController = s;
        this.model = model;
        s.setView(this);
        initView();
        pages = new ArrayList<>();
        //pages.add("Home");
        pageLabels = new ArrayList<>();
        //reloadPageLabels();
    }
    
    public void initView() {
        primaryStage = new Stage();
        root = new BorderPane();
        root.getStyleClass().add(CSS_CLASS_ROOT);
        toolbars = new HBox();
        root.setTop(toolbars);
        
        layouts = new ArrayList<>();
        styles = new ArrayList<>();
        
        openLayout = new EmptyLayout();
        root.setCenter(openLayout.getMainPane());
        openLayout.getMainPane().getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
        
        //layouts.add(openLayout);
        
        //fileToolbar = new ToolBar();
        //fileToolbar.setPadding(new Insets(10));
        //styleToolbar = new ToolBar();
        //styleToolbar.setPadding(new Insets(10));
        
        //toolbars.setMaxWidth(Double.MAX_VALUE);
        
        initFileToolbar();
        initStyleToolbar();
        
        toolbars.getChildren().add(fileToolbar);
        toolbars.getChildren().add(styleToolbar);
        
        viewB = initButton("View.png", "View Site", CSS_CLASS_SPECIAL_BUTTON, false);
        toolbars.getChildren().add(viewB);
        
        scene = new Scene(root);
        
        primaryStage.setTitle("DesinFeuilles SiteBuilder");
        primaryStage.setMaximized(true);
        scene.getStylesheets().addAll(CSS_SHEET, CSS_FONTS, CHEWY_FONT, INDIE_FLOWER_FONT, ANTON_FONT, PACIFICO_FONT);
        primaryStage.setScene(scene);
        
        initEventHandlers();
    }
    
    public void show() {
        primaryStage.show();
    }
    
    public void initEventHandlers() {
        newB.setOnAction(e -> {
            fileController.handleNewRequest();
        });
        exitB.setOnAction(e -> {
            fileController.handleExitRequest();
        });
        styleTemplateB.setOnAction(e -> {
            styleController.openStyleChooser();
        });
        layoutB.setOnAction(e -> {
           styleController.openLayoutChooser("Home"); 
        });
        editTextB.setOnAction(e -> {
            styleController.openTextEditor();
        });
        backgroundImageB.setOnAction(e -> {
            styleController.openBackgroundImageChooser();
        });
        colorB.setOnAction(e -> {
            styleController.openColorChooser();
        });
        fontB.setOnAction(e -> {
            styleController.openFontChooser();
        });
        addContentB.setOnAction(e -> {
            styleController.openAddContentDialog();
        });
        addPageB.setOnAction(e -> {
            styleController.openAddPageDialog();
        });
        removeB.setOnAction(e -> {
            styleController.openRemoveDialog();
        });
        viewB.setOnAction(e -> {
            fileController.viewSite();
        });
        saveAsB.setOnAction(e -> {
            fileController.handleSaveAsRequest();
        });
        exportB.setOnAction(e -> {
            fileController.handleExportRequest();
        });
        saveB.setOnAction(e -> {
            fileController.handleSaveRequest();
        });
        openB.setOnAction(e -> {
            fileController.handleOpenRequest();
        });
    }
    
    public void initFileToolbar() {
        fileToolbar = new TilePane();
        fileToolbar.setHgap(10);
        //fileToolbar.setAlignment(Pos.CENTER);
        newB = initButton("New.png", "New", CSS_CLASS_FILE_TOOLBAR_BUTTON_FIRST, false);
        openB = initButton("Load.png", "Open", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        saveB = initButton("Save.png", "Save", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        saveAsB = initButton("SaveAs.png", "Save As", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exportB = initButton("Export.png", "Export", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        exitB = initButton("Exit.png", "Exit", CSS_CLASS_FILE_TOOLBAR_BUTTON, false);
        fileToolbar.getChildren().addAll(newB, openB, saveB, saveAsB, exportB, exitB);
        fileToolbar.getStyleClass().add(CSS_CLASS_FILE_TOOLBAR);
        fileToolbar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(fileToolbar, Priority.ALWAYS);
        //HBox.setVgrow(fileToolbar, Priority.ALWAYS);
    }
    
    public void initStyleToolbar() {
        styleToolbar = new TilePane();
        styleToolbar.setHgap(10);
        styleTemplateB = initButton("StyleTemplate.png", "Choose Style Template", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        layoutB = initButton("Template.png", "Choose Layout", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        editTextB = initButton("Edit.png", "Edit Text", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        backgroundImageB = initButton("Background.png", "Select Background Image", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        colorB = initButton("Paint.png", "Select Color", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        fontB = initButton("Font.png", "Select Font", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        addContentB = initButton("Add.png", "Add Content", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        addPageB = initButton("AddPage.png", "Add Page", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        removeB = initButton("DeleteScheduleItem.png", "Remove Component", CSS_CLASS_STYLE_TOOLBAR_BUTTON, false);
        styleToolbar.getChildren().addAll(styleTemplateB, layoutB, editTextB, backgroundImageB, colorB, fontB, addContentB, addPageB, removeB);
        styleToolbar.getStyleClass().add(CSS_CLASS_STYLE_TOOLBAR);
        styleToolbar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(styleToolbar, Priority.ALWAYS);
    }
    
    public Button initButton(String iconFileName, 
            String tooltip,
            String cssClass,
            boolean disabled) {
        Button b = new Button();
        Image bImage = new Image("file:" + PATH_ICONS + iconFileName);
        ImageView bImageView = new ImageView(bImage);
        bImageView.setFitHeight(18);
        bImageView.setPreserveRatio(true);
        b.setGraphic(bImageView);
        b.setTooltip(new Tooltip(tooltip));
        b.getStyleClass().add(cssClass);
        b.setDisable(disabled);
        b.setMaxWidth(Double.MAX_VALUE);
        b.setMaxHeight(Double.MAX_VALUE);
        //b.resize(24, 24);
        return b;
    }
    
    public ArrayList<LayoutTemplate> getLayouts() {
        return layouts;
    }
    
    public void setLayout(LayoutTemplate l, String newPage) {
        openLayout = l;
        root.setCenter(openLayout.getMainPane());
        if(!newPage.equals("")) {
            pages.add(newPage);
            layouts.add(openLayout);
            openLayout.applyStyle(openStyle);
            //initLayout();
        }
        initLayout();
        model.setLayout(openLayout);
        reloadPageLabels();
        if(!newPage.equals("")) pageLabels.get(pageLabels.size() - 1).select();
    }
    
    public void setStyleTemplate(StyleTemplate style) {
        this.openStyle = style;
        openLayout = new EmptyLayout();
        root.setCenter(openLayout.getMainPane());
        openLayout.getMainPane().getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
        openLayout.applyStyle(style);
        model.setStyle(style);
    }
    
    public void initLayout() {
        NavBar openBar = openLayout.getNavBar();
        ((Pane)openBar.getComponent()).getChildren().clear();
        openBar.getNavBarModel().getPages().clear();
        for(String p : pages) {
            openBar.addPage(p, p.replaceAll("\\s", "") + ".html");
        }
        //openLayout.applyStyle(openStyle);
    }
    
    public LayoutTemplate getLayout() {
        return openLayout;
    }
    
    public BorderPane getBorderPane() {
        return root;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public TilePane getStyleToolbar() {
        return styleToolbar;
    }
    
    public TilePane getFileToolbar() {
        return fileToolbar;
    }
    
    public StyleController getStyleController() {
        return styleController;
    }
    
    public Button getLayoutB() {
        return layoutB;
    }
    
    public Button getStyleTemplateB() {
        return styleTemplateB;
    }

    public Window getStage() {
        return primaryStage;
    }
    
    public void reloadPageLabels() {
        NavBar openBar = openLayout.getNavBar();
        if(openBar == null) return;
        //openBar.clear();
        pageLabels.clear();
        for(PageLabel pageLabel : openBar.getNavBarModel().getPages()) {
            pageLabels.add(pageLabel);
            initPageClickHandler(pageLabel);
        }
    }
    
    public void initPageClickHandler(PageLabel pageLabel) {
        pageLabel.getComponent().setOnMouseClicked(e -> {
            String ptxt = ((Label)pageLabel.getComponent()).getText();
            int index = pageLabels.indexOf(pageLabel);
            setLayout(layouts.get(index),"");
            openLayout.deselect();
            pageLabels.get(index).select();
            //LayoutTemplate.balls = true;
        });
    }

    public ArrayList<PageLabel> getPageLabels() {
        return pageLabels;
    }

    public ArrayList<String> getPages() {
        return pages;
    }
    
    public void saveModel() {
        model.layouts = layouts;
        model.pageLabels = pageLabels;
        model.pages = pages;
    }

    public BuilderModel getModel() {
        return model;
    }

    public void loadModel(BuilderModel model) {
        layouts = model.layouts;
        pageLabels = model.pageLabels;
        pages = model.pages;
        for(LayoutTemplate l : layouts) {
            l.revive();
        }
        openLayout = layouts.get(0);
        reloadPageLabels();
        root.setCenter(openLayout.getMainPane());
    }

    public void makeNew() {
        layouts = new ArrayList<>();
        styles = new ArrayList<>();
        
        openLayout = new EmptyLayout();
        root.setCenter(openLayout.getMainPane());
        openLayout.getMainPane().getStyleClass().add(CSS_CLASS_EMPTY_LAYOUT);
    }
}
