
package tsp;

import java.util.ArrayList;


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

}