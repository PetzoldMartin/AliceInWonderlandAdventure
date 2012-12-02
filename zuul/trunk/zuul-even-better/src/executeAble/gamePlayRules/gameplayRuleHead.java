package executeAble.gamePlayRules;

import executeAble.ExecuteAble;

/**
 * Die Abstrakte Klasse f�r Die Regeln des Spieles die vom Use Command verwendet werden
 * sozusagen das Use Command Individuell Anpasst jenachdem welche Regel f�r das Ausl�sewort
 * erstellt Wurde
 * @author Martin Petzold
 *
 */
public abstract class gameplayRuleHead extends ExecuteAble{

	private String name;//das Ausl�sewort der Spieleregel
	private String maniO;//das interne Schl�sselWort f�r den zu manipulierenden Spielteil

	/**
	 * Der Konstruktor der Allgemeinen Spielregel
	 * @param secondWord der erste Teil des Namens der Spielregel {@link gameplayRuleHead}
	 * @param thirdWord der zeite Teil des Namens der Spielregel {@link gameplayRuleHead}
	 * @param manipulatetObject das interne Schl�sselWort f�r den zu manipulierenden Spielteil
	 */
	public gameplayRuleHead(String secondWord,String thirdWord,String manipulatetObject){
		super();
		name=secondWord+"$"+thirdWord;//das Ausl�sewort der Spieleregel mit Trennzeichen f�r Korekkte Schreibung der Ausl�sewortteile	
		setManiO(manipulatetObject);
		this.setSecondWord(secondWord);
		this.setThirdWord(thirdWord);
	}
	
	/**
	 * 
	 * @return name das Ausl�sewort der Spieleregel {@link gameplayRuleHead}
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return maniO das interne Schl�sselWort f�r den zu manipulierenden Spielteil {@link gameplayRuleHead}
	 */
	public String getManiO() {
		return maniO;
	}

	/**
	 * 
	 * @param maniO das interne Schl�sselWort f�r den zu manipulierenden Spielteil
	 */
	public void setManiO(String maniO) {
		this.maniO = maniO;
	}
}
