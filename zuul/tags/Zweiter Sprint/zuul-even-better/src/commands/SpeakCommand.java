package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Game;
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
        	for(int i=0;i<player.getCurrentRoom().getWarehouse().size();i++) {	//�berpr�ft Ob der Gew�nschte Gegenstand im Raum ist.
        		if(player.getCurrentRoom().getWarehouse().get(i).getObjName().equals(getSecondWord())) {
        			if(player.getCurrentRoom().getWarehouse().get(i).isSpeakAble()){	//�berpr�ft ob der Gegenstand Sprechen kann
        				Game.textOut.lineEntry("--> Gespr�ch <-- ."); //Noch unklar wie implementiert :D *TODO Dingen QA wie man das macht -.-'
        			}
        			else {
        				if(player.getCurrentRoom().getWarehouse().get(i).isVisebility()){
        					Game.textOut.lineEntry("So verr�ckt bin ich nun auch wieder nicht.");
        				}
        				else{}
        			}
        			
        		}
        	}
        }
        else {
        	Game.textOut.lineEntry("So verr�ckt bin ich nun auch wieder nicht.");
        }
        return GameStatus.RUN;
	}

	/**
	 * //Die spezielle Hilfe f�r das SpeakCommand
	 */
	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Du versuchst mit etwas oder jemand zu sprechen.");
	}

}
