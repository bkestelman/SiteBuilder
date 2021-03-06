/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles;

import static desinfeuilles.StartupConstants.OBJECT_DATA_PATH;
import model.BuilderModel;
import static desinfeuilles.StartupConstants.PATH_IMAGES;
import static desinfeuilles.StartupConstants.PATH_TEMPLATES;
import desinfeuilles.animation.Tutorial;
import desinfeuilles.controller.FileController;
import desinfeuilles.controller.StyleController;
import desinfeuilles.style.MyFont;
import desinfeuilles.template.CenterLayout;
import desinfeuilles.view.BuilderView;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import desinfeuilles.template.LeftNavLayout;
import java.util.Iterator;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.StyleTemplate;
import file.FileManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 *
 * @author Benito
 */
public class SiteBuilder extends Application {
    
    public BuilderView view;
    public FileController fileController;
    public StyleController styleController;
    public Tutorial tutorial;
    public ArrayList<LayoutTemplate> layouts;
    public LayoutTemplate l1, l2;
    public ArrayList<StyleTemplate> styles;
    public FileManager fileManager;
    public BuilderModel model;
    public ArrayList<MyFont> fonts;
    
    @Override
    public void start(Stage stage) {
        model = new BuilderModel(this);
        fonts = new ArrayList<>();
        fonts.add(new MyFont("Anton", "anton"));
        fonts.add(new MyFont("Chewy", "chewy"));
        fonts.add(new MyFont("Pacifico", "pacifico"));
        //fonts.add(new MyFont("Indie Flower", "indie_flower"));
        layouts = new ArrayList<>();
        reloadLayoutSelection();
        styles = new ArrayList<>();
        styles.add(new StyleTemplate("Aqua"));
        styles.add(new StyleTemplate("Yellow Fantasy"));
        initStyle(styles.get(0), "Aqua");
        initStyle(styles.get(1), "Yellow");
        fileManager = new FileManager(this);
        fileController = new FileController(this);
        styleController = new StyleController(this);
        view = new BuilderView(this, fileController, styleController, model);
        Alert useTutorial = new Alert(AlertType.CONFIRMATION, "Would you like to go through the tutorial?");
        useTutorial.setHeaderText("Tutorial");
        useTutorial.setTitle("Tutorial");
        view.show();
        Optional<ButtonType> result = useTutorial.showAndWait();
        if(result.get() == ButtonType.OK) {
            tutorial = new Tutorial(view);
            tutorial.run();
        }
        //view.show();
    }
    
    public void reloadLayoutSelection() {
        layouts.clear();
        l1 = new CenterLayout();
        l2 = new LeftNavLayout();
        layouts.add(l1);
        layouts.add(l2);
    }
    
    public void initStyle(StyleTemplate style, String templateName) {
        style.setMainImagePath(PATH_TEMPLATES + templateName + "/main.jpg");
        style.setBannerImagePath(PATH_TEMPLATES + templateName + "/banner.jpg");
    }
    
    public ArrayList<StyleTemplate> getStyles() {
        return styles;
    }
    
    public ArrayList<LayoutTemplate> getLayouts() {
        return layouts;
    }
    
    public Tutorial getTutorial() {
        return tutorial;
    }
    
    public FileManager getFileManager() {
        return fileManager;
    }
    
    public BuilderView getView() {
        return view;
    }
    
    public BuilderModel getModel() {
        return model;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public ArrayList<MyFont> getFonts() {
        return fonts;
    }

    public void loadView() {
        FileChooser filechoo = new FileChooser();
        filechoo.setTitle("Open Project");
        File defaultDir = new File(OBJECT_DATA_PATH);
        filechoo.setInitialDirectory(defaultDir);
        FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("Java Object (*.ser)", "*.ser");
        filechoo.getExtensionFilters().add(ext);
        File open = filechoo.showOpenDialog(view.getStage());
        try {
            FileInputStream filein = new FileInputStream(open);
            ObjectInputStream in = new ObjectInputStream(filein);
            try {
                model = (BuilderModel)in.readObject();
                view.loadModel(model);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SiteBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
            in.close();
            filein.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
