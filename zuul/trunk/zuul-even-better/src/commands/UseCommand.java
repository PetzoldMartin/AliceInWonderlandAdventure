package commands;

import gameBuilding.UsableCreator;

import java.util.ArrayList;

import zuulCore.Game;
import zuulCore.Player;
import zuulCore.TextOut;



import GameObjects.GameObject;
import GamePlayEnums.GameStatus;

public class UseCommand extends Command {
	
	private int indexa;
	private int indexb;
	private ArrayList<Object> useList;
	
	 public UseCommand()
	    {
		 super();
		 indexa = -1;
		 indexb = -1;
	    }

	    /** 
	     * Versuche in einen Raum zu gehen, wenn ein Ausgang vorhanden ist.
	     * ,der Spieler die richtige Größe hat und der Raum nicht verschlossen ist
	     * erfolgreich gehe in den Raum
	     * wenn das nicht möglich ist schreibe Error Nachricht. Returns immer Gamestatus RUN
	     */
	    public GameStatus execute(Player player)
	    {
	    	useList = player.getUC().getUseAbleList();
	    	indexb = indexa = -1;
			
			 
	        if(hasSecondWord()&&hasThirdWord()) {
	        	
	        	//if((itemExistent(player.getInventory()))&&(itemExistent(player.getCurrentRoom().getWarehouse()))) {
	        	if(itemExistent(player.getInventory(),player.getCurrentRoom().getWarehouse())) {
	        		boolean breaker=false;
	    			for(int i=0;i<(useList.size());i+=4) {
	    			
	    				if(useList.get(i).equals(getSecondWord())) {
	    					if(useList.get(i+1).equals(getThirdWord())) {
	    						remover(player, (String) useList.get(i));
	    						remover(player, (String) useList.get(i+1));
	    						itemManipulation(player,(int)useList.get(i+2),(String)useList.get(i+3));
	    						breaker = true;
	    					}
	    				}
	    				if(useList.get(i).equals(getThirdWord())) {
	    					if(useList.get(i+1).equals(getSecondWord())) {
	    						remover(player, (String) useList.get(i));
	    						remover(player, (String) useList.get(i+1));
	    						itemManipulation(player,(int)useList.get(i+2),(String)useList.get(i+3));
	    						breaker = true;    						
	    					}
	    				}
	    				if(breaker) {
	    					break;
	    				}
	    			}
	        		
	        
	        	}
	        	else {
	        		Game.textOut.lineEntry("Items find ich nicht "+indexa+" "+indexb);
	        		
	        	}
	        	
	        	
	        	
	 
	        	
	        }
	        else {
	        	Game.textOut.lineEntry("Wie soll ich das benutzen?");
	        }
	        return GameStatus.RUN;
	    }

		private void remover(Player pl,String object) {
			for (int j = 0; j < pl.getInventory().size(); j++) {
					if(pl.getInventory().get(j).getObjName().equals(object)) {
						pl.getInventory().remove(j);		
					}		
			}
			for (int i = 0; i < pl.getCurrentRoom().getWarehouse().size(); i++) {
				if(pl.getCurrentRoom().getWarehouse().get(i).getObjName().equals(object)) {
					pl.getCurrentRoom().getWarehouse().remove(i);		
				}		
			}
		}

		@Override
		public void showSpecialHelp() {
			//Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
			Game.textOut.lineEntry("Commando zum kombinieren von Gegenständen");
			
		}
		
		private boolean itemExistent(ArrayList<GameObject> a1,ArrayList<GameObject> a2) {

			for(int i=0; i<a2.size();i++) {
        		if(a2.get(i).getObjName().equals(getSecondWord())) {
        			indexSetter(i);	
        		}
        	}

        	for(int j=0; j<a1.size();j++) {
        		if(a1.get(j).getObjName().equals(getSecondWord())) {
        			indexSetter(j);		
        		}
        	}
    	
        	for(int k=0; k<a2.size();k++) {
        		if(a2.get(k).getObjName().equals(getThirdWord())) {
        			indexSetter(k);		
        			}	
        	}	
        	
        	for(int l=0; l<a1.size();l++) {
        		if(a1.get(l).getObjName().equals(getThirdWord())) {
        			indexSetter(l);
        		}
        	}
        	
        	if(!(indexa<0)&&!(indexb<0)) {
        		return true;
        	}
			return false;
		}
		

		private void itemManipulation(Player player,int x, String s) {
			int i=-1;
			switch (x) {
			case 1:
				i = indexChecker(player.getCurrentRoom().getWarehouse(), s);
				if(i<0) {
					Game.textOut.lineEntry("Error Bei Itemnutzung!");
				}
				else {
				player.getCurrentRoom().getWarehouse().get(i).setVisebility(true);
					Game.textOut.lineEntry("Etwas neues ist im Raum!");
				}
				break;
			case 2:
				
				break;
			case 3:

				
				break;
			case 4:
				
				break;
			default:
				Game.textOut.lineEntry("Fehlerhaftes Itemnutzen");
				break;
			}
			
		}

		private void indexSetter(int i) {
			if(indexa<0) {
				indexa=i;
			}
			else {
				indexb=i;
			}
		}
		
		private int indexChecker(ArrayList<GameObject> aL, String s) {
			
			for (int i = 0; i < aL.size(); i++) {
				if(aL.get(i).getObjName().equals(s)) {
					
					return i;			
				}
			}	
			return -1;	
		}
		
}
