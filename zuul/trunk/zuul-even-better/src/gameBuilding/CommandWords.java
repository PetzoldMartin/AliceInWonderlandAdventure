package gameBuilding;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;

import zuulCore.Game;
import executeAble.commands.Command;
import executeAble.commands.GoCommand;
import executeAble.commands.HelpCommand;
import executeAble.commands.LookCommand;
import executeAble.commands.QuitCommand;
import executeAble.commands.RestartCommand;
import executeAble.commands.SpeakCommand;
import executeAble.commands.TakeCommand;
import executeAble.commands.UseCommand;

/**
 * 
 * Diese Klasse enthält eine Sammlung von allen Kommando Wörter die das Spiel
 * kennt. Es nutzt die erstellten Kommandos um zu erkennen wie diese aufgerufen
 * werden.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class CommandWords {
	private HashMap<String, Command> commands;

	/**
	 * Konstruktor der die Kommandos initialisiert
	 */
	public CommandWords() {
		initialeCommands();
	}

	/**
	 * nimmt ein Kommando Wort, und gibt bei Übereinstimmung mit einem Objekt
	 * der Sammlung das Objekt zurück. Returns <null> wenn es das Kommando nicht
	 * gibt
	 */
	public Command get(String word) {
		return (Command) commands.get(word);
	}

	/**
	 * Schreibt alle vorhandenen Kommandos auf die Ausgabe
	 */
	public void showAll() {
		ArrayList<String> sortedList = new ArrayList<String>();
		sortedList.addAll(commands.keySet());
		Collections.sort(sortedList);
		Iterator<String> iter = sortedList.iterator();
		while (iter.hasNext()) {
			String key = iter.next();

			Game.textOut.entry(key + "  ");
		}

		Game.textOut.lineEntry();
	}

	public String getAll() {

		String ausgabe = "";
		ArrayList<String> sortedList = new ArrayList<String>();
		sortedList.addAll(commands.keySet());
		Collections.sort(sortedList);
		Iterator<String> iter = sortedList.iterator();
		while (iter.hasNext()) {
			String key = iter.next();

			ausgabe = ausgabe + "  " + key;
		}
		return ausgabe;

	}

	/**
	 * ruft die Spezielle Hilfe eines Kommandos auf
	 * 
	 * @param whoUnclear
	 */
	public void showspecialhelp(String whoUnclear) {

		this.get(whoUnclear).showSpecialHelp();
	}

	/**
	 * Methode um ein neues Kommando hinzuzufügen
	 * 
	 * @param name
	 *            der Name des Kommandos
	 * @param command
	 *            der einzufügenden Kommando
	 */
	public void insertCommand(String name, Command command) {
		commands.put(name, command);
	}

	/**
	 * Methode um ein neues Kommando zu löschen
	 * 
	 * @param name
	 *            der Name des zu löschenden Kommandos
	 */
	public void deleteCommand(String name) {
		commands.remove(name);
	}

	/**
	 * Methode zum leeren der Kommandoliste
	 */
	public void clearCommands() {
		commands.clear();
	}

	/**
	 * Methode um die Kommando Liste zu initialisieren
	 */
	public void initialeCommands() {
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
