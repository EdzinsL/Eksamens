package a;

import javax.swing.*;
import java.awt.*;

public class SpelesGUI extends JFrame {
    private JTextField ievadesLauks = new JTextField();
    private JTextArea vesturesLauks = new JTextArea();
    private JLabel merkaEtikete = new JLabel("Galamērķis: ---");
    private JLabel sakumaEtikete = new JLabel("Sākuma valsts: ---");
    private JLabel statusaEtikete = new JLabel("Pašreizēja valsts: ---");
    private JButton celotPoga = new JButton("Ceļot");
    private Valstusp spele;

    public SpelesGUI() {
    	// krāsu definēšana
    	Color tumssFons = new Color(30, 30, 30);
    	Color laukuFons = new Color(45, 45, 45);
    	Color gaissTeksts = new Color(220, 220, 220);
    	getContentPane().setBackground(tumssFons);
    	
        // Loga parametri
        setTitle("Ceļojuma Plānotājs Eiropā");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Informācija par šis spēles vallstīm augšā
        JPanel augsasPanelis = new JPanel(new GridLayout(3, 1));
        augsasPanelis.setBackground(tumssFons);
        augsasPanelis.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        merkaEtikete.setForeground(Color.GREEN);
        merkaEtikete.setHorizontalAlignment(JLabel.CENTER);
        merkaEtikete.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        sakumaEtikete.setForeground(Color.CYAN);
        sakumaEtikete.setHorizontalAlignment(JLabel.CENTER);
        sakumaEtikete.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        statusaEtikete.setForeground(Color.ORANGE);
        statusaEtikete.setHorizontalAlignment(JLabel.CENTER);
        statusaEtikete.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        augsasPanelis.add(merkaEtikete);
        augsasPanelis.add(sakumaEtikete);
        augsasPanelis.add(statusaEtikete);
        add(augsasPanelis, BorderLayout.NORTH);

        // Lietotāja mēģinājumu vēsture pa vidu
        vesturesLauks.setEditable(false);
        vesturesLauks.setBackground(laukuFons);
        vesturesLauks.setForeground(gaissTeksts);
        vesturesLauks.setCaretColor(Color.WHITE);
        vesturesLauks.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane ritjosla = new JScrollPane(vesturesLauks);
        ritjosla.setBorder(BorderFactory.createLineBorder(tumssFons, 2)); 
        add(ritjosla, BorderLayout.CENTER);

        // Valsts ievades lauks apakšā
        JLabel instrukcijasEtikete = new JLabel("Ievadiet kaimiņvalsti:");
        instrukcijasEtikete.setFont(new Font("SansSerif", Font.BOLD, 13));
        instrukcijasEtikete.setForeground(gaissTeksts);
        JPanel apaksasPanelis = new JPanel(new BorderLayout(2, 2));
        apaksasPanelis.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        apaksasPanelis.setBackground(tumssFons);
        apaksasPanelis.add(instrukcijasEtikete, BorderLayout.NORTH);
        apaksasPanelis.add(ievadesLauks, BorderLayout.CENTER);
        apaksasPanelis.add(celotPoga, BorderLayout.EAST);
        add(apaksasPanelis, BorderLayout.SOUTH);
        
        // Ievades laukuma noformējums
        ievadesLauks.setBackground(laukuFons);
        ievadesLauks.setForeground(Color.WHITE);
        ievadesLauks.setCaretColor(Color.WHITE);
        ievadesLauks.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Pogas noformējums
        celotPoga.setBackground(new Color(70, 70, 70));
        celotPoga.setForeground(Color.BLACK);

        // Loga centralizācija
        setLocationRelativeTo(null);
        setVisible(true);
        
        spele = new Valstusp();
        iestatitMerki(spele.getMerkis());
        iestatitSakumu(spele.getPasreizeja());
        iestatitStatusu(spele.getPasreizeja());
        iegutCelotPogu().addActionListener(e -> {
            String ievade = iegutIevadi().trim();
            if (ievade.isEmpty()) return;
            String rezultats = spele.apstradatIevadi(ievade);
            pievienotVesturei(ievade + " — " + rezultats);
            iestatitStatusu(spele.getPasreizeja());
            notiritIevadi();
        });
        
    }

    // Logika, ko var piesaistīt
    public void iestatitMerki(String merkis) {
        merkaEtikete.setText("Galamērķis: " + merkis);
    }
    
    public void iestatitSakumu(String sakums) {
        sakumaEtikete.setText("Sākuma valsts: " + sakums);
    }

    public void iestatitStatusu(String pasreizeja) {
        statusaEtikete.setText("Pašreizējā valsts: " + pasreizeja);
    }

    public void pievienotVesturei(String teksts) {
        vesturesLauks.append("-> " + teksts + "\n");
    }

    public String iegutIevadi() {
        return ievadesLauks.getText();
    }

    public void notiritIevadi() {
        ievadesLauks.setText("");
    }

    public JButton iegutCelotPogu() {
        return celotPoga;
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } 
        catch (Exception e) { e.printStackTrace(); }
        
        new SpelesGUI();
    }

}
