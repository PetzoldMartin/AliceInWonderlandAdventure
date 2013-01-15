package executeAble.gamePlayRules;

import executeAble.commands.QuitCommand;
import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
/**
 *
 *
 */
public class GameEndingRule extends GameplayRule {



	
	public GameEndingRule(String secondWord) {
		super(secondWord, null, null);

	}

	/**
	 * 
	 * 
	 */
	@Override
	public GameStatus execute(Player player) {
		if(player.hasReadyToUseObject(getSecondWord())){
			if(player.getSpecialObject(getSecondWord()).isVisebility()){
		Game.textOut.lineEntry("Du nutzt Denn Weltenzerstörenden KriegsHammer und die TraumWelt zerfällt");
		Game.textOut.lineEntry("Viel Spass im Realen Leben");
		Game.textOut.lineEntry("Hier stehen später die Credits");
		return	new QuitCommand().execute(player);}
		}
		Game.textOut.lineEntry("schön gedacht aber dir fehlt da was Entscheidendes");
		return GameStatus.RUN;
	}


}
