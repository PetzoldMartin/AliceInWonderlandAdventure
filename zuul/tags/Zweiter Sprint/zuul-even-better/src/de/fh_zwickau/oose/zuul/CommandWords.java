package de.fh_zwickau.oose.zuul;
import java.util.HashMap;
import java.util.Iterator;

import commands.Command;
import commands.GoCommand;
import commands.HelpCommand;
import commands.LookCommand;
import commands.QuitCommand;
import commands.RestartCommand;
import commands.SpeakCommand;
import commands.TakeCommand;
import commands.UseCommand;

/**
 * 
 * Diese Klasse enthält eine Sammlung von allen Kommando Wörter die das Spiel kennt.
 * Es nutzt die erstellten Kommandos um zu erkennen wie diese aufgerufen werden.
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
        initialeCommands(); // NOPMD by Aismael on 27.11.12 15:01
    }

    /**
     * nimmt ein Kommando Wort, und gibt bei Übereinstimmung mit einem
     * Objekt der Sammlung das Objekt zurück.
     * Returns  <null> wenn es das Kommando nicht gibt
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
        	Game.textOut.entry(i.next() + "  ");
        }
        Game.textOut.lineEntry();
    }

    /**
     * ruft die Spezielle Hilfe eines Kommandos auf
     * @param whoUnclear
     */
	public void showspecialhelp(String whoUnclear) {
		
		this.get(whoUnclear).showSpecialHelp();
	}
	/**
	 * 	Methode um ein neues Kommando hinzuzufügen
	 * @param name der Name des Kommandos
	 * @param command der einzufügenden Kommando
	 */
	public void insertCommand(String name, Command command){
		commands.put(name, command);
	}
	/**
	 * Methode um ein neues Kommando zu löschen
	 * @param name der Name des zu löschenden Kommandos
	 */
	public void deleteCommand(String name){
		commands.remove(name);
	}
	/**
	 * Methode zum leeren der Kommandoliste
	 */
	public void clearCommands(){
		commands.clear();
	}
	/**
	 * Methode um die Kommando Liste zu initialisieren
	 */
	public void initialeCommands(){
		commands = new HashMap<String, Command>();
        commands.put("geh", new GoCommand());
        commands.put("hilfe", new HelpCommand(this));
        commands.put("?", new HelpCommand(this));
        commands.put("ende", new QuitCommand());
        commands.put("neustart", new RestartCommand());
        commands.put("guck", new LookCommand());
        commands.put("nimm", new TakeCommand());
        commands.put("sprich", new SpeakCommand());
        commands.put("nutz", new UseCommand());
	}
}
