package de.fh_zwickau.oose.zuul;
/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }
    
    /**
     * Print out some help information. Here we print some stupid, 
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    public boolean execute(Player player)
    {
        System.out.println("You are lost. You are alone. You know");
        System.out.println("you fall in a fountain ,when you.");
        System.out.println("follows the white Rabbit");
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
