package commands;

import java.util.ArrayList;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

public class UseCommand extends Command {
	
	private int indexa;
	private int indexb;
	
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
	    	indexb = indexa = -1;
			
			 
	        if(hasSecondWord()&&hasThirdWord()) {
	        	
	        	//if((itemExistent(player.getInventory()))&&(itemExistent(player.getCurrentRoom().getWarehouse()))) {
	        	if(itemExistent(player.getInventory(),player.getCurrentRoom().getWarehouse())) {
	        	
	        		System.out.print("Items da. Index gespeichert.");
	        		ItemManipulation(player);
	        
	        	}
	        	else {
	        		System.out.println("Items find ich nicht "+indexa+" "+indexb);
	        		
	        	}
	        	
	        	
	        	
	 
	        	
	        }
	        else {
	            System.out.println("Wie soll ich das benutzen?");
	        }
	        return GameStatus.RUN;
	    }

		@Override
		public void showSpecialHelp() {
			//Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
			System.out.println("mäh sinnvollere Erläuterung hier einfügen martin xD");
			
		}
		
		private boolean itemExistent(ArrayList<GameObject> a1,ArrayList<GameObject> a2) {

			for(int i=0; i<a2.size();i++) {
        		if(a2.get(i).getObjName().equals(getSecondWord())) {
        			IndexSetter(i);	
        		}
        	}

        	for(int j=0; j<a1.size();j++) {
        		if(a1.get(j).getObjName().equals(getSecondWord())) {
        			IndexSetter(j);		
        		}
        	}
    	
        	for(int k=0; k<a2.size();k++) {
        		if(a2.get(k).getObjName().equals(getThirdWord())) {
        			IndexSetter(k);		
        			}	
        	}	
        	
        	for(int l=0; l<a1.size();l++) {
        		if(a1.get(l).getObjName().equals(getThirdWord())) {
        			IndexSetter(l);
        		}
        	}
        	
        	if(!(indexa<0)&&!(indexb<0)) {
        		return true;
        	}
			return false;
		}
		
		private void ItemManipulation(Player player) {
			
			if(wordsEqualSimple("flower","blumea")){
				// Methode die die array Listen übergibt. Dort wird rausgesucht welches element sich wo befindet und die zu verwendete arrraylist bla
			}
			else if(wordsEqualSimple("Moehre", "Kaninchen")) {
				
			}
			
		}

		private boolean wordsEqualSimple(String s1,String s2){
			
			if(((getThirdWord().equals(s1))&&(getSecondWord().equals(s2)))
					||((getThirdWord().equals(s2))&&(getSecondWord().equals(s1)))) {
				return true;
			}
			return false;
		}		
		
		private void IndexSetter(int i) {
			if(indexa<0) {
				indexa=i;
			}
			else {
				indexb=i;
			}
		}
		

		
}
