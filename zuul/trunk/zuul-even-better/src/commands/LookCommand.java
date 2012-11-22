package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

public class LookCommand extends Command{

    public LookCommand()
    {
    }


    public GameStatus execute(Player player)
    {
        boolean contain;
    	if(hasSecondWord()) {
    		contain =false;
    		//inventar
    			if(getSecondWord().equals("inventar")) {
    				if(player.getInventory().size()==0) {
    					System.out.print("Ich habe kein Inventar");
    					contain = true;
    				}
    				else {

	    				System.out.print("In dein Inventar befindet sich: ");
	    				for(int i=0; i<player.getInventory().size();i++) {
	    	        		System.out.print(player.getInventory().get(i).getObjName());
	    	        		if(!(player.getInventory().size()==(i-1))){
	    	        			System.out.print(", ");
	    	        		}
	    	        		contain=true;
	    				}
    					
    				}
    				System.out.println(".");
    			}
    			//Raum anzeigen
    			if(getSecondWord().equals("room")) {
    				if(player.getCurrentRoom().getWarehouse().size()==0) {
    					System.out.print("Der Raum ist Leer");
    					contain = true;
    				}
    				else {
	    				System.out.print("Im Raum erkennst du: ");
	    				for(int i=0; i<player.getCurrentRoom().getWarehouse().size();i++) {
	    	        		System.out.print(player.getCurrentRoom().getWarehouse().get(i).getObjName());	
	    	        		if(player.getCurrentRoom().getWarehouse().size()!=(i-1)){
	    	        			System.out.print(", ");
	    	        		}
	    	        		contain=true;
	    				}
						
					}
    				System.out.println(".");
    			}
        	//beschreibung invetar gegestand
	        	for(int j=0; j<player.getInventory().size();j++) {
	        		if(player.getInventory().get(j).getObjName().equals(getSecondWord())) {
	        			System.out.println(player.getInventory().get(j).getAmplification());	
	        			contain=true;
	        		}
	
	        	}
        	//beschreibung gegenstand room
	        	for(int k=0; k<player.getCurrentRoom().getWarehouse().size();k++) {
	        		if(player.getCurrentRoom().getWarehouse().get(k).getObjName().equals(getSecondWord())) {
	        			System.out.println(player.getCurrentRoom().getWarehouse().get(k).getAmplification());		
	        			contain=true;
	        			}	
	        	}
	        if(!contain) {
	        	System.out.println("Gegenstand ist nicht vorhanden.");
	        }
	        
        }
            
        else {
            //Ausgabe, das das 2. Wort fehlt. (Richtung)
            System.out.println("Was soll ich den Betrachten?");
        }
        return GameStatus.RUN;
    }

	@Override
	public void showSpecialHelp() {
		//Ausgabe wenn die Hilfe zu diesem Kommand abgefragt wird
		System.out.println("Nutze Guck um Gegenstände genauer zu betrachten! ");
		System.out.println("Um dein Inventar anzuschaun nutz >Guck inventar< !");
		System.out.println("Um dein Raum anzuschaun nutz >Guck room< !");
	}
}
