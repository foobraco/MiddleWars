package net.ayd2.middlewars.core.utils.mapgeneration;

public class Ant {
//"ant" or entity that transverses the map placing random tiles, it can move in 8 directions and has a life spawn of how many steps can it move before dying.
	int PositionX,PositionY,Type,Life;
	MapGenerator Mapa;
	
	public Ant(MapGenerator mp, int type, int life, int posx, int posy){
		this.Type=type;
		this.Life=life;
		this.PositionX=posx;
		this.PositionY=posy;
		this.Mapa=mp;
	}
	
	public void Update(float delta){
		
	}
	
	public boolean isAlive(){
		return false;
	}

	public int getLife(){
		return this.Life;
	}
	
	public void setLife(int value){
		this.Life=value;
	}
	
	public void subLife(){
		setLife(getLife()-1);
	}
	
}
