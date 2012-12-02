package executeAble.gamePlayRules;

import executeAble.ExecuteAble;

/**
 * Die Abstrakte Klasse für Die Regeln des Spieles die vom Use Command verwendet werden
 * sozusagen das Use Command Individuell Anpasst jenachdem welche Regel für das Auslösewort
 * erstellt Wurde
 * @author Martin Petzold
 *
 */
public abstract class gameplayRuleHead extends ExecuteAble{

	private String name;//das Auslösewort der Spieleregel
	private String maniO;//das interne SchlüsselWort für den zu manipulierenden Spielteil

	/**
	 * Der Konstruktor der Allgemeinen Spielregel
	 * @param secondWord der erste Teil des Namens der Spielregel {@link gameplayRuleHead}
	 * @param thirdWord der zeite Teil des Namens der Spielregel {@link gameplayRuleHead}
	 * @param manipulatetObject das interne SchlüsselWort für den zu manipulierenden Spielteil
	 */
	public gameplayRuleHead(String secondWord,String thirdWord,String manipulatetObject){
		super();
		name=secondWord+"$"+thirdWord;//das Auslösewort der Spieleregel mit Trennzeichen für Korekkte Schreibung der Auslösewortteile	
		setManiO(manipulatetObject);
		this.setSecondWord(secondWord);
		this.setThirdWord(thirdWord);
	}
	
	/**
	 * 
	 * @return name das Auslösewort der Spieleregel {@link gameplayRuleHead}
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return maniO das interne SchlüsselWort für den zu manipulierenden Spielteil {@link gameplayRuleHead}
	 */
	public String getManiO() {
		return maniO;
	}

	/**
	 * 
	 * @param maniO das interne SchlüsselWort für den zu manipulierenden Spielteil
	 */
	public void setManiO(String maniO) {
		this.maniO = maniO;
	}
}
