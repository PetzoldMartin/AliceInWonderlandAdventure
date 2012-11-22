package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

public class TakeCommand extends Command {

	@Override
	public GameStatus execute(Player player) {
        if(hasSecondWord()&&(!player.getCurrentRoom().getWarehouse().isEmpty())) {
            for(int i=0;i<player.getCurrentRoom().getWarehouse().size();i++) {
            	if(player.getCurrentRoom().getWarehouse().get(i).getObjName().equals(getSecondWord())) {
            		if(player.getCurrentRoom().getWarehouse().get(i).isTakeAble()) {
	                	player.itemStore(player.getCurrentRoom().getWarehouse().get(i));
	                	System.out.println("Du hast "+player.getCurrentRoom().getWarehouse().get(i).getObjName()+" aufgenommen.");
	                	player.getCurrentRoom().getWarehouse().remove(i);
            		}
            		else {System.out.println("Du kannst das nicht aufnehmen.");}
            	}
            }
        }
        else {
            System.out.println("Ich kann nix aufnehmen was nicht da ist...");
        }
        return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		System.out.println("Benutzen um ein Gegenstand im Raum aufzunehmen.");

	}

}
