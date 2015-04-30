/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Coolbone
 */
public class Permute {
    private static ArrayList<List> finalLijst;
    private static ArrayList<List> vakLijst;
    private static ArrayList<Integer> integerLijst;
   
    static void permute(List<Vak> arr, int k){
      
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){

            // Standaard startpunt
            Vak startPunt = new Vak(1,1,0);
            
                int totDistance = 0;
                int count = 1;
                totDistance += startPunt.distanceTo(arr.get(0));
                for (int j = 0; j < arr.size() - 1; j++) {
                    
                    finalLijst = new ArrayList<>();
                    vakLijst = new ArrayList<>();
                    integerLijst = new ArrayList<>();
                    
                    Vak vak = arr.get(j);          
                    Vak vak2 = arr.get(j + 1);
                    count++;
                    totDistance += vak.distanceTo(vak2);
                    // Weer terug naar startpunt als alles is langsgeweest
                    // TODO, Als er iets in vak 1 zit gaat hij vervelend doen.
                    if (count == arr.size()){
                        totDistance += vak2.distanceTo(startPunt);
                    }

                    vakLijst.add(arr);
                    integerLijst.add(totDistance);
                }
               
                
//                System.out.println(arr.toString() + " - " + totDistance);
                finalLijst.add(vakLijst);
                finalLijst.add(integerLijst);
                
                System.out.println(finalLijst);
               
                
        }
    }
    
//    public static void printen(){
//        for(int i = 0; i < finalLijst.size(); i++) {   
//            System.out.print(finalLijst.get(i));
//        } 
//    }
    
//    public static ArrayList VaktoInt(ArrayList<Vak> k){
//        ArrayList<Integer> a = new ArrayList<>();
//        
//        for(Vak h : k){
//            a.add(h.getNr());
//        }
//        
//        return a;
//    }
    
    
    public static void main(String[] args){
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
        
        permute(Arrays.asList(vak4, vak14, vak21), 0);
//        printen();
    }
}
