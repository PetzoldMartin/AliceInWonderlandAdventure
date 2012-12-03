package executeAble.dialog;

import executeAble.commands.Command;
import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.Player;

public class DialogPartCommand extends Command {

	private String textout;

	public DialogPartCommand(String textout,String pfad){
		this.textout=textout;
	}
	@Override
	public GameStatus execute(Player player) {
		Game.textOut.lineEntry(textout);
		return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Das Kommando was einen Gesprächsteil auslöst");
		
	}

}
