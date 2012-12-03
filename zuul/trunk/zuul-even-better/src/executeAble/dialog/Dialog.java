package executeAble.dialog;

import java.util.HashMap;
import java.util.Iterator;

import zuulCore.Player;
import executeAble.ExecuteAble;
import gameEnums.GameStatus;

public class Dialog extends ExecuteAble {

	HashMap<String,DialogPartCommand> dialogStore;
	String levelPfad;
	private int level;
	
	public Dialog(){
		dialogStore= new HashMap<String,DialogPartCommand>();
		level=1;
		levelPfad=null;
	}
	@Override
	public GameStatus execute(Player player) {
//		player.getnCW().clearCommands();
//		for (Iterator<String> i = dialogStore.keySet().iterator(); i.hasNext();){
//			String toHandle=i.next();
//			if(toHandle.length()==level&&toHandle.contains(levelPfad)){
//				player.getnCW().insertCommand(toHandle, dialogStore.get(toHandle));
//			}
//		}
		return GameStatus.RUN;
	}

	
}
