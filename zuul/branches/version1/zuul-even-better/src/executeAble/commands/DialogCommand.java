package executeAble.commands;

import gameEnums.GameStatus;

import java.util.HashMap;
import java.util.Iterator;

import zuulCore.Game;
import zuulCore.Player;

public class DialogCommand extends Command {

	HashMap<String,Command> dialogStore;
	private String textout;
	Integer name =1;
	private String textIn;
	
	
	public DialogCommand(String textIn){
		dialogStore= new HashMap<String,Command>();
		textout="Gesprächsanfang";
		this.textIn=textIn;
	}
	public DialogCommand(String textOut,String textIn){
		this(textIn);
		textout=textOut;
	}
	
	@Override
	public GameStatus execute(Player player) {
		Integer k=1;
		player.getnCW().clearCommands();
		Game.textOut.lineEntry(textIn);
		Game.textOut.lineEntry("Deine Antwort möglichkeiten sind");
		for (Iterator<String> i = dialogStore.keySet().iterator(); i.hasNext();){
			String name =i.next();
			player.getnCW().insertCommand(k.toString(), dialogStore.get(name));
			Game.textOut.lineEntry(k.toString()+" :  "+ ((DialogCommand) dialogStore.get(name)).getTextout());
			k++;
			}
		 player.getnCW().insertCommand(k.toString(), new DialogEndCommand());
		 Game.textOut.lineEntry(k.toString()+" :  "+ "Auf wiedersehen");
		 player.getnCW().insertCommand("?", new HelpCommand(player.getnCW()));
		 Game.textOut.lineEntry("? :  "+ "Hilfe");
		return GameStatus.RUN;
	}
	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("damit kannst du "+textout + " sagen");
	}

	public String getTextout() {
		return textout;
	}
	
	public void insertDialog(DialogCommand d){
		dialogStore.put(name.toString(), d);
		name++;
	}
}
