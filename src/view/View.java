package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public abstract class View {

	JFrame frame = new JFrame();
	
	//Für normale JButtons, JRadio etc.
	public void register(ActionListener al)
	{}
	
	//Für Textfelder, Eingaben jeglicher Art
	public void register(KeyListener kl)
	{}
	
	public void setZahl1_TF_Border_Black()
	{}
	
	public void setZahl1_TF_Border_Red(){}
	
	public void setZahl2_TF_Border_Black(){}
	
	public void setZahl2_TF_Border_Red(){}
	
	public String getZahl1()
	{
		return null;
	}
	
	public String getZahl2()
	{
		return null;
	}
	
	public void setze_ergebnis(double ergebnis)
	{
	}
	
	public void loesche_felder()
	{
		
	}
}
