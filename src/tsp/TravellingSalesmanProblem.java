
package tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


    public class TravellingSalesmanProblem {
    
    private Magazijn magazijn;
    private ArrayList<Artikel> routeData;
    private String Resultaat;
        
    
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
}