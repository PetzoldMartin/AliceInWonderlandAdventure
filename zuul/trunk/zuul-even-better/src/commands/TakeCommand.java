package commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

public class TakeCommand extends Command {
	

	@Override
	public GameStatus execute(Player player) {
		boolean isFound=false;
        if(hasSecondWord()&&(!player.getCurrentRoom().getWarehouse().isEmpty())) {
            for(int i=0;i<player.getCurrentRoom().getWarehouse().size();i++) {
            	if(player.getCurrentRoom().getWarehouse().get(i).getObjName().equals(getSecondWord())) {
            		if(player.getCurrentRoom().getWarehouse().get(i).isTakeAble()&&player.getCurrentRoom().getWarehouse().get(i).isVisebility()) {
	                	player.itemStore(player.getCurrentRoom().getWarehouse().get(i));
	                	Game.textOut.lineEntry("Du hast "+player.getCurrentRoom().getWarehouse().get(i).getObjName()+" aufgenommen.");
	                	player.getCurrentRoom().getWarehouse().remove(i);
	                	isFound=true;
            		}
            		else {Game.textOut.lineEntry("Du kannst das nicht aufnehmen.");}
            		isFound=true;
            	}
            }
        }
        
        if(!isFound){	Game.textOut.lineEntry("Ich kann nix aufnehmen was nicht da ist...");}

        return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Benutzen um ein Gegenstand im Raum aufzunehmen.");

	}

}
