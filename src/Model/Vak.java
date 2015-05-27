package Model;

public class Vak {
   private int vaknr;
   private int x;
   private int y;
    
    public Vak(int x, int y, int nr){
        this.x = x;
        this.y = y;
        this.vaknr = nr;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getNr(){
        return this.vaknr;
    }
    
    // Gets de afstand voor het gegeven vak
    public int distanceTo(Vak vak){
        int xDistance = Math.abs(getX() - vak.getX());
        int yDistance = Math.abs(getY() - vak.getY());
        
        int distance = xDistance + yDistance;
        return distance;
    }
    
    @Override
    public String toString(){
        return "Vak"+vaknr;
    }
}
