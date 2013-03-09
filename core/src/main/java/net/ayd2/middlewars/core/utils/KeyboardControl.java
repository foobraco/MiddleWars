package net.ayd2.middlewars.core.utils;

import static playn.core.PlayN.keyboard;
import net.ayd2.middlewars.core.Map;
import playn.core.Key;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;

public class KeyboardControl implements playn.core.Keyboard.Listener{
	Map mapa;
	public KeyboardControl(Map mapa){
		setMap(mapa);
		keyboard().setListener(this);
	}

	@Override
	public void onKeyDown(Event event) {
		//movement
		
	}
	@Override
	public void onKeyTyped(TypedEvent event) {
		
	}
	@Override
	public void onKeyUp(Event event) {
		//misc
		
	}
	
	void setMap(Map mp){
		this.mapa=mp;
	}
	
	Map getMap(){
		return this.mapa;
	}

}
