package executeAble.dialog;

import executeAble.commands.Command;
import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.Player;

public class DialogEndCommand extends Command {


	public DialogEndCommand(){
	}
	@Override
	public GameStatus execute(Player player) {
		player.getnCW().clearCommands();
		player.getnCW().initialeCommands();
		return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Das Kommando was das Gespräch beendet");
		
	}

}
