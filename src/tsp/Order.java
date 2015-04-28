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
        ArrayList<Artikel> artikelLijst = new ArrayList<>();
        int counter = 0;
        while(counter < productLijst.size()){
            Artikel startArtikel = productLijst.get(counter);
            if(startArtikel.getX() == 1 &&startArtikel.getY() == 1){
                artikelLijst.add(startArtikel);
                productLijst.remove(startArtikel);
            }
            counter++;
        }
        counter = 0;
        
        if(artikelLijst.isEmpty()){
            Artikel A1 = new Artikel(1, 1, null, 1, 1, 1);
            artikelLijst.add(A1);
        }
        
        while(!productLijst.isEmpty()){
            int artikelToAdd = 0;
            int afstandTocheck = 100;
            counter = 0;
            while(counter < productLijst.size()){
                int afstand = artikelLijst.get(artikelLijst.size()-1).distanceTo(productLijst.get(counter));
                if(afstand <= afstandTocheck){
                    afstandTocheck = afstand;
                    artikelToAdd = counter;
                }
                counter++;
            }
            artikelLijst.add(productLijst.get(artikelToAdd));
            productLijst.remove(artikelToAdd);
        }
        
        if(artikelLijst.get(0).getNaam() == null){
            artikelLijst.remove(0);
        }
        
        productLijst = artikelLijst;
    }
}
