/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author Coolbone
 */
public class Artikel extends Vak{
    
    private int artikelNummer;
    private int grootte;
    private String naam;
    
    public Artikel(int artikelNummer, int grootte, String naam, int x, int y, int nr){
        super(x, y, nr);
        this.artikelNummer = artikelNummer;
        this.grootte = grootte;
        this.naam = naam;
    }
    
    public int getArtikelNummer(){
        return artikelNummer;
    }
    
    public int getGrootte(){
        return grootte;
    }
    
    public String getNaam(){
        return naam;
    }
    
}
