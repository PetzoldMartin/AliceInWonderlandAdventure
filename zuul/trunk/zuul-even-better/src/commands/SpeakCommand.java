package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

/**
 * Unterklasse der Basisklasse Command
 * 
 * Dient um mit GameObjekten zu Reden.
 *
 */
public class SpeakCommand extends Command {

	@Override
	public GameStatus execute(Player player) {
		
		
        if(hasSecondWord()) {	
        	for(int i=0;i<player.getCurrentRoom().getWarehouse().size();i++) {	//�berpr�ft Ob der Gew�nschte gegenstand im Raum ist.
        		if(player.getCurrentRoom().getWarehouse().get(i).getObjName().equals(getSecondWord())) {
        			if(player.getCurrentRoom().getWarehouse().get(i).isSpeakAble()){	//�berpr�ft ob der Gegenstand Sprechen kann
        				System.out.println("--> Gespr�ch <-- ."); //Noch unklar wie ich implementier :D *todo dingens ka wie man das macht -.-'
        			}
        			else {
        				System.out.println("So verr�ckt bin ich nun auch wieder nicht.");
        			}
        			
        		}
        	}
        }
        else {
            System.out.println("So verr�ckt bin ich nun auch wieder nicht.");
        }
        return GameStatus.RUN;
	}

	/**
	 * //Die spezielle Hilfe f�r das SpeakCommand
	 */
	@Override
	public void showSpecialHelp() {
		System.out.println("Du versuchst mit etwas oder jemand zu sprechen.");
	}

}
