package executeAble.dialog;

import java.util.HashMap;
import java.util.Iterator;

import zuulCore.Player;
import executeAble.ExecuteAble;
import executeAble.commands.Command;
import executeAble.commands.HelpCommand;
import gameEnums.GameStatus;

public class Dialog extends ExecuteAble {

	HashMap<String,Command> dialogStore;

	
	public Dialog(){
		dialogStore= new HashMap<String,Command>();
		dialogStore.put("1", new DialogPartCommand("Test"));

	}
	@Override
	public GameStatus execute(Player player) {
		Integer k=1;
		player.getnCW().clearCommands();
		for (Iterator<String> i = dialogStore.keySet().iterator(); i.hasNext();){
			String name =i.next();
			player.getnCW().insertCommand(k.toString(), dialogStore.get(name));
			k++;
			}
		 player.getnCW().insertCommand(k.toString(), new DialogEndCommand());
		 player.getnCW().insertCommand("?", new HelpCommand(player.getnCW()));
		return GameStatus.RUN;
	}

	
}
