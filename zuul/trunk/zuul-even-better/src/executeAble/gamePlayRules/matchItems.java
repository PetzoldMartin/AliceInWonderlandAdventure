package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
/**
 * 
 * @author Aismael
 *
 */
public class matchItems extends GameplayRule {
	boolean firstDelete, secondDelete;
	Player player;

	/**
	 * Der Konstruktor der Spielregel {@link GameplayRule} zum kombinieren von zwei 
	 * {@link GameObject} Objekten zum "erstellen" eines neuen
	 * @param secondWord secondWord der erste Teil des Namens der Spielregel {@link GameplayRule} und das erste beteiligte {@link GameObject}
	 * @param thirdWord thirdWord der zeite Teil des Namens der Spielregel {@link GameplayRule}  und das zweite beteiligte {@link GameObject}
	 * @param manipulatetObject Das zu erstellende {@link GameObject}
	 * @param firstDelete das {@link Boolean} das angibt ob das erste beteiligte {@link GameObject} nach ausführung Gelöscht werden soll
	 * @param secondDelete das {@link Boolean} das angibt ob das zweite beteiligte {@link GameObject} nach ausführung Gelöscht werden soll
	 */
	public matchItems(String secondWord, String thirdWord,
			String manipulatetObject, boolean firstDelete, boolean secondDelete) {
		super(secondWord, thirdWord, manipulatetObject);
		this.firstDelete = firstDelete;
		this.secondDelete = secondDelete;
	}

	/**
     * Wenn die für die Kombination benötigten Items Vorhanden im Playerinventar oder im Raum vorhanden sind
     * wird das neue {@link GameObject} "erschaffen" und je nach Vorgabe die Alten {@link GameObject} gelöscht
     * 
     * @return {@link GameStatus}, RUN wenn das Spiel weiterlaufen soll, STOP wenn das Spiel beendet werden soll
     * und RESTART wenn das Spiel neu gestartet und Initialisiert werden soll.
     */  
	@Override
	public GameStatus execute(Player player) {
		this.player = player;
		if (gameObjectIsAvaible(getSecondWord()) && gameObjectIsAvaible(getThirdWord())) {
			if (makeItemVisebill()) {
				removeGameObject(getSecondWord(), firstDelete);
				removeGameObject(getThirdWord(), secondDelete);
				Game.textOut.lineEntry("Du Hast ein neues Object erschaffen");
			} else {

				Game.textOut.lineEntry("Das Kann ich hier nicht benutzen");

			}
		} else {

			Game.textOut.lineEntry("Das Kann ich nicht benutzen");

		}

		return GameStatus.RUN;
	}

	/**
	 * Die Methode die das neue {@link GameObject} "erschafft" indem es Sichtbar und 
	 * somit benutzbar macht wenn das Object sich im Raum oder im Spieler Inventar befindet
	 * @return Boolean ob das "erschaffen" erfolgreich war
	 */
	private boolean makeItemVisebill() {
		if (player.getCurrentRoom().hasObject(getManiO())) {
			player.getCurrentRoom().getSpecialObject(getManiO()).setVisebility(true);
			return true;
		} else {
			if (player.hasObject(getManiO())) {
				player.getSpecialObject(getManiO()).setVisebility(true);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Die Methode die Überprüft ob das zur Koombination benötigte {@link GameObject} vorhanden ist 
	 * @param gString der Name des {@link GameObject}
	 * @return Boolean ob das benötigte {@link GameObject} vorhanden ist
	 */
	private boolean gameObjectIsAvaible(String gString) {
		if (player.hasObject(gString)
				|| player.getCurrentRoom().hasObject(gString)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Methode die das zur Koombination benötigte {@link GameObject} entfernt wenn es gewünscht ist
	 * @param gString der Name des {@link GameObject}
	 * @param remove das Boolean ob das {@link GameObject} wirklich entfernt werden soll
	 */
	private void removeGameObject(String gString, boolean remove) {
		if (remove) {
			if (player.hasObject(gString)) {
				player.itemRemove(gString);
			} else {
				if (player.getCurrentRoom().hasObject(gString)) {
					player.getCurrentRoom().itemRemove(gString);
				}
			}
		}
	}

	
}
