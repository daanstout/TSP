package tsp;

public class Vak {
   private int x;
   private int y;
    
    // Maakt een gekozen vak met x en y coordinaten
    // Met opzet:  Vak vakA1 = new Vak(1, 1);
    
    public Vak(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Gets vak's x coordinaten
    public int getX(){
        return this.x;
    }
    
    // Gets vaks's y coordinaten
    public int getY(){
        return this.y;
    }
    
    // Gets de afstand voor het gegeven vak
    public double distanceTo(Vak vak){
        int xDistance = Math.abs(getX() - vak.getX());
        int yDistance = Math.abs(getY() - vak.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}
