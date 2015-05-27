/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    private ArrayList<Artikel> algoritmeLijst;
    
    public Order(int orderNummer, Klant klant){
        this.orderNummer = orderNummer;
        this.klant = klant;
        productLijst = new ArrayList<>();
        algoritmeLijst = new ArrayList<>();
    }
    
    public void addProduct(Artikel a){
        productLijst.add(a);
    }
    
    public ArrayList getAlgoritmeLijst(){
        return algoritmeLijst;
    }
    
    public void addAlgoritmeLijst(Artikel a){
        algoritmeLijst.add(a);
    }
    
    public Artikel getArtikel(int a){
        return productLijst.get(a);
    }
    
    public int getOrderNummer(){
        return orderNummer;
    }
    
    public ArrayList getProductLijst(){
        return productLijst;
    }
    
    protected void setAlgoritmeLijst(ArrayList<Artikel> productlijst){
        this.algoritmeLijst = productlijst;
    }
    
    public void emptyAlgoritmeLijst(){
        algoritmeLijst.clear();
    }
}
