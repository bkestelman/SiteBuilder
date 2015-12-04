/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
        siteBuilder.getFileManager().saveJSON();
    }
}
