package gameBuilding;

import java.util.HashMap;

import executeAble.commands.DialogCommand;



public class DialogCreator {
	private HashMap<String, DialogCommand> dialogs;
	
	public DialogCreator() {
		dialogs = new HashMap<String,DialogCommand>();
		intintialtheDialogcreator();
	}
	
	public DialogCommand getDialog(String dialogName){
		return dialogs.get(dialogName);
	}
	
	public void intintialtheDialogcreator(){
		//Dialog dess Kaninchens
		DialogCommand kaninchen =new DialogCommand("Kaninchen will reden");
		DialogCommand kaninchen1=new DialogCommand("test","ich sehe du hast den ersten test bestanden");
		DialogCommand kaninchen2=new DialogCommand("was soll ich als nächstes tun?","geh nach Westen und Sammle die Blaue beere ein");
		kaninchen.insertDialog(kaninchen1);
		kaninchen.insertDialog(kaninchen2);
		kaninchen1.insertDialog(kaninchen);
		kaninchen2.insertDialog(kaninchen);
		
		
		dialogs.put("Kaninchen", kaninchen);
		
		
		
		dialogs.put("Hutmacher", new DialogCommand(""));
		dialogs.put("Katze", new DialogCommand(""));
		dialogs.put("Feuergeist", new DialogCommand(""));
		dialogs.put("Schneemann", new DialogCommand(""));
	}
}
