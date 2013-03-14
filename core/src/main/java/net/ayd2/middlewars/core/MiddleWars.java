package net.ayd2.middlewars.core;

import static playn.core.PlayN.*;
import net.ayd2.middlewars.core.utils.Camara;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.Vector2;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;
import playn.core.Key;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;
import playn.core.Pointer;
import playn.core.Keyboard;
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
	Camara cam;
	int w,h,t,c;
	 float touchVectorX, touchVectorY;
	 
	 public MiddleWars(String data){
		 String[] valores=data.split(" ");
		 String type;
		 type=valores[1].replace("[", "");
		 type=type.replace("]", "");
		 if(type.equalsIgnoreCase("water")){
			 t=0;
		 }else if(type.equalsIgnoreCase("forest")){
			 t=2;
		 }else if (type.equalsIgnoreCase("desert")){
			 t=1;
		 }
		 System.out.println(type);

		 System.out.println(valores[5]);
		 type=valores[5].replace("[", "");
		 type=type.replace("]", "");
		 String[] size=type.split(",");
		 w=Integer.parseInt(size[0]);
		 h=Integer.parseInt(size[1]);
		 
		 System.out.println(valores[7]);
		 
		 type=valores[7].replace("[", "");
		 type=type.replace("]", "");
		 
		 c=Integer.parseInt(type);
	 }
	 
	 
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
    tilemap=mpg.GenerateMap(w, h, t,c).getTilemap();
    cam=new Camara(null, new Vector2(graphics().width()/2,graphics().height()/2));
    tl=new TileMap(w, h, tilemap);
    cam.setPosition(new Vector2(graphics().width()/2,graphics().height()/2));
    
    pointer().setListener(new Pointer.Listener() {
        @Override
        public void onPointerEnd(Pointer.Event event) {
          touchVectorX = touchVectorY = 0;
        }
        @Override
        public void onPointerCancel(Pointer.Event event) {
          touchVectorX = touchVectorY = 0;
        }
        @Override
        public void onPointerDrag(Pointer.Event event) {
          touchMove(event.x(), event.y());
        }
        @Override
        public void onPointerStart(Pointer.Event event) {
          touchMove(event.x(), event.y());
        }
      });
    
    
    keyboard().setListener(new Keyboard.Listener() {
		@Override
		public void onKeyDown(Event event) {
			// TODO Auto-generated method stub
			if(event.key().equals(Key.LEFT)){
				touchVectorX-=Tile.Width;
			}
			if(event.key().equals(Key.RIGHT)){
				touchVectorX+=Tile.Width;
			}
			if(event.key(	).equals(Key.UP)){
				touchVectorY-=Tile.Width;
			}
			if(event.key().equals(Key.DOWN)){
				touchVectorY+=Tile.Width;
			}
		}

		@Override
		public void onKeyTyped(TypedEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onKeyUp(Event event) {
			// TODO Auto-generated method stub
			touchVectorX=touchVectorY=0;
		}
       
      });
    
    
    layer = graphics().createImmediateLayer(800,600,new ImmediateLayer.Renderer() {
		@Override
		public void render(Surface surface) {
			tl.DrawTiles(surface);
		}
	});
    graphics().rootLayer().add(layer);
    
    
  }
  
  private void touchMove(float x, float y) {
	    float cx = graphics().width() / 2;
	    float cy = graphics().height() / 2;

	    touchVectorX = (x - cx) * Tile.Width / cx;
	    touchVectorY = (y - cy) * Tile.Width / cy;
	  }

  @Override
  public void paint(float alpha) {
	  
  }

  @Override
  public void update(float delta) {	  
	  cam.update_position(new Vector2(touchVectorX,touchVectorY));
	  tl.UpdateOffsets(cam);
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
