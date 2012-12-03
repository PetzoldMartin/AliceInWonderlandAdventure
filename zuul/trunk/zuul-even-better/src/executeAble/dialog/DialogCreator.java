package executeAble.dialog;

import java.util.HashMap;



public class DialogCreator {
	private HashMap<String, Dialog> dialogs;
	
	public DialogCreator() {
		dialogs = new HashMap<String,Dialog>();
	}
	
	public Dialog getDialog(String dialogName){
		return dialogs.get(dialogName);
	}
	
	public void intintialtheDialogcreator(){
		dialogs.put("Kaninchen", new Dialog());
		dialogs.put("Hutmacher", new Dialog());
		dialogs.put("Katze", new Dialog());
		dialogs.put("Feuergeist", new Dialog());
		dialogs.put("Schneemann", new Dialog());
	}
}
