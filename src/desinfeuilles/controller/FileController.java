/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.OBJECT_DATA_PATH;
import static desinfeuilles.StartupConstants.SITES_PATH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
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
    File saveAs;
    
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
        saveAs = filechoo.showSaveDialog(siteBuilder.getView().getStage());
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
    
    public void handleNewRequest() {
        siteBuilder.getView().makeNew();
    }
    
    public void handleOpenRequest() {
        siteBuilder.loadView();
    }
    
    public void handleSaveRequest() {
        if(saveAs == null) handleSaveAsRequest();
        else
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
    
    public void handleExportRequest() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Export to...");
        dialog.setHeaderText("What would you like to call your site?");
        dialog.setContentText("Your site will be saved in this application's '/sites' directory");
        Optional<String> name = dialog.showAndWait();
        File sites = new File(SITES_PATH);
        if(!sites.exists()) sites.mkdir();
        File exportDir = new File(SITES_PATH + name.get());
        if(!exportDir.exists()) exportDir.mkdir();
        
        siteBuilder.getFileManager().saveJSON(name.get());
        siteBuilder.getFileManager().generateSite(name.get());
    }
}
