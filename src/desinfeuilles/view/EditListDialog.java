/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import static desinfeuilles.StartupConstants.PATH_ICONS;
import desinfeuilles.template.LayoutTemplate;
import desinfeuilles.template.ListComponent;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 *
 * @author Benito
 */
public class EditListDialog extends CustomDialog{
    
    LayoutTemplate layout;
    int elementsCount;
    ArrayList<ListElement> elements;
    Button addB;
    ArrayList<String> listStrings;
    ListComponent listComponent;
            
    public EditListDialog(ListComponent l) {
        super();
        listComponent = l;
        elements = l.getElements();
        listStrings = new ArrayList<>();
        elementsCount = elements.size();
        getIcons().add(new Image("file:" + PATH_ICONS + "List.png"));
        for(ListElement el : elements) {
            el.setList(this);
            el.initRemoveBHandler();
            addNode(el);
        }
        addB = new Button("Add Element");
        addNode(addB);
        initAddBHandler();
    }
    
    public EditListDialog(LayoutTemplate layout) {
        super();
        elements = new ArrayList<>();
        listStrings = new ArrayList<>();
        this.layout = layout;
        elementsCount = 1;
        getIcons().add(new Image("file:" + PATH_ICONS + "List.png"));
        ListElement element1 = new ListElement(1, this);
        elements.add(element1);
        addNode(element1);
        addB = new Button("Add Element");
        addNode(addB);
        initAddBHandler();
    }
    
    public void readdAddB() {
        addNode(addB);
    }
    
    public ArrayList<ListElement> getElements() {
        return elements;
    }
    
    public void initEventHandlers() {
        ok.setOnAction(e -> {
            response = OK;
            if(layout != null) layout.addList(new ListComponent(elements, layout));
            else {
                listComponent.reload();
            }
            close();
        });
        cancel.setOnAction(e -> {
           response = CANCEL;
           close();
        });
    }
    
    public void initAddBHandler() {
        addB.setOnAction(e -> {
           elements.add(new ListElement(++elementsCount, this));
           getRoot().getChildren().clear();
           for(ListElement el : elements) {
               addNode(el);
           }
           addNode(addB);
           addConfirm();
           addHeight(elements.get(0).getHeight());
        });
    }
}
