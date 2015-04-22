
package tsp;

import java.util.ArrayList;

public class Magazijn {
  private Vak vak;
  private int aantalVakken;
  private static ArrayList Coordinates = new ArrayList<Vak>();
  
  public Magazijn(int aantalVakken){
      this.aantalVakken = aantalVakken;
  }
  
  public static void addVak(Vak vak) {
        Coordinates.add(vak);
    }

public static Vak getVak(int index){
        return (Vak)Coordinates.get(index);
    }

  
  public int getAantalVakken(){
      return aantalVakken;
  }
  
  //public static int numberOfVakken(){
//        return Coordinates.size();
//    }
}
