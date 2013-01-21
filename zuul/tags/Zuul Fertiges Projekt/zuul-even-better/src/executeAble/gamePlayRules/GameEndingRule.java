package executeAble.gamePlayRules;

import executeAble.commands.QuitCommand;
import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
/**
 *
 * @author Martin Petzold
 */
public class GameEndingRule extends GameplayRule {



	/**
	 * Konstruktor der Game ending rule
	 * @param secondWord das Befehlswort f�r die {@link GameEndingRule}
	 */
	public GameEndingRule(String secondWord) {
		super(secondWord, null, null);

	}

	@Override
	/**
	 * 
	 * beendet einen Dialog
	 */
	public GameStatus execute(Player player) {
		if(player.hasReadyToUseObject(getSecondWord())){
			if(player.getSpecialObject(getSecondWord()).isVisebility()){
		Game.textOut.lineEntry("Du nutzt Denn Weltenzerst�renden KriegsHammer und die TraumWelt zerf�llt");
		Game.textOut.lineEntry("Viel Spass im Realen Leben");
		Game.textOut.lineEntry("Hier stehen sp�ter die Credits");
		return	new QuitCommand().execute(player);}
		}
		Game.textOut.lineEntry("sch�n gedacht aber dir fehlt da was Entscheidendes");
		return GameStatus.RUN;
	}


}
