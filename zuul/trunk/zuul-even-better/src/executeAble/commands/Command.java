package executeAble.commands;

import executeAble.ExecuteAble;

/**
 * Basisklasse f�r die Kommandos im Spiel.
 * Jeder Nutzerkommando wird als Unterklasse dieser Klasse eingebunden.
 *
 * Objekte der Klasse Command k�nnen ein optionales argument Wort beinhalten.
 * 		(ein zweites Wort das in der Commandozeile geschrieben wird)
 * 
 * Wenn das Kommando nur ein Wort hat ist das zweite Wort <null>
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public abstract class Command extends ExecuteAble
{
    /**
     * Erzeugt ein Command-Objekt. Es werden das erste und das zweite  Wort
     * unterst�tzt. Beide Worte oder das Zweite k�nnen auch <null> sein. 
     * Das Kommando Wort sollte <null> sein , um zu zeigen das es nicht vom Spiel akzeptiert wird.
     */
    public Command()
    {
        super();
    }
    
    /**
     * Wenn diese Methode ausgef�hrt wird, wird eine Hilfenachricht auf der Konsole Ausgegeben
     */
	public abstract void showSpecialHelp() ;
	
   

		
	
   
}