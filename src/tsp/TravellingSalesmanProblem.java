
package tsp;

import java.util.ArrayList;


public class TravellingSalesmanProblem {
    private Magazijn magazijn;
    private Vak route;
    private String routeData;
    private String Resultaat;
    private String Algoritme;    


public TravellingSalesmanProblem(Magazijn magazijn, Vak route, String Algoritme  ) {
this.magazijn = magazijn;
this.route = route;
this.Algoritme = Algoritme;
      
        }

public String getAlgoritme() {
    return Algoritme; 
}

public String setResultaat() {
    return Resultaat;
}

}