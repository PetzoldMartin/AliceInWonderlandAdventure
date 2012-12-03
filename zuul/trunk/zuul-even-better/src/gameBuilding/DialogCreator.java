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
		//Urdialog
		DialogCommand kaninchen =new DialogCommand("Grüße dich Allis");
		dialogs.put("Kaninchen", kaninchen);
			//Dialogebene 1
			DialogCommand kaninchen1=new DialogCommand("Wo bin ich?","du bist mir gefolgt und in den Brunnen gefallen.");
			DialogCommand kaninchen2=new DialogCommand("Was soll ich als nächstes tun?","Geh nach Westen und Sammle die Blaue beere ein.");
			DialogCommand kaninchen3=new DialogCommand("Wer bist du?", "Ich bin nicht der Schmunzelhase und habe keine Zeit.");
			kaninchen.insertDialog(kaninchen1);
			kaninchen.insertDialog(kaninchen2);
			kaninchen.insertDialog(kaninchen3);
				//Dialogebene 1.1
			
			
			
				//Dialogebene 1.2
				DialogCommand kaninchen2u1=new DialogCommand("OK das werde ich! Was macht die BlaueBeere?", "Sie Lässt dich schrumpfen aber...");
				kaninchen2.insertDialog(kaninchen2u1);
					//Dialogebene 1.2.1
					DialogCommand kaninchen2u1u1=new DialogCommand("Aber was?", "Nutze sie nur wenn du sie brauchst sie hält nur...");
					kaninchen2u1.insertDialog(kaninchen2u1u1);
						//Dialogebene 1.2.1.1
						DialogCommand kaninchen2u1u1u1=new DialogCommand("Hält nur Was??? Rede in ganzen Sätzen.", "Hält nur so Lange wie du brauchst um einen Raum zu durchqueren!");
						kaninchen2u1u1.insertDialog(kaninchen2u1u1u1);
		
				//Dialogebene 1.3
				DialogCommand kaninchen3u1=new DialogCommand("Jetzt mal ehrlich wer bist du?", "na was wohl ich bin ein Kaninchen und Weiss...");
				kaninchen3.insertDialog(kaninchen3u1);
					//Dialogebene 1.3.1
					DialogCommand kaninchen3u1u1=new DialogCommand("Der Essenkehrer!!","Mann bist du Doof!!");
					DialogCommand kaninchen3u1u2=new DialogCommand("Das Weiße Kaninchen","Richtig!!");
					kaninchen3u1.insertDialog(kaninchen3u1u1);
					kaninchen3u1.insertDialog(kaninchen3u1u2);
					
		//Möglichkeit der Rückehr zum AnfangsDialog erstellt
		kaninchen1.insertDialog(kaninchen);
		kaninchen2u1u1u1.insertDialog(kaninchen);
		kaninchen3u1u2.insertDialog(kaninchen);
		
		
		
		
		dialogs.put("Hutmacher", new DialogCommand("Hallo Allis ich habe dich erwartet."));
		dialogs.put("Katze", new DialogCommand("Hihihi na da bist ja Allis hat ja lange gedauert"));
		dialogs.put("Feuergeist", new DialogCommand("Hui ich bin der Geist, der im Kamin Wohnt..wo kommst du den her."));
		dialogs.put("Schneemann", new DialogCommand("Ein eisiges Hallo ***Oh du Fröhliche****"));
	}

	public boolean hasDialog(String secondWord) {
		return dialogs.containsKey(secondWord);
	}
}
