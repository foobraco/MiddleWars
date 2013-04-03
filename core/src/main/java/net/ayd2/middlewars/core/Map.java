package net.ayd2.middlewars.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.ImmediateLayer;
import playn.core.Surface;
import net.ayd2.middlewars.core.actors.Player;
import net.ayd2.middlewars.core.utils.Camara;
import net.ayd2.middlewars.core.utils.KeyboardControl;
import net.ayd2.middlewars.core.utils.Screen;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.TouchControl;
import net.ayd2.middlewars.core.utils.Vector2;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;

public class Map extends Screen{
	private ImmediateLayer layer;
	Tile[][] tilemap;
	public TileMap tl;
	Camara cam;
	public Player jugador1;
	int w,h,t,c;
	public  float touchVectorX, touchVectorY;
	public Map(String data){
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
		 type=valores[5].replace("[", "");
		 type=type.replace("]", "");
		 String[] size=type.split(",");
		 w=Integer.parseInt(size[0]);
		 h=Integer.parseInt(size[1]);
		 System.out.println(valores[7]);
		 type=valores[7].replace("[", "");
		 type=type.replace("]", "");
		 c=Integer.parseInt(type);
		// create and add background image layer
	    MiddleWars.imagemap[0]=assets().getImage("images/0.png");
	    MiddleWars.imagemap[1]=assets().getImage("images/1.png");
	    MiddleWars.imagemap[2]=assets().getImage("images/2.png");
	    MiddleWars.imagemap[3]=assets().getImage("images/p0.png");
	    MiddleWars.imagemap[4]=assets().getImage("images/p1.png");
	    MiddleWars.imagemap[5]=assets().getImage("images/e0.png");

	    MapGenerator mpg = new MapGenerator();
	    tilemap=mpg.GenerateMap(w, h, t,c).getTilemap();
	    //player gets a type, for now defaults to 0 please.
	    
	    tl=new TileMap(graphics().width(), graphics().height(), tilemap);

	    jugador1 =new Player(0,  getRandomStartPos());
	    cam=new Camara(null, jugador1.getPosition());
	    cam.setPosition(new Vector2(graphics().width()/2,graphics().height()/2));
	}
	
		Vector2 getRandomStartPos(){
			int x,y;
			x=(int)(Math.random()*tl.Width());
			y=(int)(Math.random()*tl.Height());
			if(tl.GetCollision(x,y)==1){
				return new Vector2(tl.tilesToPixelsX(x),tl.tilesToPixelsX(y));
			}
			return getRandomStartPos();
		}
		
	@Override
	public String name() {
		
		
		return null;
	}

	@Override
	public void Init() {
	    layer = graphics().createImmediateLayer(800,600,new ImmediateLayer.Renderer() {
			@Override
			public void render(Surface surface) {
				tl.DrawTiles(surface);
				jugador1.draw(surface, tl.getOffsets());
			}
		});
	    graphics().rootLayer().add(layer);
	    
		new KeyboardControl(this);
		new TouchControl(this);
	}

	@Override
	public void Update(float delta) {
		  cam.update_position(new Vector2(touchVectorX,touchVectorY));
		  cam.setPosition(jugador1.getPosition());
		  tl.UpdateOffsets(cam);
	}

	@Override
	public void shutdown() {
		
	}

	@Override
	public void Draw(float delta) {
	}
	  public void touchMove(float x, float y) {
		    float cx = graphics().width() / 2;
		    float cy = graphics().height() / 2;
		    touchVectorX = (x - cx) * Tile.Width / cx;
		    touchVectorY = (y - cy) * Tile.Width / cy;
	  }
}
