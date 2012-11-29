package GamePlayRules;

import zuulCore.Player;

public abstract class gameplayRuleHead {

	String name;
	String maniO;
	String secondWord,thirdWord;

	public gameplayRuleHead(String secondWord,String thirdWord,String manipulatetObject){
		name=secondWord+thirdWord;	
		maniO=manipulatetObject;
		this.secondWord=secondWord;
		this.thirdWord=thirdWord;
	}

	public abstract void  execute(Player player);
	
	
	public String getName() {
		return name;
	}
}
