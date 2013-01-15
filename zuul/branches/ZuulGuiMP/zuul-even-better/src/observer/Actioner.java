package observer;

import java.util.Observable;

public class Actioner extends Observable{
	
	
		public Actioner() {

		}
		
		/**  
		 * die Methode die einen AktuellenString meldet
		 * @param something ein String der beobachtet wird
		 */
		public void changeString(String something) {
			setChanged();
			notifyObservers(something);

		}


}
