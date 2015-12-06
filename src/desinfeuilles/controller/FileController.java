/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.OBJECT_DATA_PATH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

/**
 *
 * @author Benito
 */
public class FileController {
    public SiteBuilder siteBuilder;
    
    public FileController(SiteBuilder sb) {
        siteBuilder = sb;
    }
    
    public void handleExitRequest() {
        System.exit(0);
    }

    public void viewSite() {
        Stage viewStage = new Stage();
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load("https://google.com");
        Scene scene = new Scene(browser);
        viewStage.setScene(scene);
        viewStage.show();
    }
    
    public void handleSaveAsRequest() {
        siteBuilder.getView().saveModel();
        FileChooser filechoo = new FileChooser();
        filechoo.setTitle("Save Project");
        File defaultDir = new File(OBJECT_DATA_PATH);
        filechoo.setInitialDirectory(defaultDir);
        FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("Java Object (*.ser)", "*.ser");
        filechoo.getExtensionFilters().add(ext);
        File saveAs = filechoo.showSaveDialog(siteBuilder.getView().getStage());
        try {
            if(!saveAs.exists())
                saveAs.createNewFile();
            FileOutputStream fileout = new FileOutputStream(saveAs);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(siteBuilder.getModel());
            out.close();
            fileout.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public void handleOpenRequest() {
        siteBuilder.loadView();
    }
    
    public void handleSaveRequest() {
        
    }
    
    public void handleExportRequest() {
        siteBuilder.getFileManager().saveJSON();
    }
}
