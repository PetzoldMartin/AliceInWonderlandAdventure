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
	 * Einf�gen der Benutzbaren Items
	 * 1 = Beide Gegenst�nde Werden gel�scht. 1 Neues wird Freigegeben.
	 * 2 = sichtbarkeit �ndern. 1 Gegestand weg.
	 * 
	 */
	private void createUseableList() {
		
		fourAdder(new matchItems("Moehre","Kaninchen","Holz",true,false));
		fourAdder(new matchItems("Lilie","Rose","Blumenstrau�",true,true));
		fourAdder(new openDoor("Schluessel", "sueden", "sueden"));
		fourAdder(new PlayerSizeChange("Blumenstrau�", true, PlayerSize.BIG));
	}

	private void fourAdder(gameplayRuleHead gr ) {
		rules.put(gr.getName(), gr);
		
	}

	public HashMap<String, gameplayRuleHead> getRules() {
		return rules;
	}
	
	
}
