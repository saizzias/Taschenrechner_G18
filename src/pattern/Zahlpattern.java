package pattern;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import view.View;

/**
 * Wird durch den Controller erzeugt, kriegt per Konstruktor die View übergeben.
 * 
 * 
 * @author Nico
 *
 */
public class Zahlpattern implements KeyListener{
	
	private View hauptfenster;
	
	public Zahlpattern(View view)
	{
		hauptfenster = view;
		hauptfenster.register(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String zahl1 = hauptfenster.getZahl1();
		String zahl2 = hauptfenster.getZahl2();
		
		//eingabe ungueltig für zahl1
		if((!Pattern.matches("[\\d]*", zahl1))
		|| zahl1.length() == 0)
		{
			hauptfenster.setZahl1_TF_Border_Red();
		}else{
			hauptfenster.setZahl1_TF_Border_Black();
		}

		//eingabe ungueltig für zahl2
		if((!Pattern.matches("[\\d]*", zahl2))
		|| zahl2.length() == 0)
		{
			hauptfenster.setZahl2_TF_Border_Red();
		}else{
			hauptfenster.setZahl2_TF_Border_Black();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
