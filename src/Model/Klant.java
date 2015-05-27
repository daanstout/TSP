/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Coolbone
 */
public class Klant {
    
    private String voornaam;
    private String achternaam;
    private String adres;
    private String postcode;
    private String woonPlaats;
    
    public Klant(String voornaam, String achternaam, String adres, String postcode, String woonPlaats){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.postcode = postcode;
        this.woonPlaats = woonPlaats;
    }
    
    public String getVoornaam(){
        return voornaam;
    }
    
    public String getAchternaam(){
        return achternaam;
    }
    
    public String getAdres(){
        return adres;
    }
    
    public String getPostcode(){
        return postcode;
    }
    
    public String getWoonPlaats(){
        return woonPlaats;
    }
}
