/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author bkestelman
 */
public class FileManager {
    public FileManager() {
        
    }

    public void saveJSON() {
        JSONObject json = new JSONObject();
        json.put("baby", "come on");
        try (FileWriter file = new FileWriter("./hello.json")) {
            file.write(json.toJSONString());
        }
        catch(IOException e) {
        }
    }
}
