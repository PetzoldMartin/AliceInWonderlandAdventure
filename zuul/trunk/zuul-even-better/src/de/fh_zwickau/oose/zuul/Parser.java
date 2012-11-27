package de.fh_zwickau.oose.zuul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import commands.Command;
import commands.NullCommand;

/**
 * Diese Klasse ist eine der Hauptklassen der "World of Zuul" Anwendung.
 * 
 * Dieser Parser liest die Texteingabe und versucht diese als Game Commands zu
 * interpretieren. Immer wenn er aufgerufen wird, liest er eine Zeile vom
 * Terminal ein und versucht diese als zwei Wort Kommando zu interpretieren. Es
 * wird bei Erfolg ein Objekt der Klasse des Kommandos zur�ckgegeben.
 * 
 * Der parser hat eine Liste mit Kommandow�rtern. Er pr�ft die Eingabe gegen
 * diese Liste, wenn die Eingabe nicht gefunden wird gibt er das null command
 * Objekt zur�ck.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Parser {

	private CommandWords commands; // enth�lt alle KommandoW�rter

	public Parser() {
		commands = new CommandWords();
	}

	public Command consoleReader() {
		String inputLine = ""; // enth�lt die gesamte Eingabe
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			inputLine = reader.readLine();
		} catch (java.io.IOException exc) {
			Game.textOut.lineEntry("There was an error during reading: "
					+ exc.getMessage());
		}
		return getCommand(inputLine);
	}

	public Command getCommand(String inputLineFR) {

		String word1;
		String word2;
		String word3;

		Game.textOut.entry("> "); // print prompt

		StringTokenizer tokenizer = new StringTokenizer(inputLineFR);

		if (tokenizer.hasMoreTokens())
			word1 = tokenizer.nextToken(); // bekomme erstes Wort
		else
			word1 = null;
		if (tokenizer.hasMoreTokens())
			word2 = tokenizer.nextToken(); // bekomme zweites Wort
		else
			word2 = null;
		if (tokenizer.hasMoreTokens())
			word3 = tokenizer.nextToken(); // bekomme zweites Wort
		else
			word3 = null;

		// Notiz: der Rest der Eingabe wird ignoriert

		Command command = commands.get(word1);
		if (command == null) {
			command = new NullCommand();
		} else {
			command.setSecondWord(word2);
			command.setThirdWord(word3);
		}
		return command;
	}

	/**
	 * schreibt alle Kommando W�rter auf die Konsole
	 */
	public void showCommands() {
		commands.showAll();
	}
}
