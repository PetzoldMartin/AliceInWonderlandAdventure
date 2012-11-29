package gameBuilding;

import java.util.ArrayList;
import java.util.HashMap;

import GamePlayEnums.PlayerSize;
import GamePlayRules.PlayerSizeChange;
import GamePlayRules.gameplayRuleHead;
import GamePlayRules.matchItems;
import GamePlayRules.openDoor;

public class UsableCreator {
	
	private HashMap<String, gameplayRuleHead> rules;

	public UsableCreator() {
		rules= new HashMap<String , gameplayRuleHead>();
		
		createUseableList();
	}
	
	/**
	 * Einfügen der Benutzbaren Items
	 * 1 = Beide Gegenstände Werden gelöscht. 1 Neues wird Freigegeben.
	 * 2 = sichtbarkeit ändern. 1 Gegestand weg.
	 * 
	 */
	private void createUseableList() {
		
		fourAdder(new matchItems("Moehre","Kaninchen","Holz",true,false));
		fourAdder(new matchItems("Lilie","Rose","Blumenstrauß",true,true));
		fourAdder(new openDoor("Schluessel", "sueden", "sueden"));
		fourAdder(new PlayerSizeChange("Blumenstrauß", true, PlayerSize.BIG));
	}

	private void fourAdder(gameplayRuleHead gr ) {
		rules.put(gr.getName(), gr);
		
	}

	public HashMap<String, gameplayRuleHead> getRules() {
		return rules;
	}
	
	
}
