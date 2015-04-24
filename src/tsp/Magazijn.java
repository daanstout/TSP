
package tsp;

import java.util.ArrayList;

public class Magazijn {
  private int aantalVakken;
  private ArrayList Coordinates;
  
  public Magazijn(int aantalVakken){
      this.aantalVakken = aantalVakken;
      Coordinates = new ArrayList<Vak>();
  }
  
  public void addVak(Vak vak) {
        Coordinates.add(vak);
    }

public Vak getVak(int index){
        return (Vak)Coordinates.get(index);
    }

  
  public int getAantalVakken(){
      return aantalVakken;
  }
  
  //public static int numberOfVakken(){
//        return Coordinates.size();
//    }
}
