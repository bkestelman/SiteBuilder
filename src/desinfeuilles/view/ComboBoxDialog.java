/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.view;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Benito
 */
public class ComboBoxDialog extends CustomDialog {
    public ComboBoxDialog(ObservableList<String> options) {
        super();
        root.getChildren().add(new ComboBox(options));
    }
}
