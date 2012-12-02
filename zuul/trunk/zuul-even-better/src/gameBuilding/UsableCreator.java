package gameBuilding;

import java.util.HashMap;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
import GamePlayEnums.PlayerSize;
import executeAble.gamePlayRules.NullRule;
import executeAble.gamePlayRules.PlayerSizeChange;
import executeAble.gamePlayRules.GameplayRule;
import executeAble.gamePlayRules.matchItems;
import executeAble.gamePlayRules.openDoor;

/**
 * die Klasse in der festgelegt wird welchen Auslöseworten ({@link GameObject}en oder directions) welche {@link GameplayRule}
 * zugeordnet ist
 * @author Aismael
 *
 */
public class UsableCreator {

	private HashMap<String, GameplayRule> rules;// der interne speicher für die Spieleregeln

	public UsableCreator() {
		rules = new HashMap<String, GameplayRule>();

		createUseableList();
	}

	/**
	 * Methode die die speziellen {@link GameplayRule}s erzeugt und in den internen Speicher eintragen lässt
	 * 
	 */
	private void createUseableList() {

		fourAdder(new matchItems("Moehre", "Kaninchen", "Holz", true, false));
		fourAdder(new matchItems("Lilie", "Rose", "Blumenstrauss", true, true));
		fourAdder(new PlayerSizeChange("Blumenstrauss", true, PlayerSize.BIG));
		fourAdder(new openDoor("Schluessel", "sueden",true));
		fourAdder(new openDoor("Schluessel", "norden",true));
		fourAdder(new openDoor("Schluessel", "osten",true));
		fourAdder(new openDoor("Schluessel", "westen",true));
	}

	/**
	 * Methode die die {@link GameplayRule} in den internen Speicher mit Suchnamen einträgt
	 * @param gr spezielle {@link GameplayRule}
	 */
	private void fourAdder(GameplayRule gr) {
		rules.put(gr.getName(), gr);

	}

	/**
	 * die Methode die wenn sie vorhanden ist die {@link GameplayRule} anhand der Suchwörter zurückgibt
	 * @param secondWord erstes Suchwort
	 * @param thirdWord zweites Suchwort
	 * @return die geforderte {@link GameplayRule} oder wenn nicht diese nicht vorhanden ist {@link NullRule}
	 */
	public GameplayRule getRule(String secondWord, String thirdWord) {
		if (hasRule(secondWord, thirdWord)) {
			return rules.get(secondWord + "$" + thirdWord);
		} else {
			if (hasRule(thirdWord, secondWord)) {
				return rules.get(thirdWord + "$" + secondWord);
			} else {
				return new NullRule();
			}
		}

	}

	/**
	 * die Methode die das vorhandensein einer {@link GameplayRule} überprüft
	 * @param secondWord erstes  Suchwort
	 * @param thirdWord zweites Suchwort
	 * @return ob die {@link GameplayRule} vorhanden ist
	 */
	public boolean hasRule(String secondWord, String thirdWord) {
		if (rules.containsKey(secondWord + "$" + thirdWord)) {
			return true;
		} else {
			return false;
		}
	}

}
