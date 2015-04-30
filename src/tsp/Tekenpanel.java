package tsp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Tekenpanel extends JPanel{
    private Magazijn magazijn;
    public static final int PWIDTH = 400;
    public static final int PHEIGHT = 400;
    
    private int xVak = 5;
    private int yVak = 5;
    private int boxWidth;
    private int boxHeight;
    private int padding = 10;
    private int lineHeight = 12;
    
    public Tekenpanel(Magazijn magazijn){
        this.magazijn = magazijn;
        
        setPreferredSize(new Dimension(400,400));
//        setMaximumSize(new Dimension(200,200));
        setMinimumSize(new Dimension(200,200));
        
        boxWidth = (PWIDTH - (2 * padding)) / xVak;
        boxHeight = (PHEIGHT - (2 * padding)) / yVak;
        
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        for(int x = 0; x < xVak; x++){
            for(int y = 0; y < yVak; y++){
                g.drawRect(x * boxWidth + padding, y * boxHeight + padding, boxWidth, boxHeight);
            }
        }
    }
}
