package commands;

import de.fh_zwickau.oose.zuul.Player;
import GamePlayEnums.GameStatus;

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

    /**
     * Erzeugt ein Command-Objekt. Es werden das erste und das zweite  Wort
     * unterst�tzt. Beide Worte oder das Zweite k�nnen auch <null> sei. 
     * Das Kommando wort sollte <null> sein , um zu zeigen das es nicht vom spiel akzeptiert wird.
     */
    public Command()
    {
        secondWord = null;
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
     * Gibt das zweite Wort zur�ck. 
     * Wenn es kein zweites Kommandowort gibt gibt es <null> zur�ck
     */
	    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * �berpr�ft ob das Kommando ein zweites  Wort hat
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
   
}