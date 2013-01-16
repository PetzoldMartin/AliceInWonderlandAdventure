package executeAble.gamePlayRules;

import gameEnums.GameStatus;
import gameEnums.PlayerSize;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.thingsWithstore.Player;
/**
 * Die Spielregel um mit einem {@link GameObject} die Spielergr��e zu ver�ndern
 *  @author Martin Petzold
 *
 */
public class PlayerSizeChange extends GameplayRule {

	/**
	 * boolean ob das {@link GameObject}  entfernt werden soll
	 */
	private boolean remove;
	/**
	 * die Interne Spielergr�sse {@link PlayerSize}
	 */
	private PlayerSize size;

	/**
	 * Konstruktor f�r die Spielregel zum �ndern der Spielergr��e
	 * @param secondWord der Name des {@link GameObject} zur Spielergr��en�nderung
	 * @param remove boolean ob das {@link GameObject}  entfernt werden soll
	 * @param size die Spielergr��e {@link PlayerSize} die der Spieler nach �nderung haben soll
	 */
	public PlayerSizeChange(String secondWord,boolean remove,PlayerSize size) {
		super(secondWord, null, null);
		this.remove=remove;
		this.size=size;
	}

	/**
	 * Methode die wenn das {@link GameObject} vorhanden ist die Spielergr��e wie gew�nscht �ndert
	 * 
	 */
	@Override
	public GameStatus execute(Player player) {
		if(player.hasReadyToUseObject(getSecondWord())){
			player.setSize(size);
			if(remove){
			player.itemRemove(getSecondWord());}
			Game.textOut.lineEntry("Deine Gr��e wurde auf "+size+" ge�ndert");
		}else{
			if(player.getCurrentRoom().hasReadyToUseObject(getSecondWord())){
				player.setSize(size);
				if(remove){
				player.getCurrentRoom().itemRemove(getSecondWord());}
				Game.textOut.lineEntry("Deine Gr��e wurde auf "+size+" ge�ndert");
		}else{
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		}
		return GameStatus.RUN;
	}


}
