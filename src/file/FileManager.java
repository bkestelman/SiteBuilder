/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import desinfeuilles.SiteBuilder;
import static desinfeuilles.StartupConstants.SITES_PATH;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.view.BuilderView;
import java.io.FileWriter;
import java.io.IOException;
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
        JSONArray layouts = new JSONArray();
        for(LayoutTemplate layout : view.getLayouts()) {
            layouts.add(layout);
        }
        json.put("layouts", layouts);
        try (FileWriter file = new FileWriter(SITES_PATH + name)) {
            file.write(json.toJSONString());
        }
        catch(IOException e) {
        }
    }
}
