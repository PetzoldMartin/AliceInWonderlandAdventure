package executeAble.gamePlayRules;

import gameEnums.PlayerSize;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;
import gameEnums.GameStatus;
/**
 * Die Spielregel um mit einem {@link GameObject} die Spielergröße zu verändern
 * @author Aismael
 *
 */
public class PlayerSizeChange extends GameplayRule {

	private boolean remove;//boolean ob das {@link GameObject}  entfernt werden soll
	private PlayerSize size;

	/**
	 * Konstruktor für die Spielregel zum Ändern der Spielergröße
	 * @param secondWord der Name des {@link GameObject} zur Spielergrößenänderung
	 * @param remove boolean ob das {@link GameObject}  entfernt werden soll
	 * @param size die Spielergröße {@link PlayerSize} die der Spieler nach änderung haben soll
	 */
	public PlayerSizeChange(String secondWord,boolean remove,PlayerSize size) {
		super(secondWord, null, null);
		this.remove=remove;
		this.size=size;
	}

	/**
	 * Methode die wenn das {@link GameObject} vorhanden ist die Spielergröße wie gewünscht ändert
	 * 
	 */
	@Override
	public GameStatus execute(Player player) {
		if(player.hasObject(getSecondWord())){
			player.setSize(size);
			if(remove){
			player.itemRemove(getSecondWord());}
			Game.textOut.lineEntry("Deine Größe wurde auf "+size+" geändert");
		}else{
			if(player.getCurrentRoom().hasObject(getSecondWord())){
				player.setSize(size);
				if(remove){
				player.getCurrentRoom().itemRemove(getSecondWord());}
				Game.textOut.lineEntry("Deine Größe wurde auf "+size+" geändert");
		}else{
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		}
		return GameStatus.RUN;
	}


}
