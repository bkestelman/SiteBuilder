/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.SITES_PATH;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.PageLabel;
import desinfeuilles.view.BuilderView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bkestelman
 */
public class FileManager {
    SiteBuilder siteBuilder;
    
    public FileManager(SiteBuilder siteBuilder) {
        this.siteBuilder = siteBuilder;
    }

    public void saveJSON(String name) {
        BuilderView view = siteBuilder.getView();
        JSONObject json = new JSONObject();
        for (LayoutTemplate layout : view.getLayouts()) {
            int index = view.getLayouts().indexOf(layout);
            PageLabel p = view.getPageLabels().get(index);
            json.put(layout, layout.getHTML());
            try (FileWriter file = new FileWriter(SITES_PATH + name + "/" + p.getText() + ".json")) {
                file.write(json.toJSONString());
            } catch (IOException e) {
            }
        }
    }
    
    public void generateSite(String name) {
        File stylesDir = new File(SITES_PATH + name + "/css");
        if(!stylesDir.exists()) stylesDir.mkdir();
        File imageDir = new File(SITES_PATH + name + "/img");
        if(!imageDir.exists()) imageDir.mkdir();
        File jsDir = new File(SITES_PATH + name + "/js");
        if(!jsDir.exists()) jsDir.mkdir();
        
        try {
            Files.copy(Paths.get(SITES_PATH + "site.js"), Paths.get(SITES_PATH + name + "/site.js"), REPLACE_EXISTING);
            
            BuilderView view = siteBuilder.getView();
            for(PageLabel p : view.getPageLabels()) {
                Files.copy(Paths.get(SITES_PATH + "index.html"), Paths.get(SITES_PATH + name + "/" + p.getLink()), REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
