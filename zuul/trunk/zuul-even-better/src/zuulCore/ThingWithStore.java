package zuulCore;

import java.util.HashMap;
import java.util.Iterator;

import GameObjects.GameObject;

public class ThingWithStore {

	private HashMap<String , GameObject> store;
	public ThingWithStore(){
		store= new HashMap<String , GameObject>();	
	}
	
	public void itemRemove(String ObjektName){
		store.remove(ObjektName);
	}
	
	public void itemStore(GameObject item) {
		store.put(item.getObjName(), item);
	}
	public boolean hasObject(String Objektname){
		
		return store.containsKey(Objektname);

	}
	
	public GameObject getSpecialObject(String ObjektName){
		if(store.containsKey(ObjektName))
		{
		return store.get(ObjektName);
		}else{
			return new GameObject();
		}
		
	}
	public void getAllItems(){
		for(Iterator<String>  i = store.keySet().iterator(); i.hasNext(); ) {
			String isUsed =i.next();
			if(store.get(isUsed).isVisebility()){
        	Game.textOut.entry(isUsed + "  ");}
			
        }
        Game.textOut.lineEntry();
	}
	public boolean storeIsempty(){
		for(Iterator<String>  i = store.keySet().iterator(); i.hasNext(); ){
			if(store.get(i.next()).isVisebility()){
				return false;
			}
		}
		return true;
	}
}
