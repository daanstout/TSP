
package tsp;

public class Magazijn {
  private Vak vak;
  private int aantalVakken;
  
  public Magazijn(int aantalVakken){
      this.aantalVakken = aantalVakken;
  }
  
  public int getAantalVakken(){
      return aantalVakken;
  }
}
