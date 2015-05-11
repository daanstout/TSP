package tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


    public class TravellingSalesmanProblem {
    
    private Magazijn magazijn;
    private ArrayList<Artikel> routeData;
    private String Resultaat;
    private int nearestNeigboorAfstand;
        
    
    public TravellingSalesmanProblem(Magazijn magazijn){
        this.magazijn = magazijn;
        routeData = new ArrayList<>();
    }

    public String setResultaat() {
        return Resultaat;
    }

    public void addArtikel(Artikel a){
        routeData.add(a);
    }
    
    public int getOrderAfstand(ArrayList<Artikel> productLijst){
        int afstand = 0;
        for(int i = 0;i+1<productLijst.size();i++){
            afstand = afstand + productLijst.get(i).distanceTo(productLijst.get(i+1));
        }
        return afstand;
    }
    
    public int getNearestNeighboorAfstand(){
        return nearestNeigboorAfstand;
    }
    
    
    static ArrayList permute(ArrayList<Integer> arr, int k){
        ArrayList<ArrayList> a = new ArrayList<>();
        for(int i = k; i < arr.size(); i++){
        if (k == arr.size() -1){
            System.out.println(Arrays.toString(arr.toArray()));
        }
        
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
            a.add(arr);
        }
        return a;
    }
    
    
//    public ArrayList<Artikel> minimalSpanningTree(ArrayList<Artikel> productLijst){
//        ArrayList<Artikel> artikelLijst = new ArrayList<>();
//        ArrayList<Integer> afstandLijst = new ArrayList<>();
//        int counter = 0;
//        int artikelCounter = 1;
//        int aantalProducten = productLijst.size();
//        int aantalProductenInLijst = 0;
//        
//        while(counter < productLijst.size()){
//            Artikel checkArtikel = productLijst.get(counter);
//            while(artikelCounter < productLijst.size()){
//                if(counter != artikelCounter){
//                    afstandLijst.add(checkArtikel.distanceTo(productLijst.get(artikelCounter)));
//                }
//                artikelCounter++;
//            }
//            counter++;
//            artikelCounter = counter;
//        }
//        
//        Collections.sort(afstandLijst);
//        counter = 0;
//        artikelCounter = 1;
//        int afstandCounter = 0;
//        boolean continueWhile;
//        ArrayList<Artikel> producten = new ArrayList<>();
//        ArrayList<ArrayList> productenLijst = new ArrayList<>();
//        boolean addible = false;
//        boolean advance;
//        Artikel loopArtikel;
//        
//        while(afstandCounter < afstandLijst.size() && aantalProducten != aantalProductenInLijst){
//            continueWhile = true;
//            counter = 1;
//            
//            while(artikelCounter < productLijst.size() && continueWhile){
//                Artikel checkArtikel = productLijst.get(counter);
//                if(counter != artikelCounter){
//                    if(afstandLijst.get(counter) == checkArtikel.distanceTo(productLijst.get(artikelCounter))){
//                        if(productenLijst.size() <= 2){
//                            producten.add(checkArtikel);
//                            producten.add(productLijst.get(artikelCounter));
//                            productenLijst.add(producten);
//                            continueWhile = false;
//                        }else{
//                            loopArtikel = checkArtikel;
//                            advance = false;
//                            while(advance){
//                                for(ArrayList<Artikel> lijst : productenLijst){
//                                    if(lijst.get(0) == loopArtikel){
//                                        for(ArrayList<Artikel> lijst2 : productenLijst){
//                                            if(lijst.get(1) == lijst2.get(0) || lijst.get(1) == lijst2.get(1)){
//                                                
//                                            }
//                                        }
//                                    }else if(lijst.get(1) == loopArtikel){
//                                        for(ArrayList<Artikel> lijst2 : productenLijst){
//                                            if(lijst.get(1) == lijst2.get(0) || lijst.get(1) == lijst2.get(1)){
//                                                
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                counter++;
//                artikelCounter++;
//            }
//            afstandCounter++;
//        }
//        
//        System.out.println(afstandLijst);
//        return artikelLijst;
//    }
//    
    public ArrayList<Artikel> volledigeEnumeratie(ArrayList<Artikel> productLijst){
        ArrayList<Artikel> artikelLijst = new ArrayList<>();
        
        // code
        
        return artikelLijst;
    }
    
    public ArrayList<Artikel> nearestNeighboor(ArrayList<Artikel> productLijst){
        ArrayList<Artikel> gegevenArtikelLijst = new ArrayList<>();
        for(int i = 0;i<productLijst.size();i++){
            gegevenArtikelLijst.add(productLijst.get(i));
        }
        ArrayList<Artikel> artikelLijst = new ArrayList<>();
        int counter = 0;
        int totaleAfstand = 0;
        while(counter < gegevenArtikelLijst.size()){
            Artikel startArtikel = gegevenArtikelLijst.get(counter);
            if(startArtikel.getX() == 1 &&startArtikel.getY() == 1){
                artikelLijst.add(startArtikel);
                gegevenArtikelLijst.remove(startArtikel);
            }
            counter++;
        }
        
        if(artikelLijst.isEmpty()){
            Artikel A1 = new Artikel(1, 1, null, 1, 1, 1);
            artikelLijst.add(A1);
        }
        
        while(!gegevenArtikelLijst.isEmpty()){
            int artikelToAdd = 0;
            int afstandTocheck = 100;
            counter = 0;
            while(counter < gegevenArtikelLijst.size()){
                int afstand = artikelLijst.get(artikelLijst.size()-1).distanceTo(gegevenArtikelLijst.get(counter));
                if(afstand <= afstandTocheck){
                    afstandTocheck = afstand;
                    artikelToAdd = counter;
                }
                counter++;
            }
            totaleAfstand = totaleAfstand+afstandTocheck;
            artikelLijst.add(gegevenArtikelLijst.get(artikelToAdd));
            gegevenArtikelLijst.remove(artikelToAdd);
        }
        
        if(artikelLijst.get(0).getNaam() == null){
            artikelLijst.remove(0);
        }
        
        nearestNeigboorAfstand = totaleAfstand;
        
        return artikelLijst;
    }
}