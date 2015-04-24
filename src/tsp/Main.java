/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import static tsp.TravellingSalesmanProblem.permute;

/**
 *
 * @author Coolbone
 */
public class Main {

public static void main(String[] args) {
    Scherm scherm = new Scherm();
        
    Insets insets = scherm.getInsets();
    scherm.setSize(900 + insets.left + insets.right, 600 + insets.top + insets.bottom);
    
    
        Vak vak1 = new Vak(1, 1, 1);
        Vak vak2 = new Vak(2, 2, 2);
        Vak vak3 = new Vak(3, 1, 3);
        Vak vak4 = new Vak(4, 1, 4);
        Vak vak5 = new Vak(5, 1, 5);
        Vak vak6 = new Vak(1, 2, 6);
        Vak vak7 = new Vak(2, 2, 7);
        Vak vak8 = new Vak(3, 2, 8);
        Vak vak9 = new Vak(4, 2, 9);
        Vak vak10 = new Vak(5, 2, 10);
        Vak vak11 = new Vak(1, 3, 11);
        Vak vak12 = new Vak(2, 3, 12);
        Vak vak13 = new Vak(3, 3, 13);
        Vak vak14 = new Vak(4, 3, 14);
        Vak vak15 = new Vak(5, 3, 15);
        Vak vak16 = new Vak(1, 4, 16);
        Vak vak17 = new Vak(2, 4, 17);
        Vak vak18 = new Vak(3, 4, 18);
        Vak vak19 = new Vak(4, 4, 19);
        Vak vak20 = new Vak(5, 4, 20);
        Vak vak21 = new Vak(1, 5, 21);
        Vak vak22 = new Vak(2, 5, 22);
        Vak vak23 = new Vak(3, 5, 23);
        Vak vak24 = new Vak(4, 5, 24);
        Vak vak25 = new Vak(5, 5, 25);
    
        System.out.println(vak1.distanceTo(vak9));
        
        ArrayList<Vak> vakLijst = new ArrayList<>();
        
        vakLijst.add(vak1);
        vakLijst.add(vak5);
        vakLijst.add(vak19);
        
        
        permute(VaktoInt(vakLijst), 0);
}

public static ArrayList VaktoInt(ArrayList<Vak> k){
        ArrayList<Integer> a = new ArrayList<>();
        
        for(Vak h : k){
            a.add(h.getNr());
        }
        
        return a;
    }
    
    
    
//        Insets insets = scherm.getInsets();
//        scherm.setSize(700 + insets.left + insets.right, 520 + insets.top + insets.bottom);
}
