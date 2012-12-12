package executeAble.gamePlayRules;

import gameEnums.GameStatus;
import gameEnums.LockedStatus;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;
/**
 * Die Spielregel {@link GameplayRule} zum �ffnen von Verschlossenen T�ren im Spiel
 * @author Martin Petzold
 *
 */
public class openDoor extends GameplayRule {

	private boolean keyRemove;//boolean ob der Schl�ssel entfernt werden soll

	/**
	 * Der Konstruktor der openDoor Regel
	 * @param secondWord der Name des {@link GameObject} zum T�r�ffnen
	 * @param Direction der Name der zu �fnenden T�r/direction
	 * @param keyRemove ob das {@link GameObject} zum T�r�ffnen danach entfernt wird
	 */
	public openDoor(String secondWord,
			String Direction,boolean keyRemove) {
		super(secondWord, Direction, Direction);
		this.keyRemove=keyRemove;
	}

	/**
	 * Die Methode zum Raum�ffnen
	 * �berpr�ft ob {@link GameObject} zum �ffnen und der verschlossene Ausgang vorhanden ist
	 * und entfernt wenn gefordert den Schl�ssel
	 */
	@Override
	public GameStatus execute(Player player) {
		if (player.hasReadyToUseObject(getSecondWord())){
		if (player.getCurrentRoom().getExit(getManiO()).isClosed() == LockedStatus.LOCKED) {
			player.getCurrentRoom().getExit(getManiO())
					.setClosed(LockedStatus.UNLOCKED);
			if(keyRemove){
			player.itemRemove(getSecondWord());
			}
			Game.textOut.lineEntry("Die T�r ist Offen");
		} else {
			Game.textOut.lineEntry("da ist keine Verschlossene T�r");
		}}else{
			Game.textOut.lineEntry("Du hast keinen Schluessel");
		}
		return GameStatus.RUN;
	}


}
