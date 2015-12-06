/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desinfeuilles.template;

import javafx.scene.image.ImageView;

/**
 *
 * @author Benito
 */
public class ImageComponent extends LayoutComponent {
    
    public ImageComponent(ImageView img, LayoutTemplate template) {
        super();
        component = img;
        initComponent(template);
    }
}
