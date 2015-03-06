import java.util.Arrays;
import java.math.*;
/**
 * Unit-Test für die Klasse Reihung
 * 
 * @author  Carsten Kocherscheidt
 * @version 1.00, 13.12.2014
 * @version 1.01, 19.12.2014
 * verwendete Java-Version: 1.8 unter Windows, 1.7 unter Linux (Kubuntu)
 */

public class ReihungTest
{
	public static void main (String args[])
	{
	
		System.out.println("\nTest mit 1. Konstruktor");

		Reihung myFirstRei = new Reihung (-5,5,9);
		myFirstRei.einlesen();
		
		System.out.println("\nTest mit 2. Konstruktor");
		int[] field = new int [20];
		
		for (int i = 0; i< field.length;i++) 
		{
			//field [i] = (int) ((Math.random()*Integer.MAX_VALUE)+1);
			field [i] = (int) ((Math.random()*100)+1);
		}
			
		Reihung mySecondRei = new Reihung(field);
		System.out.println(mySecondRei.toString());
		System.out.println("Sortierte Reihung: " + Arrays.toString( mySecondRei.sortierteReihung() ) );

	}//end main

}//end ReihungTest