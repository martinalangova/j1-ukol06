package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JTextField husyField;
    private JLabel kraliciLabel;
    private JTextField kraliciField;

    private JButton vypocitatButton;

    private JLabel pocetHlavLabel;
    private JTextField pocetHlavField;
    private JLabel pocetNohouLabel;
    private JTextField pocetNohouField;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání


        husyLabel=new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husyField = new JTextField();
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        kraliciLabel= new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField= new JTextField();
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton= new JButton("Vypočítat");
        getRootPane().setDefaultButton(vypocitatButton);
        add(vypocitatButton, "span, center");
        vypocitatButton.addActionListener(this::vypocitejButton);

        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavField= new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouLabel=new JLabel("Počet nohou");
        pocetNohouField=new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        pocetNohouLabel.setLabelFor(pocetHlavField);
        add(pocetNohouLabel);
        add(pocetNohouField);


        pack();

    }

    private void vypocitejButton(ActionEvent actionEvent) {
        int pocetHlavKraliku=Integer.parseInt(kraliciField.getText());
        int pocetHlavHus=Integer.parseInt(husyField.getText());

        int pocetHlav=pocetHlavHus+pocetHlavKraliku;
        int pocetNohou=pocetHlavHus*2+pocetHlavKraliku*4;

        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNohou));
    }

}
