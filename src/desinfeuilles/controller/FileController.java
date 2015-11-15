/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.controller;

import desinfeuilles.SiteBuilder;

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
}
