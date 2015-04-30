package tsp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Tekenpanel extends JPanel{
    private Order order;
    public static final int PWIDTH = 400;
    public static final int PHEIGHT = 400;
    
    private int xVak = 5;
    private int yVak = 5;
    private int boxWidth;
    private int boxHeight;
    private int padding = 10;
    private int lineHeight = 12;
    
    public Tekenpanel(Order order){
        this.order = order;
        
        setPreferredSize(new Dimension(400,400));
//        setMaximumSize(new Dimension(200,200));
        setMinimumSize(new Dimension(200,200));
        
        boxWidth = (PWIDTH - (2 * padding)) / xVak;
        boxHeight = (PHEIGHT - (2 * padding)) / yVak;
        
    }
    
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(Color.BLACK);
        for(int x = 0; x < xVak; x++){
            for(int y = 0; y < yVak; y++){
                g.drawRect(x * boxWidth + padding, y * boxHeight + padding, boxWidth, boxHeight);
                int a1 = x * boxWidth + padding;
                int a2 = y * boxHeight + padding;
            }
        }
        
        ArrayList<Artikel> lijst = order.getProductLijst();
        int grootte = lijst.size()-1;
        int count = 0;
        
        while(count<grootte){
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(2));
            
            int artikel1X = lijst.get(count).getX()-1;
            int artikel1Y = lijst.get(count).getY()-1;
            int artikel2X = lijst.get(count+1).getX()-1;
            int artikel2Y = lijst.get(count+1).getY()-1;
            
            g2.drawLine(10 + (38 + (76*artikel1X)), 10 + (76*5) - (38+(76*artikel1Y)), 10 + (38 + (76*artikel2X)), 10 + (76*5) - (38+(76*artikel2Y)));
            
            count++;
        }
    }
}
