import de.vfh.gp1.bib.Konsole;
import java.util.Arrays;

/**
 * Klasse zum Erzeugen  eines Array 
 * Die klasse enhaelt folgende methoden
 *  einlesen       Die Zahlen die der Bedieer ausgibt und die Ober/untergrenze	
 * 
 * @author Regina Witte
 * @version 7.0710.14      05.01.2015
 
 */

 public class Reihung1 
 {
   // Instanzvariablen
   int untereGrenze;
   int obereGrenze;
   int maximaleAnzahl;
   /* Vereinbarung einer inneren Klasse als Ausnahmeklasse abgeleitet von Exception*/
   static class FalscheGrenzenEingegeben extends Exception 
  {
	public FalscheGrenzenEingegeben (String s)
    { 
      super (s);
	} // ende FalscheGrenzenEingegeben
   }  // ende static class 
   private int[] meinArray;   // deklaration Array  Speicherplatz fuer eine Referenz wird bereitgestellt
    /* Vereinbarung eines Konstruktors den man braucht fuer ?????*/
   public Reihung1(int untereGrenze, int obereGrenze,int maximaleAnzahl)
   {
     this.untereGrenze=untereGrenze;
	 this.obereGrenze=obereGrenze;
	 this.maximaleAnzahl=maximaleAnzahl;
    }  // ende Konstruktor

   // Array vom Variablentyp int mit der uebergeben Laenge
        // erstellen
   public Reihung1(int laenge)
   {
     meinArray = new int[laenge];
   }
 /**
 * Die methoder erzeugt ein Objekt IllegalArgumentException
 * wenn der eingegebene Wert fuer obere Grenze kleiner als untere Grenze ist Die Klasse wirft die Exception
 * Der Try /catch erfolgt in dem aufufendem Programm Reihung1Start
 * Die Methode liest die Grenzen und alle Zahlen des Arrays ein
 */	   
   public void einlesen()	throws IllegalArgumentException
   {
    int zahl=0;
	char eingabe=' ';
	int untereGrenze=0;
    int obereGrenze=0;
    int maximaleAnzahl=0;
	int falscheEingabe=0;            // zaehlen falsche Bedienereingaben 
	int richtigeEingabe=0;           // zahelen richtge Bedienreingaben
	eingabe =Konsole.getInputChar("\nSollen die Ober und Untergenzen automatisch erzeugt werden dann bitte a eingeben" );
	if (eingabe== 'a')
	{
     untereGrenze =1;
	 obereGrenze =10;
     maximaleAnzahl =8;
	 System.out.print("\n untere Grenze ist  "+ untereGrenze);
	 System.out.print("\n obere Grenze ist "+ obereGrenze);
	 System.out.print("\nSie duerfen maximal "+ maximaleAnzahl+" Zahlen eingeben");
    }	  	
    else
    {
	 untereGrenze =Konsole.getInputInt("\nGeben Sie bitte die untere Grenze ein" );
     obereGrenze =Konsole.getInputInt("\nGeben Sie bitte die obere Grenzee" );
     maximaleAnzahl =Konsole.getInputInt("\nGeben Sie bitte die MaximalAnzahl nein" );
     System.out.print("\n untere Grenze ist  "+ untereGrenze);
	 System.out.print("\n obere Grenze ist "+ obereGrenze);
    /**
    * erzeugt ein Objekt IllegalArgumentException
    * wenn der uebergebe Kilometerstand kleiner 0 Die Klasse wirft die Exception 
    * Der Try /catch erfolgt in dem aufufendem Programm EergaenztesAutoTest
    * 
    */	
    if (obereGrenze<untereGrenze)
	 {
	  throw new IllegalArgumentException( "\nIllegalArgumentException                        "
	                                     + "\nuntere Grenze ist geoesser als obere Grenze!!Fehler in Klasse: "
	                                     + this.getClass().getName()+ toString()); // Uebergabe der Klasse und Datensatz
     }  // end if  this.kmStand < 0
	   System.out.print("\nSie duerfen maximal "+ maximaleAnzahl+" Zahlen eingeben");
      }	 // ende else 	

	  	
    //Array mit Werten fuellen
    for (int i = 0; i < meinArray.length; i++)
	{
     do
	 {
	  zahl =Konsole.getInputInt("\nGeben Sie bitte eine Zahl zwischen " + untereGrenze +" und " + obereGrenze 
	                               +" ein: 0 fuer Ende"); 
	  if (zahl== 0)     // ende der Eingabe raus aus dp
	  break;
	  if ((zahl<untereGrenze) || (zahl>obereGrenze))  
      {			 
		System.out.print("\nZahl liegt ausserhalb der Grenzen von "+  untereGrenze +" und" 
		+ obereGrenze+"bitte neu eingeben");
		falscheEingabe++;
      }
	 } while ((zahl<untereGrenze) || (zahl>obereGrenze));
          
	 if (zahl== 0)
	 {	
 	    break;
	 }
	 richtigeEingabe++;
	 meinArray[i]=zahl;
	 
     } // ende for
	   	  System.out.print("\n Sie haben "+richtigeEingabe +" richtige Zahlen eingegeben");	
	  System.out.print("\n Sie haben "+falscheEingabe +" Zahlen falsch eingegeben ");	
     } // ende methode einlesen 	   
 /**
 *  methode getMin ermittelt den kleinsten wert im Array
 */

   public void getMin()	
   {
	 int kleinsteZahl=meinArray[0];
	 for (int i = 0; i < meinArray.length; i++)
	 {
      if (meinArray[i]< kleinsteZahl) 
		  kleinsteZahl=  meinArray[i];  
	 }
	  System.out.print("\n  kleinstee Zahl im Array "+ kleinsteZahl);
   }// ende get min 
 /**
 *  methode getMax ermittelt den groessten Wert im Array
 */
   public void getMax()	
   {
	int groessteZahl=0;
	for (int i = 0; i < meinArray.length; i++)
	 {
      if (meinArray[i] > groessteZahl) 
		  groessteZahl=  meinArray[i];  
	 }
	  System.out.print("\n  greosste Zahl im Array "+ groessteZahl);
 	}// ende getMax  
 /**
 *  methode berechnenSumme ermittelt die Summe aller Zahlen im Array
 */
   public void berechneSumme()	
   {
	int summe=0;
	for (int i = 0; i < meinArray.length; i++)
	 {
      summe=summe + meinArray[i];  

	 }
	  System.out.print("\nSumme "+ summe);
 	}// ende berechneSumme  
	/**
 *  methode sortiere kopie   liest das array ein und gibt eine sortierte KOpie zurueck
 */
   public void sortiereReihung()	
   {
    int [] sortiertesArray=meinArray.clone();
	int ende=0;
	int zwiFeld=0;
	 //  Beginn bubblesort 
    	
	do	
     {	
		ende =0;                     // zu Beginn des Vergleiches Ende auf null
	 for (int i=0; i<sortiertesArray.length-1;i++)               // tab von 0 bis 4  
	 {
		
		   if 	(sortiertesArray[i]>sortiertesArray[i+1])
		    {
				zwiFeld = sortiertesArray[i];           //jetzt  getausche
				sortiertesArray[i]=sortiertesArray[i+1];
				sortiertesArray[i+1]=zwiFeld;
				
				ende=1;
		    } // end if
			
	 }  //  end for
	}   while (ende!=0);
	// ende do
   System.out.println("\narray nach sort  " + Arrays.toString(sortiertesArray));
 	}// ende sortierArray
  
  public String toString() 
	{
        return "\nArray unsortiert" +Arrays.toString(meinArray);
		  
     } //Ende String toString	
 } //ende Reihung1   
   
  
	
        
    
   
   
