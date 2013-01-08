package executeAble.commands;

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
		Game.textOut.lineEntry("Du hast das Gespr�ch beendet");
		Game.textOut.lineEntry(player.getCurrentRoom().getLongDescription());
		return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Das Kommando was das Gespr�ch beendet");
		
	}

}
