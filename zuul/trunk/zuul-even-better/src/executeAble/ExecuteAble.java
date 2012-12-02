package executeAble;

import zuulCore.Player;
import gameEnums.GameStatus;

/**
 * Basisklasse f�r die Dinge im Spiel die vom Spieler Ausgel�st werden k�nnen
 *
 * Objekte der Klasse ExecuteAble k�nnen zwei optionale argument Woerter beinhalten.
 * 		
 * 
 * Wenn die Argumentwoerter nicht Vorhanden sind sind sie <null>
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public abstract class ExecuteAble
{
    private String secondWord;
	private String thirdWord;

    /**
     * Erzeugt ein executeAble-Objekt. Es werden zwei optionale argument Woerter 
     * unterst�tzt. Beide Worte  k�nnen auch <null> sein. 
     */
    public ExecuteAble()
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
     * Definiert das erste  Wort des ExecuteAbles (das Wort
     * das nach dem Kommando Wort steht)
     * Null zeigt das es kein zweites Wort gibt
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }
    /**
     * Definiert das dritte  Wort des ExecuteAbles (das Wort
     * das nach dem Kommando Wort steht)
     * Null zeigt das es kein drittes Wort gibt
     */
    public void setThirdWord(String thirdWord) {
    	this.thirdWord = thirdWord;
    }
    /**
     * Gibt das zweite Wort zur�ck. 
     * Wenn es kein zweites Wort gibt gibt es <null> zur�ck
     */
	    public String getSecondWord()
    {
        return secondWord;
    }

	/**
    * Gibt das dritte Wort zur�ck. 
	* Wenn es kein zweites Wort gibt gibt es <null> zur�ck
	*/
	public String getThirdWord()
	{
	       return thirdWord;
	 }
	    
    /**
     * �berpr�ft ob das ExecuteAble ein zweites  Wort hat
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
    
    /**
     * �berpr�ft ob das Executeable ein drittes  Wort hat
     */
    public boolean hasThirdWord()
    {
        return secondWord != null;
    }

		
	
   
}