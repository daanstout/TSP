/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;


import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;




/**
 *
 * @author Coolbone
 */
public class Scherm extends JFrame implements ActionListener{

    private JButton jbStart;
    private JButton jbStop;
    private JButton jbImport;
    private JLabel jlSimulatie;
    private JLabel jlResultaat;
    private JLabel jlAlgoritme;
    private JLabel jlOrdernr;
    private JComboBox jcAlgoritme; 
    private JTable tResultaat;
    private TravellingSalesmanProblem tsp;
    Dimension size;
    int count = 0;
    
    
    public Scherm()
    {
        JPanel P1 = new JPanel();
        JPanel P2 = new JPanel();
        JPanel P3 = new JPanel();
        JPanel P4 = new JPanel();
        JPanel P5 = new JPanel();
        BorderLayout B = new BorderLayout();
        GridLayout G = new GridLayout();
        JFrame F = new JFrame();
        this.setTitle("TSP");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        this.jbStart = new JButton("Start");
        this.jbStop = new JButton("Stop");
        this.jbImport = new JButton("Import");
        this.jlSimulatie = new JLabel("Simulatie");
        this.jlResultaat = new JLabel("Resultaat");
        this.jlAlgoritme = new JLabel("Algoritme");
        this.jlOrdernr = new JLabel("Order nummer");
        this.jcAlgoritme = new JComboBox();
        
        // table info
        String[] columnNames = {"Algoritme", "Afstand", "Tijd"};
        
        Object[][] data = {
            {"Volledige enumeratie", "25 DM", "5 sec"},
            {"Simpel gretig algoritme", "30 DM", "6 sec"},
            {"Minimal spanning tree", "27 DM", "4 sec"},
        };
        
        Insets insets = this.getInsets();
        
        
        this.tResultaat = new JTable(data, columnNames);
        tResultaat.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tResultaat.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tResultaat);
        add(scrollPane);
        
        this.add(jbStart);
        this.add(jbStop);
        this.add(jbImport);
        this.add(jlSimulatie);
        this.add(jlResultaat);
        this.add(jlAlgoritme);
        this.add(jlOrdernr);
        
        size = jbStart.getPreferredSize();
        jbStart.setBounds(insets.left+200, insets.top, size.width, size.height);
        
        jcAlgoritme.addItem("Kies algoritme");
        jcAlgoritme.addItem("Volledige enumeratie");
        jcAlgoritme.addItem("Simpel gretig algoritme");
        jcAlgoritme.addItem("Minimal spanning tree");
        
        this.add(jcAlgoritme);
        
        this.jbStart.addActionListener(this);
        this.jbStop.addActionListener(this);
        this.jbImport.addActionListener(this);
        this.jcAlgoritme.addActionListener(this);
        
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == jbStart) {
            System.out.println("Start");
        } else if (e.getSource() == jbStop) {
            System.out.println("Stop");
        }else if (e.getSource() == jbImport) {
            System.out.println("Import");
        } else if(e.getSource() == jcAlgoritme){
            JComboBox comboBox = (JComboBox) e.getSource();
               
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Volledige enumeratie"))
                {
                    System.out.println("Volledige enumeratie");

                    if (count == 0)
                    {
                        comboBox.removeItemAt(0);
                        count ++;
                    }
                    
                }
                else if(selected.toString().equals("Simpel gretig algoritme"))
                {
                    System.out.println("Simpel gretig algoritme");
                    if (count == 0)
                    {
                        comboBox.removeItemAt(0);
                        count ++;
                    }
                }
                else if(selected.toString().equals("Minimal spanning tree"))
                {
                    System.out.println("Minimal spanning tree");
                    if (count == 0)
                    {
                        comboBox.removeItemAt(0);
                        count ++;
                    }
                }
        }

        

    }
    
}
