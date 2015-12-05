/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.style;

/**
 *
 * @author Benito
 */
public class MyFont {
    String fontName;
    String cssClass;
    
    public MyFont(String fontName, String cssClass) {
        this.fontName = fontName;
        this.cssClass = cssClass;
    }

    public String toString() {
        return fontName;
    }
    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    
    
}
