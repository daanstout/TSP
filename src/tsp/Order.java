/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Coolbone
 */
public class Order {

    private int orderNummer;
    private ArrayList<Artikel> productLijst;
    private Klant klant;
    
    public Order(int orderNummer, Klant klant){
        this.orderNummer = orderNummer;
        this.klant = klant;
        productLijst = new ArrayList<>();
    }
    
    public void addProduct(Artikel a){
        productLijst.add(a);
    }
    
    public ArrayList getProductLijst(){
        return productLijst;
    }
    
    public void importXml(){
        //TODO
    }
    
    public void nearestNeighboor(){
        ArrayList<Artikel> a = new ArrayList<>();
        int r = 0;
        while(r < productLijst.size()){
            Artikel w = productLijst.get(r);
            if(w.getX() == 1 &&w.getY() == 1){
                a.add(w);
                productLijst.remove(w);
            }
            r++;
        }
        r = 0;
        
        if(a.isEmpty()){
            Artikel A1 = new Artikel(1, 1, null, 1, 1, 1);
            a.add(A1);
        }
        
        while(!productLijst.isEmpty()){
            int d = 0;
            int c = 100;
            r = 0;
            while(r < productLijst.size()){
                int b = a.get(a.size()-1).distanceTo(productLijst.get(r));
                if(b <= c){
                    c = b;
                    d = r;
                }
                r++;
            }
            a.add(productLijst.get(d));
            productLijst.remove(d);
        }
        
        if(a.get(0).getNaam() == null){
            a.remove(0);
        }
        
        productLijst = a;
    }
}
