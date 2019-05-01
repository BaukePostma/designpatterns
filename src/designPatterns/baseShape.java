/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.awt.Graphics;

/**
 *baseShape for all shapes
 * @author Bauke
 */
public abstract class baseShape {

    // TODO add getters setters
    int x = 50;
    int y = 50;
    int width = 50;
    int height = 50;
    boolean isSelected = false;
    int scale = 100;
    
    public void Draw(Graphics g) {

    }
        public void toggleSelection(){
        this.isSelected = !this.isSelected;
    }
    public void Rescale(boolean direction){
        
    }

}
