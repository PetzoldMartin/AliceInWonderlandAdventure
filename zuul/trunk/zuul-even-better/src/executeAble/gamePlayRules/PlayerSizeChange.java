package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;
import GamePlayEnums.PlayerSize;

public class PlayerSizeChange extends gameplayRuleHead {

	private boolean remove;
	private PlayerSize size;

	public PlayerSizeChange(String secondWord,boolean remove,PlayerSize size) {
		super(secondWord, null, null);
		this.remove=remove;
		this.size=size;
		// TODO Auto-generated constructor stub
	}

	@Override
	public GameStatus execute(Player player) {
		if(player.hasObject(getSecondWord())){
			player.setSize(size);
			if(remove){
			player.itemRemove(getSecondWord());}
			Game.textOut.lineEntry("Deine Gr��e wurde auf "+size+" ge�ndert");
		}else{
			if(player.getCurrentRoom().hasObject(getSecondWord())){
				player.setSize(size);
				if(remove){
				player.getCurrentRoom().itemRemove(getSecondWord());}
				Game.textOut.lineEntry("Deine Gr��e wurde auf "+size+" ge�ndert");
		}else{
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		}
		return GameStatus.RUN;
	}


}
