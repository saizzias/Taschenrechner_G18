package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pattern.Zahlpattern;

import service.Taschenrechner_Service;
import view.Hauptfenster;
import view.View;

/**
 * Die zu startende Klasse
 * Erzeugt das Fenster und einen Service der die Logik beinhaltet
 * 
 * Diese Klasse ist selbst ein ActionListener.
 * Die Komponenten auf der GUI müssen mit der Methode register() für diesen Controller
 * registriert werden.
 * Führt dementsprechend die Anweisungen auf der GUI aus.
 * 
 * @author Nico
 *
 */
public class Controller implements ActionListener{
	
	private View hauptfenster;
	private Taschenrechner_Service service;
	private Zahlpattern pattern;
	
	public Controller()
	{
		hauptfenster = new Hauptfenster();
		hauptfenster.register(this);
		
		pattern = new Zahlpattern(hauptfenster);
		
		service = new Taschenrechner_Service();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {		
		JButton button = (JButton) e.getSource();
		String aktion = button.getName();
		
		if(aktion.compareTo("plus") == 0)
		{
			hauptfenster.setze_ergebnis(service.addieren(hauptfenster.getZahl1(), hauptfenster.getZahl2()));
		}
		else if(aktion.compareTo("minus") == 0)
		{
			hauptfenster.setze_ergebnis(service.subtrahieren(hauptfenster.getZahl1(), hauptfenster.getZahl2()));
		}
		else if(aktion.compareTo("multiplizieren") == 0)
		{
			hauptfenster.setze_ergebnis(service.multiplizieren(hauptfenster.getZahl1(), hauptfenster.getZahl2()));
		}
		else if(aktion.compareTo("dividieren") == 0)
		{
			hauptfenster.setze_ergebnis(service.dividieren(hauptfenster.getZahl1(), hauptfenster.getZahl2()));
		}
		else if(aktion.compareTo("zuruecksetzen") == 0)
		{
			hauptfenster.loesche_felder();
		}
	}

}
