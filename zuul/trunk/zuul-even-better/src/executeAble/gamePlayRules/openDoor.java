package executeAble.gamePlayRules;

import gameEnums.GameStatus;
import gameEnums.LockedStatus;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;
/**
 * Die Spielregel {@link GameplayRule} zum öffnen von Verschlossenen Türen im Spiel
 * @author Martin Petzold
 *
 */
public class openDoor extends GameplayRule {

	private boolean keyRemove;//boolean ob der Schlüssel entfernt werden soll

	/**
	 * Der Konstruktor der openDoor Regel
	 * @param secondWord der Name des {@link GameObject} zum Türöffnen
	 * @param Direction der Name der zu Öfnenden Tür/direction
	 * @param keyRemove ob das {@link GameObject} zum Türöffnen danach entfernt wird
	 */
	public openDoor(String secondWord,
			String Direction,boolean keyRemove) {
		super(secondWord, Direction, Direction);
		this.keyRemove=keyRemove;
	}

	/**
	 * Die Methode zum Raumöffnen
	 * überprüft ob {@link GameObject} zum öffnen und der verschlossene Ausgang vorhanden ist
	 * und entfernt wenn gefordert den Schlüssel
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
			Game.textOut.lineEntry("Die Tür ist Offen");
		} else {
			Game.textOut.lineEntry("da ist keine Verschlossene Tür");
		}}else{
			Game.textOut.lineEntry("Du hast keinen Schluessel");
		}
		return GameStatus.RUN;
	}


}
