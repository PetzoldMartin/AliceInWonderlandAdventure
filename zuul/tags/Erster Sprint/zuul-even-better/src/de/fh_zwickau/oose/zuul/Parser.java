package de.fh_zwickau.oose.zuul;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import commands.Command;
import commands.NullCommand;

/**
 * Diese Klasse ist eine der Hauptklassen der "World of Zuul" Anwendung.
 *
 * Dieser Parser liest die Texteingabe und versucht diese als Game Commands zu interpretieren.
 * Immer wenn er aufgerufen wird, liest er eine zeile vom Terminal ein und versucht diese
 * als zwei wort kommando zu interpretieren. Es wird bei erfolg ein Objekt der Klasse des Kommandos zur�ckgegeben.
 *
 * Der parser hat eine Liste mit Kommandow�rtern. Er pr�ft die Eingabe gegen 
 * diese Liste, wenn die eingabe nicht gefunden wird gibt er das null command Objekt zur�ck.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

class Parser 
{

    private CommandWords commands;  // enth�lt alle KommandoW�rter
    public Parser() 
    {
        commands = new CommandWords();
    }

    public Command getCommand() 
    {
        String inputLine = "";   //enth�lt die gesamte Eingabe
        String word1;
        String word2;

        System.out.print("> ");     // print prompt

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // bekomme erstes Wort
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // bekomme zweites Wort
        else
            word2 = null;

        // Notiz: der Rest der Eingabe wird ignoriert

        Command command = commands.get(word1);
        if(command == null) {
        	command = new NullCommand();
        }
        else {
        	command.setSecondWord(word2);
        }
        return command;
    }

    /**
     * schreibt alle Komando w�rter auf die Konsole
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
