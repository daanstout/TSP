/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import static tsp.Permute.permute;


/**
 *
 * @author Coolbone
 */
public class Main {

    public static void main(String[] args) {

        
        Magazijn mag = new Magazijn(25);
        
        Vak vak1 = new Vak(1, 1, 1);
        Vak vak2 = new Vak(2, 1, 2);
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
        
        mag.addVak(vak1);
        mag.addVak(vak2);
        mag.addVak(vak3);
        mag.addVak(vak4);
        mag.addVak(vak5);
        mag.addVak(vak6);
        mag.addVak(vak7);
        mag.addVak(vak8);
        mag.addVak(vak9);
        mag.addVak(vak10);
        mag.addVak(vak11);
        mag.addVak(vak12);
        mag.addVak(vak13);
        mag.addVak(vak14);
        mag.addVak(vak15);
        mag.addVak(vak16);
        mag.addVak(vak17);
        mag.addVak(vak18);
        mag.addVak(vak19);
        mag.addVak(vak20);
        mag.addVak(vak21);
        mag.addVak(vak22);
        mag.addVak(vak23);
        mag.addVak(vak24);
        mag.addVak(vak25);
        
        Artikel A1 = new Artikel(1, 1, "Mobiel", 2, 1, 2);
        Artikel A2 = new Artikel(2, 1, "Mobiel", 2, 5, 22);
        Artikel A3 = new Artikel(3, 1, "Mobiel", 1, 2, 6);
        Artikel A4 = new Artikel(4, 1, "Mobiel", 3, 3, 13);
        Artikel A5 = new Artikel(5, 1, "Mobiel", 5, 5, 25);
        Artikel A6 = new Artikel(6, 1, "Mobiel", 4, 4, 19);
        Artikel A7 = new Artikel(7, 1, "Mobiel", 2, 4, 17);
        Artikel A8 = new Artikel(8, 1, "Mobiel", 5, 1, 5);
        Artikel A9 = new Artikel(9, 1, "Mobiel", 1, 5, 21);
        
//        System.out.println(vak1.distanceTo(vak9));
        
        ArrayList<Vak> vakLijst = new ArrayList<>();
        
        vakLijst.add(vak1);
        vakLijst.add(vak5);
        vakLijst.add(vak19);
        vakLijst.add(vak21);
        
        Klant w = new Klant("Daan", "Stout", "Schellerpad 48", "8017 AM", "Zwolle");
        
        Order order = new Order(2, w);
        
        TravellingSalesmanProblem tsp = new TravellingSalesmanProblem(mag, order);
        
        order.addProduct(A3);
        order.addProduct(A4);
        order.addProduct(A5);
        order.addProduct(A1);
        order.addProduct(A2);
        order.addProduct(A6);
        order.addProduct(A7);
//        order.addProduct(A8);
//        order.addProduct(A9);
        
        System.out.println(order.getProductLijst());
        System.out.println(tsp.artikelToVak(order.getProductLijst()));
        Scherm scherm = new Scherm(mag, order, tsp);
        
        Insets insets = scherm.getInsets();
        scherm.setSize(900 + insets.left + insets.right, 600 + insets.top + insets.bottom);
        
//        permute(Arrays.asList(vak4, vak14, vak21), 0);
    }
}