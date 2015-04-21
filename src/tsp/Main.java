/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author Coolbone
 */
public class Main {

public static void main(String[] args) {
    Scherm scherm = new Scherm();
        scherm.setSize(800,600);
        scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scherm.setResizable(false);
        scherm.setVisible(true);
}
    
    
//        Insets insets = scherm.getInsets();
//        scherm.setSize(700 + insets.left + insets.right, 520 + insets.top + insets.bottom);
}
