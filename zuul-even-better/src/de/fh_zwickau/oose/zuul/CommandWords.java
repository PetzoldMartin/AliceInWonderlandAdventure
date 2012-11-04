package de.fh_zwickau.oose.zuul;
import java.util.HashMap;
import java.util.Iterator;

import commands.GoCommand;
import commands.HelpCommand;
import commands.QuitCommand;
import commands.RestartCommand;

/**
 * 
 * Diese Klasse enthält eine Sammlung von allen Kommando Wörtern die das Spiel kennt.
 * Es nutzt die erstelten Kommandos um zu erkennen wie diese aufgerufen werden.
 *
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class CommandWords
{
    private HashMap<String, Command> commands;

    /**
     * Konstruktor der die Kommandos initialisiert
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("geh", new GoCommand());
        commands.put("hilfe", new HelpCommand(this));
        commands.put("?", new HelpCommand(this));
        commands.put("ende", new QuitCommand());
        commands.put("neustart", new RestartCommand());
    }

    /**
     * nimmt ein Kommando Wort, und gibt bei Übereinstimmung mit einem
     * Objekt der Sammlung das Objekt zurück.
     * Returnt  <null> wenn es das Kommando nicht gibt
     */
    public Command get(String word)
    {
        return (Command)commands.get(word);
    }

    /**
     * Schreibt alle vorhandenen Kommandos auf die Ausgabe
     */
    public void showAll() 
    {
        for(Iterator<String>  i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }

    /**
     * ruft die Spezielle Hilfe eines Kommandos auf
     * @param whoUnclear
     */
	public void showspecialhelp(String whoUnclear) {
		
		this.get(whoUnclear).showSpecialHelp();
	}
}
