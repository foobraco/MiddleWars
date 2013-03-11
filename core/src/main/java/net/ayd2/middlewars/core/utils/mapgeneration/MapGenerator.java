package net.ayd2.middlewars.core.utils.mapgeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.ayd2.middlewars.core.StaticTile;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;

public class MapGenerator {
	
	public MapGenerator(){
		
	}
	
	public TileMap GenerateMap(int x, int y, int base, float complexity){//the delegator
		TileMap tl=new RealGenerator().GenerateMapBit(x,y,base, complexity);	
		return tl;		
	}
	
}

class RealGenerator{//the delegate
	Tile[][] tilemap;
	TileMap GenerateMapBit(int x, int y,int base, float complexity){// size and type of terrain
		tilemap=new Tile[x][y];
		for(int sx=0;sx<x;sx++){
			for(int sy=0;sy<y;sy++){
						setTile(sx,sy,new StaticTile("",0,"",0));		
			}			
		}
		
		List<Ant> hormigas=new ArrayList<Ant>();
		//fill with ants
		int total= (int)((x*y)/((x+y)*complexity));		
		for(int xv=0;xv<total;xv++){
			int lifespawn=(int) (Math.random()*100);
			int size=(int) (Math.random()*Width());
			int height=(int) (Math.random()*Width());
			hormigas.add(new Ant(tilemap, 0, lifespawn,size ,height ));
		}		
		System.out.println("working with "+hormigas.size()+" ants");
		while(hormigas.size()>0){
			for(Ant hor: hormigas){
				if(hor.isAlive()){
					hor.Update(1);
				}else{
					hormigas.remove(hor);
					break;
				}
			}
		}
		
		TileMap tlmp=new TileMap(base, base, tilemap);	
		System.out.println("Map generated");
		return tlmp;
	}
	
	public Tile getTile(int x, int y){
			if (x < 0 || x >= Width() || y < 0 || y >= Height()) {
				return null;
			}
			return tilemap[x][y];	
	}
	public void setTile(int x, int y,Tile tl){
		tilemap[x][y]=tl;
	}
	
	public int Width() {
		return tilemap.length;
	}

	public int Height() {
		return tilemap[0].length;
	}
}