package de.fh_zwickau.oose.zuul;

import GamePlayEnums.GameStatus;

/**
 * Diese Klasse ist die abstrakte Superklasse für alle Kommandos im Spiel.
 * jedes Nutzerkommando wird als spezielle Subklasse dieser Klasse eingebunden.
 *
 * Objekte der Klasse Command können ein optionales argument Wort beinhalten.
 * (ein zweites Wort das in der Commandozeile geschrieben wird.
 * Wenn das Kommando nur ein Wort hat ist das zweite Wort <null>
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public abstract class Command
{
    private String secondWord;

    /**
     * Erzeugt ein kommando Object, es werden das erste und das zweite  Wort
     * unterstützt, aber beide oder eins können auch <null> sei. Das Kommando wort sollte 
     * <null> sein , um zu zeigen das es nicht vom spiel akzeptiert wird.
     * 
     */
    public Command()
    {
        secondWord = null;
    }

    /**
     * Gibt das zweite Wort zurück. Wenn es
     * kein zweites Kommandowort gibt gibt es <null> zurück
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * überprüft ob das Kommando ein zweites  Wort hat
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

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
     * wenn diese Methode ausgeführt wird wird der Gamestatus zurückgegeben.
     * 
     * @return {@link GameStatus}, RUN wenn das Spiel weiterlaufen soll, STOP wenn das Spiel beendet werden soll
     * und RESTART wenn das Spiel neu gestartet und Initialisiert werden soll.
     */
   
    public abstract GameStatus execute(Player player);
    
    /**
     * Wenn diese Methode ausgeführt wird wird eine Spezielle Hilfenachricht auf die Konsole Ausgegeben
     */

	public abstract void showSpecialHelp() ;
    

}

