package net.ayd2.middlewars.core.utils.mapgeneration;

import net.ayd2.middlewars.core.utils.TileMap;

public class MapGenerator {
	
	public MapGenerator(){
		
	}
	
	public TileMap GenerateMap(int x, int y, int base){//the delegator
		TileMap tl=new RealGenerator().GenerateMapBit(x,y,base);	
		return tl;		
	}
	
}

class RealGenerator{//the delegate
	
	TileMap GenerateMapBit(int x, int y,int base){// size and type of terrain
		
		
		return null;
	}
	
}