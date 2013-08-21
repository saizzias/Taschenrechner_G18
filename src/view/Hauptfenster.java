package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

public class Hauptfenster extends View {

	private JPanel panel;
	private JButton plus;
	private JButton minus;
	private JButton multiplizieren;
	private JButton dividieren;
	private JButton zuruecksetzen;
	private JLabel zahl1_L;
	private JLabel zahl2_L;
	private JLabel ergebnis_L;
	private JTextField zahl1_TF;
	private JTextField zahl2_TF;
	private JTextField ergebnis_TF;
	private SpringLayout layout;

	public Hauptfenster() {

		initAttribute();
		erzeugeLayout();


		frame.add(panel);
		frame.setTitle("Taschenrechner");
		frame.setSize(500, 300);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.repaint();
		frame.validate();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initAttribute() {
		// Erzeugen der Komponenten
		panel = new JPanel();
		plus = new JButton();
		minus = new JButton();
		multiplizieren = new JButton();
		dividieren = new JButton();
		zuruecksetzen = new JButton();
		zahl1_TF = new JTextField();
		zahl2_TF = new JTextField();
		ergebnis_TF = new JTextField();
		zahl1_L = new JLabel();
		zahl2_L = new JLabel();
		ergebnis_L = new JLabel();

		// Werte der Komponenten festlegen
		//Buttons
		plus.setText("+");
		plus.setName("plus");
		minus.setText("-");
		minus.setName("minus");
		multiplizieren.setText("*");
		multiplizieren.setName("multiplizieren");
		dividieren.setText("/");
		dividieren.setName("dividieren");
		zuruecksetzen.setText("Zurücksetzen");
		zuruecksetzen.setName("zuruecksetzen");
		
		//Textfelder und Labels
		zahl1_L.setText("Erste Zahl :");
		zahl2_L.setText("Zweite Zahl:");
		ergebnis_L.setText("Ergebnis:");
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		zahl1_TF.setBorder(border);
		zahl2_TF.setBorder(border);
		ergebnis_TF.setBorder(border);
		
		zahl1_TF.setMinimumSize(new Dimension(100, 20 ));
		zahl1_TF.setPreferredSize(new Dimension(100, 20 ));
		zahl2_TF.setMinimumSize(new Dimension(100, 20 ));
		zahl2_TF.setPreferredSize(new Dimension(100, 20 ));
		ergebnis_TF.setMinimumSize(new Dimension(100, 20 ));
		ergebnis_TF.setPreferredSize(new Dimension(100, 20 ));
		ergebnis_TF.setEditable(false);
	}

	private void erzeugeLayout() {
		layout = new SpringLayout();

		// Setzen des Layouts für das Panel
		panel.setLayout(layout);
		// Dem Panel die Komponenten hinzufügen
		panel.add(zahl1_L);
		panel.add(zahl1_TF);
		panel.add(zahl2_L);
		panel.add(zahl2_TF);
		panel.add(ergebnis_L);
		panel.add(ergebnis_TF);
		panel.add(plus);
		panel.add(minus);
		panel.add(multiplizieren);
		panel.add(dividieren);
		panel.add(zuruecksetzen);
										

		// Dem Layout die Komponenten hinzufügen (Zeilenweise)
		// Erste Zeile
		layout.putConstraint(SpringLayout.NORTH, zahl1_L,  10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST,  zahl1_L,  10, SpringLayout.WEST,  panel);
		
		layout.putConstraint(SpringLayout.NORTH, zahl1_TF, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST,  zahl1_TF, 10, SpringLayout.EAST,  zahl1_L);

		// Zweite Zeile
		layout.putConstraint(SpringLayout.NORTH, zahl2_L,  10, SpringLayout.SOUTH, zahl1_L);
		layout.putConstraint(SpringLayout.WEST,  zahl2_L,  10, SpringLayout.WEST,  panel);
		
		layout.putConstraint(SpringLayout.NORTH, zahl2_TF, 10, SpringLayout.SOUTH, zahl1_L);
		layout.putConstraint(SpringLayout.WEST,  zahl2_TF,  0, SpringLayout.WEST,  zahl1_TF);
		
		// Dritte Zeile
		layout.putConstraint(SpringLayout.NORTH, ergebnis_L,  15, SpringLayout.SOUTH, zahl2_L);
		layout.putConstraint(SpringLayout.WEST,  ergebnis_L,  10, SpringLayout.WEST,  panel);
		
		layout.putConstraint(SpringLayout.NORTH, ergebnis_TF, 15, SpringLayout.SOUTH, zahl2_L);
		layout.putConstraint(SpringLayout.WEST,  ergebnis_TF,  0, SpringLayout.WEST,  zahl1_TF);
		
		// Vierte Zeile - Buttons
		layout.putConstraint(SpringLayout.NORTH, plus, 30, SpringLayout.SOUTH, ergebnis_L);
		layout.putConstraint(SpringLayout.WEST,  plus, 10, SpringLayout.WEST,  panel);
		
		layout.putConstraint(SpringLayout.NORTH, minus, 0, SpringLayout.NORTH, plus);
		layout.putConstraint(SpringLayout.WEST,  minus, 10, SpringLayout.EAST,  plus);
		
		layout.putConstraint(SpringLayout.NORTH, multiplizieren,  0, SpringLayout.NORTH, plus);
		layout.putConstraint(SpringLayout.WEST,  multiplizieren, 10, SpringLayout.EAST,  minus);
		
		layout.putConstraint(SpringLayout.NORTH, dividieren,  0, SpringLayout.NORTH, plus);
		layout.putConstraint(SpringLayout.WEST,  dividieren,  10, SpringLayout.EAST,  multiplizieren);
		
		// Fünfte Zeile
		layout.putConstraint(SpringLayout.NORTH, zuruecksetzen, 30, SpringLayout.SOUTH, plus);
		layout.putConstraint(SpringLayout.WEST,  zuruecksetzen, 10, SpringLayout.WEST,  panel);
	}

	@Override
	public void register(ActionListener al) {
		for (int i = 0; i < panel.getComponentCount(); ++i) {
			if (panel.getComponent(i).getClass() == JButton.class) {
				JButton button = (JButton) panel.getComponent(i);
				button.addActionListener(al);
			}
		}
	}
	
	@Override
	public void register(KeyListener kl)
	{
		for (int i = 0; i < panel.getComponentCount(); ++i) {
			if (panel.getComponent(i).getClass() == JTextField.class) {
				JTextField textField = (JTextField) panel.getComponent(i);
				textField.addKeyListener(kl);
			}
		}
	}
	
	@Override
	public String getZahl1()
	{
		return zahl1_TF.getText();
	}
	
	@Override
	public String getZahl2()
	{
		return zahl2_TF.getText();
	}
	
	@Override
	public void setze_ergebnis(double ergebnis)
	{
		ergebnis_TF.setText("" + ergebnis);
	}
	
	@Override
	public void loesche_felder()
	{
		zahl1_TF.setText("");
		zahl2_TF.setText("");
		ergebnis_TF.setText("");
	}

	@Override
	public void setZahl1_TF_Border_Black()
	{
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		zahl1_TF.setBorder(border);
	}
	
	@Override
	public void setZahl1_TF_Border_Red()
	{
		Border border = BorderFactory.createLineBorder(Color.RED);
		zahl1_TF.setBorder(border);
	}
	
	@Override
	public void setZahl2_TF_Border_Black()
	{
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		zahl2_TF.setBorder(border);
	}
	
	@Override
	public void setZahl2_TF_Border_Red()
	{
		Border border = BorderFactory.createLineBorder(Color.RED);
		zahl2_TF.setBorder(border);
	}
}