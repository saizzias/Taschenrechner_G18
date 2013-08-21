package service;

public class Taschenrechner_Service {
	
	public double addieren(String zahl_1, String zahl_2)
	{
		double ergebnis;
		double zahl1 = Double.parseDouble(zahl_1);
		double zahl2 = Double.parseDouble(zahl_2);
		
		ergebnis = zahl1 + zahl2;
		
		return ergebnis;
	}
	
	public double subtrahieren(String zahl_1, String zahl_2)
	{
		double ergebnis;
		double zahl1 = Double.parseDouble(zahl_1);
		double zahl2 = Double.parseDouble(zahl_2);
		
		ergebnis = zahl1 - zahl2;
		
		return ergebnis;
	}
	
	public double multiplizieren(String zahl_1, String zahl_2)
	{
		double ergebnis;
		double zahl1 = Double.parseDouble(zahl_1);
		double zahl2 = Double.parseDouble(zahl_2);
		
		ergebnis = zahl1 * zahl2;
		
		return ergebnis;
	}
	
	public double dividieren(String zahl_1, String zahl_2)
	{
		double ergebnis;
		double zahl1 = Double.parseDouble(zahl_1);
		double zahl2 = Double.parseDouble(zahl_2);
		
		ergebnis = zahl1 / zahl2;
		
		return ergebnis;
	}
}
