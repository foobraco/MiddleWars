package net.ayd2.middlewars.core;

import static playn.core.PlayN.*;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.ImmediateLayer;
import playn.core.Surface;

public class MiddleWars implements Game {
	private ImmediateLayer layer;
	Tile[][] tilemap;
	public static Image[] imagemap= new Image[3];
	TileMap tl;
  @Override
  public void init() {
	
    // create and add background image layer
    Image bgImage = assets().getImage("images/bg.png");
    imagemap[0]=assets().getImage("images/0.png");
    imagemap[1]=assets().getImage("images/1.png");
    imagemap[2]=assets().getImage("images/2.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);
    MapGenerator mpg = new MapGenerator();
    tilemap=mpg.GenerateMap(800, 600, 0,50).getTilemap();
    tl=new TileMap(800, 600, tilemap);
    
    layer = graphics().createImmediateLayer(800,600,new ImmediateLayer.Renderer() {
		@Override
		public void render(Surface surface) {
			int w=0,h=0;
			  for(int x=0;x<800;x++){
				  for(int y=0;y<600;y++){
				  surface.drawImage(imagemap[Integer.parseInt(tilemap[x][y].name)], x*10, y*10);
				  }
			  }
			  h=w=0;
		}
	});
    graphics().rootLayer().add(layer);
  }

  @Override
  public void paint(float alpha) {
	  
  }

  @Override
  public void update(float delta) {
	  
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
