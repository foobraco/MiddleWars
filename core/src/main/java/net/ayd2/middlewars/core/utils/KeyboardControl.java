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
			if(getCollision(0,-1)!=2&&getCollision(0,-1)!=-1){
				mapa.jugador1.setPosition(new Vector2(mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().X)),mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().Y)-1)));
			}
		}
		if(event.key().equals(Key.LEFT)){
			if(getCollision(-1,0)!=2&&getCollision(-1,0)!=-1){
				mapa.jugador1.setPosition(new Vector2(mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().X)-1),mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().Y))));

			}
		}
		if(event.key().equals(Key.DOWN)){
			if(getCollision(0,1)!=2&&getCollision(0,1)!=-1){
				mapa.jugador1.setPosition(new Vector2(mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().X)),mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().Y)+1)));
			}
		}
		if(event.key().equals(Key.RIGHT)){
			if(getCollision(1,0)!=2&&getCollision(1,0)!=-1){
				mapa.jugador1.setPosition(new Vector2(mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().X)+1),mapa.tl.tilesToPixelsX(mapa.tl.pixelsToTilesX(mapa.jugador1.getPosition().Y))));
			}
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
