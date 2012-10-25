package de.fh_zwickau.oose.zuul;
import java.util.HashMap;
import java.util.Iterator;

import commands.GoCommand;
import commands.HelpCommand;
import commands.QuitCommand;
import commands.RestartCommand;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2.0 (December 2002)
 */

public class CommandWords
{
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
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
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return (Command)commands.get(word);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(Iterator<String>  i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }

	public void showspecialhelp(String whoUnclear) {
		
		this.get(whoUnclear).showSpecialHelp();
		
//		for(Iterator<String>  i = commands.keySet().iterator(); i.hasNext(); ) {
//			String toTest=i.next();
//            if(toTest.equals( whoUnclear)){
//            System.out.print( toTest+ "  ");
//		}
//		
//        }
		
	}
}
