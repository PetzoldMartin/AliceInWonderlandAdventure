package gameBuilding;

import java.util.HashMap;

import GamePlayEnums.PlayerSize;
import executeAble.gamePlayRules.NullRule;
import executeAble.gamePlayRules.PlayerSizeChange;
import executeAble.gamePlayRules.gameplayRuleHead;
import executeAble.gamePlayRules.matchItems;
import executeAble.gamePlayRules.openDoor;

public class UsableCreator {

	private HashMap<String, gameplayRuleHead> rules;

	public UsableCreator() {
		rules = new HashMap<String, gameplayRuleHead>();

		createUseableList();
	}

	/**
	 * Einfügen der Benutzbaren Items 1 = Beide Gegenstände Werden gelöscht. 1
	 * Neues wird Freigegeben. 2 = sichtbarkeit ändern. 1 Gegestand weg.
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

	private void fourAdder(gameplayRuleHead gr) {
		rules.put(gr.getName(), gr);

	}

	public gameplayRuleHead getRule(String secondWord, String thirdWord) {
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

	public boolean hasRule(String secondWord, String thirdWord) {
		if (rules.containsKey(secondWord + "$" + thirdWord)) {
			return true;
		} else {
			return false;
		}
	}

}
