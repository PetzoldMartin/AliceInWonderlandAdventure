package executeAble.gamePlayRules;

import zuulCore.Player;
import GamePlayEnums.GameStatus;
import executeAble.ExecuteAble;

public abstract class gameplayRuleHead extends ExecuteAble{

	private String name;
	private String maniO;

	public gameplayRuleHead(String secondWord,String thirdWord,String manipulatetObject){
		super();
		name=secondWord+"$"+thirdWord;	
		setManiO(manipulatetObject);
		this.setSecondWord(secondWord);
		this.setThirdWord(thirdWord);
	}

	public abstract GameStatus  execute(Player player);
	
	
	public String getName() {
		return name;
	}

	public String getManiO() {
		return maniO;
	}

	public void setManiO(String maniO) {
		this.maniO = maniO;
	}
}
