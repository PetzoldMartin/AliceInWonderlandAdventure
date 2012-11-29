package GamePlayRules;

import GamePlayEnums.PlayerSize;
import zuulCore.Game;
import zuulCore.Player;

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
	public void execute(Player player) {
		if(player.hasObject(secondWord)){
			player.setSize(size);
			if(remove){
			player.itemRemove(secondWord);}
			Game.textOut.lineEntry("Deine Größe wurde auf "+size+" geändert");
		}else{
			if(player.getCurrentRoom().hasObject(secondWord)){
				player.setSize(size);
				if(remove){
				player.getCurrentRoom().itemRemove(secondWord);}
				Game.textOut.lineEntry("Deine Größe wurde auf "+size+" geändert");
		}else{
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		}

	}

}
