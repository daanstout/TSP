package tsp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Tekenpanel extends JPanel{
    private Magazijn magazijn;
    
    public Tekenpanel(Magazijn magazijn){
        this.magazijn = magazijn;
        
        setPreferredSize(new Dimension(200,200));
        setMaximumSize(new Dimension(200,200));
        setMinimumSize(new Dimension(200,200));
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 10, 10);
        g.drawRect(0, 0, 200, 200);
        
    }
}
