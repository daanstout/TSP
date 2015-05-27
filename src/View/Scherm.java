package View;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableCellRenderer;
import Controller.*;
import Model.*;

public class Scherm extends JFrame implements ActionListener {

    private JButton jbStart;
    private JButton jbStop;
    private JLabel jlSimulatie;
    private JLabel jlResultaat;
    private JLabel jlAlgoritme;
    private JLabel jlOrdernr;
    private JComboBox jcAlgoritme;
    private JTable tResultaat;
    private JLabel jlNummer;
    private TravellingSalesmanProblem tsp;
    private Dimension size;
    private int count = 0;
    private Timer t;
    private ArrayList<String> Algoritmes;
    private ArrayList<String> Afstanden;
    private ArrayList<String> ALTijd;
    private Tekenpanel tSimulator;
    private Magazijn magazijn;
    private Order order;
    private String algoritme;
    private ArrayList<Artikel> lijst;
    private ArrayList<Vak> vakLijst;
    private boolean drawing;
    private int drawingCount;

    public Scherm(Magazijn magazijn, Order order, TravellingSalesmanProblem tsp) {
        this.algoritme = null;
        this.tsp = tsp;
        this.magazijn = magazijn;
        this.order = order;
        this.setTitle("TSP");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        drawing = false;
        drawingCount = 0;

        // initialiseren arraylisten
        vakLijst = new ArrayList<>();
        lijst = new ArrayList<>();
        Algoritmes = new ArrayList<>();
        Afstanden = new ArrayList<>();
        ALTijd = new ArrayList<>();

        //initialiseren jframe
        jbStart = new JButton("Start simulatie");
        jbStop = new JButton("Stop simulatie");
        jlSimulatie = new JLabel("Simulatie");
        jlResultaat = new JLabel("Resultaat");
        jlAlgoritme = new JLabel("Algoritme");
        jlOrdernr = new JLabel("Order nummer");
        jcAlgoritme = new JComboBox();
        jlNummer = new JLabel(String.valueOf(order.getOrderNummer()));

        // wat custom fonds
        Font header = new Font("Arial", Font.BOLD, 25);
        Font defaultFont = new Font("Arial", Font.PLAIN, 14);

        //dit zijn de gegevens voor de tabel om mee te beginnen
        Algoritmes.add("Volledige enumeratie");
        Algoritmes.add("Simpel gretig algoritme");
        Algoritmes.add("Volgorde van order");
        Afstanden.add("-");
        Afstanden.add("-");
        Afstanden.add("-");

        Insets insets = this.getInsets();

        // hie rmaken we de tabel aan
        ArrayList<String> wachtrijHeading = new ArrayList<String>(Arrays.asList("Algoritme", "Afstand"));
        tResultaat = new JTable(new PakketTableModel(Algoritmes, Afstanden, wachtrijHeading));
        getContentPane().add(new JScrollPane(tResultaat), BorderLayout.CENTER);
        tResultaat.setPreferredSize(new Dimension(275, 422));
        tResultaat.setFont(defaultFont);
        tResultaat.setRowHeight(20);

        //wat gegevens om de tabel beter eruit te laten zien
        DefaultTableCellRenderer wachtrijRenderer = new DefaultTableCellRenderer();
        wachtrijRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tResultaat.getColumnModel().getColumn(0).setCellRenderer(wachtrijRenderer);
        tResultaat.getTableHeader().setReorderingAllowed(false);
        tResultaat.getTableHeader().setFont(defaultFont);
        tResultaat.getColumnModel().getColumn(0).setPreferredWidth(100);
        tResultaat.getColumnModel().getColumn(1).setPreferredWidth(15);

        //een panel om de tabel in te zetten, de tabel kan niet in een absolute layout
        JPanel j = new JPanel(new BorderLayout());
        j.add(tResultaat.getTableHeader(), BorderLayout.PAGE_START);
        j.add(tResultaat, BorderLayout.CENTER);
        j.setBorder(BorderFactory.createLineBorder(Color.black));
        j.add(new JScrollPane(tResultaat));
        j.setPreferredSize(new Dimension(380, 150));
        add(j);

        size = j.getPreferredSize();
        j.setBounds(insets.left + 30, insets.top + 400, size.width, size.height);

        // de tekenpanel
        tSimulator = new Tekenpanel(this.order, this.algoritme);

        JPanel drawPanel = new JPanel();

        drawPanel.setBounds(insets.left + 450, insets.top + 100, 400, 400);
        drawPanel.add(tSimulator);

        //toevoegen van de knoppen en schermen aan het JFrame
        add(drawPanel);
        add(jbStart);
        add(jbStop);
        add(jlSimulatie);
        add(jlResultaat);
        add(jlAlgoritme);
        add(jlOrdernr);
        add(jlNummer);

        jlSimulatie.setFont(header);
        jlResultaat.setFont(header);
        jlAlgoritme.setFont(defaultFont);
        jlOrdernr.setFont(defaultFont);
        jlNummer.setFont(defaultFont);

        //het bepalen van de locaties van alles
        size = jbStart.getPreferredSize();
        jbStart.setBounds(insets.left + 30, insets.top + 300, size.width, size.height);

        size = jbStop.getPreferredSize();
        jbStop.setBounds(insets.left + 180, insets.top + 300, size.width, size.height);

        size = jlSimulatie.getPreferredSize();
        jlSimulatie.setBounds(insets.left + 450, insets.top + 45, size.width, size.height);

        size = jlResultaat.getPreferredSize();
        jlResultaat.setBounds(insets.left + 30, insets.top + 350, size.width, size.height);

        size = jlAlgoritme.getPreferredSize();
        jlAlgoritme.setBounds(insets.left + 30, insets.top + 50, size.width, size.height);

        size = jlOrdernr.getPreferredSize();
        jlOrdernr.setBounds(insets.left + 30, insets.top + 220, size.width, size.height);

        size = jlNummer.getPreferredSize();
        jlNummer.setBounds(insets.left + 180, insets.top + 220, size.width, size.height);

        // keuzes aan de combobox toevoegen
        jcAlgoritme.addItem("Kies algoritme");
        jcAlgoritme.addItem("Volledige enumeratie");
        jcAlgoritme.addItem("Simpel gretig algoritme");
        jcAlgoritme.addItem("Volgorde van order");

        // panel voor de combobox, netzoals de tabel kan de combobox niet in absolute layout
        JPanel a = new JPanel(new FlowLayout());
        a.add(jcAlgoritme);
        a.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel fieldPanel = new JPanel(new GridLayout(1, 1)); // 2 rows 1 column
        add(fieldPanel, BorderLayout.CENTER);

        fieldPanel.add(jcAlgoritme);
        fieldPanel.setPreferredSize(new Dimension(180, 20));

        size = fieldPanel.getPreferredSize();
        fieldPanel.setBounds(insets.left + 180, insets.top + 50, size.width, size.height);

        add(a);

        // toevoegen van actionlisteners
        this.jbStart.addActionListener(this);
        this.jbStop.addActionListener(this);
        this.jcAlgoritme.addActionListener(this);

        revalidate();
        pack();
        this.setVisible(true);

        // de timer
        t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // hier kijkt hij of er een algoritme is gekozen, als dat zo is gaat hij de route tekenen afhankelijk van het gekozen
                // algoritme
                if (algoritme != null) {
                    tSimulator = new Tekenpanel(order, algoritme);
                    drawPanel.remove(0);
                    drawPanel.add(tSimulator);
                    if (algoritme == "Volledige enumeratie") {
                        if (lijst.isEmpty()) {
                            order.emptyAlgoritmeLijst();
                            vakLijst = tsp.artikelToVak(order.getProductLijst());
                            TravellingSalesmanProblem.permute(vakLijst, 0);
                            lijst = tsp.vakToArtikel(tsp.kortsteRoute);
                            lijst.add(new Artikel(1, 1, null, 5, 1, 1));
                        }
                        if (!lijst.isEmpty()) {
                            order.addAlgoritmeLijst(lijst.get(0));
                            lijst.remove(0);
                        }
                        if (lijst.isEmpty()) {
                            Afstanden.set(0, Integer.toString(tsp.kortsteDistance));
                            t.stop();
                        }
                    } else if (algoritme == "Simpel gretig algoritme") {
                        if (lijst.isEmpty()) {
                            order.emptyAlgoritmeLijst();
                            lijst = tsp.nearestNeighboor(order.getProductLijst());
                            lijst.add(new Artikel(1, 1, null, 5, 1, 1));
                        }
                        if (!lijst.isEmpty()) {
                            order.addAlgoritmeLijst(lijst.get(0));
                            lijst.remove(0);
                        }
                        if (lijst.isEmpty()) {
                            
                            Afstanden.set(1, Integer.toString(tsp.getNearestNeighboorAfstand()));
                            t.stop();
                        }
                    } else if (algoritme == "Volgorde van order") {
                        if (!drawing) {
                            order.emptyAlgoritmeLijst();
                            drawing = true;
                        }
                        if (drawing && drawingCount - 1 < order.getProductLijst().size()) {
                            if(drawingCount < order.getProductLijst().size()){
                                order.addAlgoritmeLijst(order.getArtikel(drawingCount));
                            }else{
                                order.addAlgoritmeLijst(new Artikel(1, 1, null, 5, 1, 99));
                            }
                            
                            if (drawingCount == order.getProductLijst().size()) {
                                drawing = false;
                            }
                            drawingCount++;
                        }
                        if (!drawing) {
                            Afstanden.set(2, Integer.toString(tsp.getOrderAfstand(order.getProductLijst())));
                            drawingCount = 0;
                            t.stop();
                        }

                    }

                    revalidate();
                    repaint();
                } else {
                    t.stop();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // kijkt welke knop is ingedrukt
        if (e.getSource() == jbStart) {
            t.start();
        } else if (e.getSource() == jbStop) {
            t.stop();
        } else if (e.getSource() == jcAlgoritme) {
            JComboBox comboBox = (JComboBox) e.getSource();

            Object selected = comboBox.getSelectedItem();
            if (selected.toString().equals("Volledige enumeratie")) {
                algoritme = "Volledige enumeratie";

                if (count == 0) {
                    comboBox.removeItemAt(0);
                    count++;
                }
            } else if (selected.toString().equals("Simpel gretig algoritme")) {
                algoritme = "Simpel gretig algoritme";

                if (count == 0) {
                    comboBox.removeItemAt(0);
                    count++;
                }
            } else if (selected.toString().equals("Volgorde van order")) {
                algoritme = "Volgorde van order";

                if (count == 0) {
                    comboBox.removeItemAt(0);
                    count++;
                }
            }
        }

        revalidate();

        repaint();
    }

}
