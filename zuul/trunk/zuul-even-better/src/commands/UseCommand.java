package commands;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

public class UseCommand extends Command {
	 public UseCommand()
	    {
	    }

	    /** 
	     * Versuche in einen Raum zu gehen, wenn ein Ausgang vorhanden ist.
	     * ,der Spieler die richtige Grösse hat und der Raum nicht verschlossen ist
	     * erfolgreich gehe in den Raum
	     * wenn das nicht möglich ist schreibe Error Nachricht. Returnt immer Gamestatus RUN
	     */
	    public GameStatus execute(Player player)
	    {
	        if(hasSecondWord()) {
	        	//Vereinfachung wenn 3. wort vorhanden ist. Idee. Abfangen der 2 wörter. Üperprüfen ob sie vorhanden sind. Wenn nicht. 
	        	// Pech gehabt^^' --> User Proplem: Er kann Gegenstände Unbestimmt Reihenfolge nutzen.
	        	/*
	        	if((item1.getObjName().equals("flower")&&item2.getObjName().equals("blumea"))
	        	||(item2.getObjName().equals("flower")&&item1.getObjName().equals("blumea"))) { */	
	        	
	        	for(int i=0; i<player.getCurrentRoom().getWarehouse().size();i++) {
	        		if(player.getCurrentRoom().getWarehouse().get(i).getObjName().equals("flower")) {
	        			player.getCurrentRoom().getWarehouse().remove(i);	
	        		}
	        	}
	        	
	        	for(int j=0; j<player.getInventory().size();j++) {
	        		if(player.getInventory().get(j).getObjName().equals("flower")) {
	        			player.getInventory().remove(j);	
	        		}
	        	}
        	
	        	for(int k=0; k<player.getCurrentRoom().getWarehouse().size();k++) {
	        		if(player.getCurrentRoom().getWarehouse().get(k).getObjName().equals("blumea")) {
	        				player.getCurrentRoom().getWarehouse().remove(k);		
	        			}	
	        	}	
	        	
	        	for(int l=0; l<player.getInventory().size();l++) {
	        		if(player.getInventory().get(l).getObjName().equals("blumea")) {
	        			player.getInventory().remove(l);	
	        		}
	        	}
	        	
	        	player.getInventory().add(new GameObject("Blumenstrauß", "Ein Blumenstrauß aus den Blumen des Brunnens", false,false));
	        	System.out.println("FLOWER UND BLUME DIGITIEEERRREENN ZUUUMM BLUMENSTRAUß O_O");
	        	
	        	
	        	
	        }
	        else {
	            System.out.println("Wie soll ich das benutzen?");
	        }
	        return GameStatus.RUN;
	    }

		@Override
		public void showSpecialHelp() {
			//Ausgabe wenn die Hilfe zu diesem Kommand abgefragt wird
			System.out.println("mäh sinnvollere Erläuterung hier einfügen martin xD");
			
		}
}
