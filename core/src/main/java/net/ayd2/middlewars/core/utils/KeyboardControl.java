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
		// TODO Auto-generated method stub
		
		if(event.key().equals(Key.UP)){
			mapa.jugador1.arriba=true;
			mapa.jugador1.izquierda=false;
			mapa.jugador1.derecha=false;
			mapa.jugador1.abajo=false;
		}
		if(event.key().equals(Key.LEFT)){
			mapa.jugador1.izquierda=true;
			mapa.jugador1.derecha=false;
			mapa.jugador1.arriba=false;
			mapa.jugador1.abajo=false;
		}
		if(event.key().equals(Key.DOWN)){
			mapa.jugador1.abajo=true;
			mapa.jugador1.izquierda=false;
			mapa.jugador1.arriba=false;
			mapa.jugador1.derecha=false;
		}
		if(event.key().equals(Key.RIGHT)){
			mapa.jugador1.derecha=true;
			mapa.jugador1.izquierda=false;
			mapa.jugador1.arriba=false;
			mapa.jugador1.abajo=false;
		}
		if(event.key().equals(Key.X)){
			mapa.jugador1.attack=true;
		}
		
/*					if(event.key().equals(Key.LEFT)){
						mapa.touchVectorX-=Tile.Width;
					}
					if(event.key().equals(Key.RIGHT)){
						mapa.touchVectorX+=Tile.Width;
					}
					if(event.key(	).equals(Key.UP)){
						mapa.touchVectorY-=Tile.Width;
					}
					if(event.key().equals(Key.DOWN)){
						mapa.touchVectorY+=Tile.Width;
					}*/
	}				

	@Override
	public void onKeyTyped(TypedEvent event) {
		
	}
	@Override
	public void onKeyUp(Event event) {
		mapa.touchVectorX=mapa.touchVectorY=0;
		if(event.key().equals(Key.X)){
			mapa.jugador1.attack=false;
		}else{
			mapa.jugador1.derecha=false;
			mapa.jugador1.izquierda=false;
			mapa.jugador1.arriba=false;
			mapa.jugador1.abajo=false;
		}
		if(event.key().equals(Key.ENTER)){
			if(!mapa.hasStarted){
	  			mapa.hasStarted=true;
	  		}
		}
		
		if(event.key().equals(Key.P)){
			mapa.Pause=mapa.Pause ? false:true;
		}
	}
	
	void setMap(Map mp){
		this.mapa=mp;
	}
	
	Map getMap(){
		return this.mapa;
	}
	
	int getCollision(int x,int y){
		return mapa.tl.GetCollision(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().X)+x, mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().Y)+y);
	}

}
