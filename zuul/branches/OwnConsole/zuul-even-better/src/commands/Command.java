package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

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

public abstract class Command
{
    private String secondWord;
	private String thirdWord;

    /**
     * Erzeugt ein Command-Objekt. Es werden das erste und das zweite  Wort
     * unterst�tzt. Beide Worte oder das Zweite k�nnen auch <null> sein. 
     * Das Kommando wort sollte <null> sein , um zu zeigen das es nicht vom spiel akzeptiert wird.
     */
    public Command()
    {
        secondWord = null;
        thirdWord= null;
    }

    /**
     * wenn diese Methode ausgef�hrt wird wird der Gamestatus zur�ckgegeben.
     * 
     * @return {@link GameStatus}, RUN wenn das Spiel weiterlaufen soll, STOP wenn das Spiel beendet werden soll
     * und RESTART wenn das Spiel neu gestartet und Initialisiert werden soll.
     */  
    public abstract GameStatus execute(Player player);
    
    /**
     * Wenn diese Methode ausgef�hrt wird, wird eine Hilfenachricht auf der Konsole Ausgegeben
     */
	public abstract void showSpecialHelp() ;
	
    /**
     * Definiert das zweite  Wort des Kommandos (das Wort
     * das nach dem Kommando wort steht)
     * Null zeigt das es kein zweites Wort gibt
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }
    /**
     * Definiert das dritte  Wort des Kommandos (das Wort
     * das nach dem Kommando wort steht)
     * Null zeigt das es kein drittes Wort gibt
     */
    public void setThirdWord(String thirdWord) {
    	this.thirdWord = thirdWord;
    }
    /**
     * Gibt das zweite Wort zur�ck. 
     * Wenn es kein zweites Kommandowort gibt gibt es <null> zur�ck
     */
	    public String getSecondWord()
    {
        return secondWord;
    }

	/**
    * Gibt das zweite Wort zur�ck. 
	* Wenn es kein zweites Kommandowort gibt gibt es <null> zur�ck
	*/
	public String getThirdWord()
	{
	       return thirdWord;
	 }
	    
    /**
     * �berpr�ft ob das Kommando ein zweites  Wort hat
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
    
    /**
     * �berpr�ft ob das Kommando ein drittes  Wort hat
     */
    public boolean hasThirdWord()
    {
        return secondWord != null;
    }

		
	
   
}