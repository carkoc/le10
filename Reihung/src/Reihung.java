import java.util.Arrays;
import java.util.Scanner;

/**
 * Klasse zum Erzeugen von Arrays
 * 
 * @author  Carsten Kocherscheidt
 * @version 1.00, 13.12.2014
 * @version 1.01, 19.12.2014
 * verwendete Java-Version: 1.8 unter Windows, 1.7 unter Linux (Kubuntu)
 */
 
 public class Reihung
 {
	private int[] reihung;
	private int untereGrenze;
	private int obereGrenze;
	private int maximaleAnzahl;
	private int Anzahl_korrekteEingaben = 0;
	private int Anzahl_falscheEingaben = 0;
	
	//1. Konstruktor
	/**
	 * Anhand der Übergabeparameter werden die Eigenschaften der Reihung, 
	 * die später über Tastatureingaben gefüllt wird, festgelegt.
	 * @param untereGrenze
	 * @param obereGrenze
	 * @param maximaleAnzahl
	 */
	public Reihung(int untereGrenze, int obereGrenze, int maximaleAnzahl)
	{
		this.untereGrenze	 = untereGrenze;
		this.obereGrenze	 = obereGrenze;
		this.maximaleAnzahl	 = maximaleAnzahl;

		reihung = new int[maximaleAnzahl];
		
	}//end 1. Konstruktor
	
	//2. Konstruktor
	/**
	 * Dem Programm wird die zu benutzende Reihung als Parameter übergeben. 
	 * Die Werte für untereGrenze, obereGrenze und maximaleAnzahl sind aus der 
	 * übergebenen Reihung zu ermitteln.
	 * @param reihung
	 */
	public Reihung(int [] reihung)
	{
		this.reihung 	    = reihung;
		this.untereGrenze   = this.getMin();
		this.obereGrenze	= this.getMax();
		this.maximaleAnzahl = reihung.length;
	}//end 2. Konstruktor
	
	/** 
	 * Ermöglicht das Einlesen der Zahlen für die Reihung über die Tastatur von der Konsole. 
	 * Die Eingabe der Zahl Null beendet das Einlesen. 
	 * Nach der Eingabe einer Zahl soll eine Mitteilung am Bildschirm erscheinen, ob die Eingabe korrekt war oder nicht, 
	 * d. h. im Bereich zwischen untereGrenze und obereGrenze lag. 
	 * Die Anzahl der korrekten und der falschen Eingaben werden am Bildschirm ausgegeben. 
	 * Die korrekten Zahlen sind in einer Reihung zu speichern.
	 */
	public void einlesen()
	{
		int anzahl_eingaben = 0;
		int i = 0; //Schleifenzähler
		
		Scanner in = new Scanner(System.in); //CK
		do {
    		int eingabe;
			System.out.print("Geben Sie eine Zahl zwischen " + this.untereGrenze 
    						 + " und " + this.obereGrenze
    						 + " inklusive ein (0 zum Beenden): " );
    		eingabe = in.nextInt();
    		anzahl_eingaben++;
    		
    		if (0 == eingabe) break;
    		
    		if (    (eingabe >= this.untereGrenze) && (eingabe <= this.obereGrenze) )
    		{
    			Anzahl_korrekteEingaben++;
    			reihung[i] = eingabe;
    			i++;
    		}
    		else 
    		{
    			Anzahl_falscheEingaben++;
    		}
    		
    	} while (anzahl_eingaben < maximaleAnzahl); 
		
		//kopieren den gültigen elemente in ein neues, evtl. kürzeres Array
		int [] aValidInputs = Arrays.copyOf(reihung, Anzahl_korrekteEingaben);
		reihung = Arrays.copyOf(aValidInputs, Anzahl_korrekteEingaben);
   
    	in.close(); //Scanner wieder vernichten, damit kein leak bleibt!!!
		
    	System.out.println (  this.toString()  );

    	//Ausgabe der sortierten Reihung
    	System.out.println("Sortierte Reihung:  " + Arrays.toString(this.sortierteReihung()) );
    	
    	System.out.println("Anzahl der korrekten Eingaben: " + Anzahl_korrekteEingaben);
    	System.out.println("Summe der korrekten Eingaben:  " + berechneSumme() );
    	System.out.println("Anzahl Fehleingaben:           " + Anzahl_falscheEingaben);
       	   	
	}//end einlesen
	
	
	/**
	 * Gibt den kleinsten Wert der Reihung zurück. 
	 * @return int
	 */
	
	public int getMin()
	{
		int min = reihung[0]; //1. Wert als vorlaeufiges Minimum merken
		
		//ab dem 1. Element dann pruefen
		//TODO: pruefen, ob ueberhaupt Elemente vorhanden sind?
		for (int i=1;i<reihung.length;i++)
		{
			if (reihung[i] < min) min = reihung[i];
		}
		return min;
	}//end getMin
	
	
	/**
	 * Gibt den größten Wert der Reihung zurück.
	 * @return int
	 */
	
	public int getMax()
	{
		int max = reihung[0]; //1. Wert als vorlaeufiges Minimum merken
		
		//ab dem 1. Element dann pruefen
		//TODO: pruefen, ob ueberhaupt Elemente vorhanden sind?
		for (int i=1;i<reihung.length;i++)
		{
			if (reihung[i] > max) max = reihung[i];
		}
		return max;	
	}
	
	/**
	 * Berechnet die Summe der Werte der Reihung und gibt diese zurück.
	 * @return
	 */
	public int berechneSumme()
	{
		int summe = 0;
		
		for (int i=0;i<reihung.length;i++) summe += reihung[i];
	
		return summe;
	}
	
	/**
	 * Erstellt eine sortierte Kopie der Reihung und gibt sie zurück. 
	 * Die originale Reihung bleibt dabei unverändert.
	 * @return
	 */
	public int[] sortierteReihung()
	{
		int[] sortiert = reihung;
		//TODO: sortieren...
		for (int i=1;i<(sortiert.length);i++)
		{
			int j = i;
			int temp = sortiert[i];
			while ((j>0) && (temp < sortiert[j-1]))
			{
				sortiert[j] = sortiert[j-1];
				j--;
			}
			sortiert[j] = temp;
		}
		return sortiert;
	
	}
	

	/**
	 * 	Gibt eine Zeichenkettendarstellung für die untere Grenze, 
	 * die obere Grenze und die Zahlen der Reihung als String zurück.
	 */
	public String toString()
	{
		return (   "\nUntere erlaubte Grenze: " + this.untereGrenze 
				 + "\nObere erlaubte Grenze:  " + this.obereGrenze 
				 + "\nZahlen der Reihung: " + Arrays.toString(reihung)
			   );
	}
 
 } //end class Reihung
 