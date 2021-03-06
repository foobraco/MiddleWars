package net.ayd2.middlewars.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

import java.util.ArrayList;
import java.util.List;

import playn.core.CanvasImage;
import playn.core.ImmediateLayer;
import playn.core.Surface;
import net.ayd2.middlewars.core.actors.Enemy;
import net.ayd2.middlewars.core.actors.Player;
import net.ayd2.middlewars.core.actors.PlayerAttack;
import net.ayd2.middlewars.core.utils.Camara;
import net.ayd2.middlewars.core.utils.KeyboardControl;
import net.ayd2.middlewars.core.utils.PointerControls;
import net.ayd2.middlewars.core.utils.Screen;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.Vector2;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;
import tripleplay.util.Hud;

public class Map extends Screen{
	private ImmediateLayer layer;
	Tile[][] tilemap;
	public TileMap tl;
	Camara cam;
	public Player jugador1;
	int w,h,t,c;
	Hud.Stock hud;
	List<Enemy> Enemigos=new ArrayList<Enemy>();
	List<PlayerAttack> Attack=new ArrayList<PlayerAttack>();
	CanvasImage title;
	CanvasImage hp;
	CanvasImage oxy;
	CanvasImage Info;
	int wood;
	public boolean hasStarted,Pause;
	
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
	    MiddleWars.imagemap[5]=assets().getImage("images/p0.png");
	    MiddleWars.imagemap[6]=assets().getImage("images/attack.png");
	    MiddleWars.imagemap[7]=assets().getImage("images/sw.png");
	    MiddleWars.imagemap[8]=assets().getImage("images/p0W.png");
	    MiddleWars.imagemap[9]=assets().getImage("images/heart.png");
	    MiddleWars.imagemap[10]=assets().getImage("images/oxy.png");

	    MapGenerator mpg = new MapGenerator();
	    tilemap=mpg.GenerateMap(w, h, t,c).getTilemap();
	    //player gets a type, for now defaults to 0 please.
	    tl=new TileMap(graphics().width(), graphics().height(), tilemap);

	    jugador1 =new Player(0,  getRandomStartPos(),this);
	    cam=new Camara(null, jugador1.getPosition());
	    cam.setPosition(new Vector2(graphics().width()/2,graphics().height()/2));
	    title=graphics().createImage(400, 200);
	    title.canvas().setFillColor(0xffffffff);
		title.canvas().setStrokeWidth(2);
		title.canvas().setStrokeColor(0xfffffff);
		title.canvas().drawText("Press Enter", 20, 40);
		title.canvas().fillText(graphics().layoutText("After a shipwreck you wake up on a mysterious island.", MiddleWars.format), 20,40);
		title.canvas().fillText(graphics().layoutText("Its inhabitants are somewhat hostile, try to survive...", MiddleWars.format), 20,60);		
	
		for(int x=0;x<20;x++){
			Enemigos.add(new Enemy(x, getRandomStartPos(), this));
		}
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
				surface.clear();
			if(!jugador1.dead)	{
				if(hasStarted){
				tl.DrawTiles(surface);
				for(Enemy en: getEnemigos()){
					en.draw(surface, tl.getOffsets());
			  }
			  for(PlayerAttack en: getAttacks()){
				  en.draw(surface, tl.getOffsets());			  
				  }
				jugador1.draw(surface, tl.getOffsets());

			  DrawHUD(surface);
			  
			  if(Pause){
				   title=graphics().createImage(100, 100);
				    title.canvas().setFillColor(0xffffffff);
					title.canvas().setStrokeWidth(2);
					title.canvas().setStrokeColor(0xfffffff);
					title.canvas().drawText("Pause", 10, 10);
					surface.drawImage(title, 300, 250);
			  }
			  
			  }else{
				  surface.drawImage(title, 150, 150);
			  }
			}else{
				title=graphics().createImage(100, 100);
			    title.canvas().setFillColor(0xffffffff);
				title.canvas().setStrokeWidth(2);
				title.canvas().setStrokeColor(0xfffffff);
				title.canvas().drawText("GameOver", 10, 10);
				surface.drawImage(title, 300, 250);
			}
			}
			
		});
		layer.setAlpha(1f);
	    graphics().rootLayer().add(layer);
	    
	    hud=new Hud.Stock();
    	hud.layer.setDepth(Short.MAX_VALUE);
    	hud.layer.setAlpha(0.75f);
		graphics().rootLayer().addAt(hud.layer, 660, 0);

		new KeyboardControl(this);
		new PointerControls(this);
	}

	void DrawHUD(Surface surface){
		int life=(int)Math.ceil((int)this.jugador1.getLife()/10);
		for(int x=0;x<life;x++){
			surface.drawImage(MiddleWars.imagemap[9], (x*20)+10, 10);
		}
		if(jugador1.OnWater){
			int ox=(int)Math.ceil((int)this.jugador1.getOxy()/10);
			for(int x=0;x<ox;x++){
				surface.drawImage(MiddleWars.imagemap[10], (x*20)+10, 30);
			}
		}
	}
	
	@Override
	public void Update(float delta) {
	if(!Pause){
		if(!jugador1.dead){
		  hud.update(delta);
		  cam.update_position(new Vector2(touchVectorX,touchVectorY));
		  jugador1.update(delta);
		  cam.setPosition(jugador1.getPosition());
		  tl.UpdateOffsets(cam);
		  for(Enemy en: getEnemigos()){
				if(en.removeMe()){
			  		getEnemigos().remove(en);
			  		break;
			  	}
				en.update(delta);
		  }
		  for(PlayerAttack en: getAttacks()){
			  	if(en.removeMe()){
			  		getAttacks().remove(en);
			  		break;
			  	}
				en.update(delta);
		  }
		}
	}
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
	  
	 public TileMap getTileMap(){return this.tl;}
	 public List<Enemy> getEnemigos(){return this.Enemigos;}
	 public List<PlayerAttack> getAttacks(){return this.Attack;}
	 
	 public void food(){
		 System.out.println("found some food!");
		 jugador1.subsLife(-10);
	 }
	 public void wood(){
		 System.out.println("found wood!");
	 }
}
