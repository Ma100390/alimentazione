package frame;

import matematica.BMR;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymCAFrame extends JFrame {

    private double altezza,peso,età,risultato;
    private String genere,tipoAttività;
    //private ImageIcon icona1 = new ImageIcon(".JPG");
    private ImageIcon icona1 = new ImageIcon("work.png");
    private ImageIcon icona2 = new ImageIcon("work1.PNG");
    private ImageIcon icona3 = new ImageIcon("WORK2.png");
    private ImageIcon icona4 = new ImageIcon("WORK3.PNG");
    private ImageIcon icona5 = new ImageIcon("WORK4.PNG");
    private ImageIcon icona6 = new ImageIcon("COSA.PNG");


    //bottoni della finestra
    private JButton bTDEE = new JButton("TDEE");
    private JButton bReset = new JButton("reset");
    private JButton bBMR = new JButton("BMR");
    private JButton bSedentario = new JButton (icona1);
    private JButton bLeggermenteAttivo = new JButton (icona2);
    private JButton bModeratamenteAttivo = new JButton (icona3);
    private JButton bMoltoAttivo = new JButton (icona4);
    private JButton bEstremamenteAttivo = new JButton (icona5);
    private JButton bInfo = new JButton (icona6);

    // lunghezza della barra vuota
    private JTextField tA = new JTextField(5);
    private JTextField tP = new JTextField(5);
    private JTextField tE = new JTextField(5);
    private JTextField tS = new JTextField(5);
    private JTextField tR = new JTextField(24);

    private JLabel //testo per l'inserimento
            lA    =  new JLabel("Altezza Cm: ", JLabel.RIGHT),
            lP    =  new JLabel("Peso kg: ", JLabel.RIGHT),
            lE    =  new JLabel("Età : ", JLabel.RIGHT),
            lS    =  new JLabel("M/F: ", JLabel.RIGHT),
            lR    =  new JLabel("Ottieni : ", JLabel.RIGHT);

    private JPanel input = new JPanel(),
            output = new JPanel(),
            pulsantiBase = new JPanel(),
            pulsanti1 = new JPanel(),
            pulsanti = new JPanel();

    private JTextArea textArea = new JTextArea("PER INIZIARE INSERISCI I DATI DELLA PERSONA, SELEZIONA BMR "
            + "INDICA IL TIPO DI ATTIVITA  E SUCCESIVAMENTE IL TASTO TDEE"  	);
    private Box vertical = Box.createVerticalBox();
    private Box horizontal = Box.createHorizontalBox();

    public GymCAFrame(String titolo) {
        setTitle(titolo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();

        bBMR.setPreferredSize(new Dimension(75,100));
        bReset.setPreferredSize(new Dimension(75,100));
        bTDEE.setPreferredSize(new Dimension(75,100));

        lA.setForeground(Color.WHITE);
        lP.setForeground(Color.WHITE);
        lE.setForeground(Color.WHITE);
        lS.setForeground(Color.WHITE);

        input.setLayout(new FlowLayout());
        input.add(lA);
        input.add(tA);
        input.add(lP);
        input.add(tP);
        input.add(lE);
        input.add(tE);
        input.add(lS);
        input.add(tS);

        output.setLayout(new FlowLayout());
        output.add(lR);
        output.add(tR);
        tR.setEditable(false);

        pulsanti.add(bBMR);
        pulsanti.add(bTDEE);
        pulsanti.add(bReset);

        pulsantiBase.add(horizontal,BorderLayout.CENTER);
        vertical.add(pulsanti1);
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(textArea);

        textArea.setVisible(false);
        pulsanti1.setLayout(new GridLayout(2,2,10,10));
        pulsanti1.add(bSedentario);
        pulsanti1.add(bLeggermenteAttivo);
        pulsanti1.add(bModeratamenteAttivo);
        pulsanti1.add(bMoltoAttivo);
        pulsanti1.add(bEstremamenteAttivo);
        pulsanti1.add(bInfo);


        input.setBackground(Color.blue);
        output.setBackground(Color.white);
        pulsanti.setBackground(Color.blue);

        cp.setLayout(new BorderLayout());
        cp.add(input, BorderLayout.NORTH);
        cp.add(output, BorderLayout.SOUTH);
        cp.add(vertical,BorderLayout.CENTER);
        cp.add(pulsanti, BorderLayout.EAST);



        tA.getDocument().addDocumentListener(new LeggiAltezza());
        tP.getDocument().addDocumentListener(new LeggiPeso());
        tE.getDocument().addDocumentListener(new LeggiEtà());
        tS.getDocument().addDocumentListener(new LeggiGenere());

        bBMR.addActionListener(new CalcolaBMR());
        bReset.addActionListener(new Reset());
        bTDEE.addActionListener(new CalcolaTDEE());
        Clicklistener click = new Clicklistener();
        bSedentario.addActionListener(click);
        bEstremamenteAttivo.addActionListener(click);
        bLeggermenteAttivo.addActionListener(click);
        bModeratamenteAttivo.addActionListener(click);
        bMoltoAttivo.addActionListener(click);
        bInfo.addActionListener(click);
        pack();
    }



    class LeggiAltezza implements DocumentListener  {
        public void insertUpdate(DocumentEvent e)  {
            altezza = Double.parseDouble(tA.getText());
        }

        public void removeUpdate(DocumentEvent e)  {
        }

        public void changedUpdate(DocumentEvent e)	 {
        }
    }

    class LeggiPeso implements DocumentListener  {
        public void insertUpdate(DocumentEvent e)  {
            peso = Double.parseDouble(tP.getText());
        }

        public void removeUpdate(DocumentEvent e)  {
        }

        public void changedUpdate(DocumentEvent e)	 {
        }
    }

    class LeggiEtà implements DocumentListener  {
        public void insertUpdate(DocumentEvent e) {
            età = Double.parseDouble(tE.getText());
        }

        public void removeUpdate(DocumentEvent e)  {
        }

        public void changedUpdate(DocumentEvent e)	 {
        }
    }

    class LeggiGenere implements DocumentListener  {
        public void insertUpdate(DocumentEvent e) {
            genere = tS.getText();
        }

        public void removeUpdate(DocumentEvent e)  {
        }

        public void changedUpdate(DocumentEvent e)	 {
        }
    }

    class CalcolaBMR implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BMR bmr = new BMR(altezza,peso,età,genere);
            risultato = bmr.bmrCalculator();
            tR.setText("BMR = " + risultato);
        }
    }

    class CalcolaTDEE implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(risultato != 0 && tipoAttività != null) {
                switch(tipoAttività) {
                    case "sedentario": risultato *= 1.2;
                        break;
                    case "estremamente attivo": risultato *= 2.3;
                        break;

                    //AGGIUNGERE GLI ALTRI case:
                }

                tR.setText("TDEE = " + risultato);
            }
            else
                JOptionPane.showMessageDialog(GymCAFrame.this,
                        "Devi prima calcolare il BMR e scegliere il tipo di attività!");
        }
    }

    private class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e)  {

            if (e.getSource() == bModeratamenteAttivo) {
                tipoAttività = "moderatamente attivo";
            }
            else if (e.getSource() == bLeggermenteAttivo) {
                tipoAttività = "leggermente attivo";
            }
            else if (e.getSource() == bMoltoAttivo) {
                tipoAttività = "molto attivo";
            }
            else if (e.getSource() == bEstremamenteAttivo) {
                tipoAttività = "estremamente attivo";
            }
            else if (e.getSource() == bSedentario) {
                tipoAttività = "sedentario";
            }
            else if (e.getSource() == bInfo) {
                textArea.setVisible(true);
            }

        }
    }

    class Reset implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tA.setText(null);
            tP.setText(null);
            tE.setText(null);
            tS.setText(null);
            tR.setText(null) ;
            altezza=peso=età=0;
            genere = null;
        }
    }
}
