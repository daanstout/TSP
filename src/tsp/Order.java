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
    
    protected void setProductLijst(ArrayList<Artikel> productlijst){
        this.productLijst = productlijst;
    }
    
    public void importXml(){
        //TODO
    }
    
    
}
