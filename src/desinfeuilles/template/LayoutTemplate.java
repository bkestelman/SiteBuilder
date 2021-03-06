/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import static desinfeuilles.StartupConstants.CSS_CLASS_SELECTED;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author bkestelman
 */
public abstract class LayoutTemplate implements Serializable {
    transient BorderPane main;
    NavBar nav;
    Banner banner;
    Footer footer;
    StyleTemplate style;
    ContentPane contentPane;
    LayoutComponent selectedComponent; 
    ArrayList<LayoutComponent> components = new ArrayList<>();
    public static boolean balls = false;
    String newestPage;
    ArrayList<String> imgPaths = new ArrayList<>();
    
    public void deselect() {
        if(selectedComponent != null) selectedComponent.invertSelected();
        selectedComponent = null;
    }
    public void setSelectedComponent(LayoutComponent n) {
        selectedComponent = n;
    }
    public LayoutComponent getSelectedComponent() {
        return selectedComponent;
    }
    public void addPage(String pageName, String pageLink) {
        newestPage = pageName;
    }
    public String getNewestPage() {
        return newestPage;
    }
    public abstract void addBanner(Banner banner);
    public abstract void addNav(NavBar nav);
    public abstract void addFooter(Footer footer);
    public abstract void addContentPane(ContentPane cpane);
    public abstract Pane getMainPane();
    public ContentPane getContentPane() {return contentPane;}
    public abstract NavBar getNavBar();
    public abstract Banner getBanner();
    public abstract Footer getFooter();
    public abstract Pane getSelectedPane();
    public abstract void applyStyle(StyleTemplate style);
    @Override
    public abstract String toString();
    public void addComponent(LayoutComponent component) {
        components.add(component);
    }
    public ArrayList<LayoutComponent> getComponents() {
        return components;
    }
    public void unselectStuff() { 
        for(LayoutComponent c : components) {
            if(!c.isSelected()) {
                //c.getComponent().impl_processCSS(true);
                c.getComponent().getStyleClass().remove(CSS_CLASS_SELECTED);
            }
        }
    }
    
    public StyleTemplate getStyleTemplate() {
        return style;
    }

    public void addParagraph(String pText) {
        Paragraph p = new Paragraph(pText, this);
        components.add(p);
        p.setParent(contentPane);
        ((VBox)(contentPane.getComponent())).getChildren().add(p.getComponent());
        contentPane.getContent().add(p);
    }
    
    public void addHeader(String hText) {
        Header h = new Header(hText, this);
        components.add(h);
        h.setParent(contentPane);
        ((VBox)(contentPane.getComponent())).getChildren().add(h.getComponent());
        contentPane.getContent().add(h);
    }
    
    public void addList(ListComponent list) {
        components.add(list);
        list.setParent(contentPane);
        ((VBox)contentPane.getComponent()).getChildren().add(list.getComponent());
        contentPane.getContent().add(list);
    }

    public void revive() {
        main = new BorderPane();
        /*for(LayoutComponent lc : components) {
            lc.revive();
        }*/
        footer.revive();
        banner.revive();
        contentPane.revive();
        nav.revive();
        main.setBottom(footer.getComponent());
        main.setCenter(contentPane.getComponent());
        style.applyFullStyle(this);
    }

    public ImageComponent addImage(String iv, String cap) {
        ImageComponent img = new ImageComponent(iv, cap, this);
        ((Pane)contentPane.getComponent()).getChildren().add(img.getComponent());
        img.setParent(contentPane);
        components.add(img);
        contentPane.getContent().add(img);
        imgPaths.add(iv);
        return img;
    }

    public VideoComponent addVideo(File vidFile, String cap) {
        VideoComponent vid = new VideoComponent(vidFile, cap, this);
        ((Pane)contentPane.getComponent()).getChildren().add(vid.getComponent());
        vid.setParent(contentPane);
        components.add(vid);
        contentPane.getContent().add(vid);
        return vid;
    }
    
    public String getHTML() {
        return banner.getHTML() + nav.getHTML() + contentPane.getHTML() + footer.getHTML();
    }

    public ArrayList<String> getImagePaths() {
        return imgPaths;
    }
}
