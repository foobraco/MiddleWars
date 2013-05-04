package net.ayd2.middlewars.core.actors;

import playn.core.Surface;
import net.ayd2.middlewars.core.Map;
import net.ayd2.middlewars.core.MiddleWars;
import net.ayd2.middlewars.core.items.BareFists;
import net.ayd2.middlewars.core.utils.Animation;
import net.ayd2.middlewars.core.utils.Entity;
import net.ayd2.middlewars.core.utils.Rectangle;
import net.ayd2.middlewars.core.utils.Tile;

import net.ayd2.middlewars.core.utils.Vector2;

public class Player extends Entity{
	int clase;
	Map world;
	int orientation;
	float life;
	float oxygen;
	public boolean arriba, abajo, izquierda, derecha,attack,OnWater,dead;
	public Player(int cl,Vector2 position,Map mundo){
		this.clase=cl;
		setPosition(position);
		setItem(new BareFists(this,1));
		world=mundo;
		loadContent();
		life=100;
		oxygen=100;
	}
	
	@Override
	public void loadContent() {
		up=new Animation(MiddleWars.imagemap[5], 5f, 30f, true);
		down=new Animation(MiddleWars.imagemap[8], 5f, 30f, true);
		int width = (int) (30);
		int left = (int) (30 - width) / 2;
		int height = (int) (20);
		int top = (int) (10);
		this.setBounds(new Rectangle(left,top,width,height, 1));
		amp.PlayAnimation(up);
	}

	@Override
	public void update(float delta) {
		if(getLife()<=0){
			this.dead=true;
		}
		if(OnWater){
			amp.PlayAnimation(down);
			subsOxy(0.1f);
			if(this.getOxy()<0){
				subsLife(0.1f);
			}
		}else{
			amp.PlayAnimation(up);
			this.oxygen=100;
		}
		amp.updateAnimation(delta/100);
			if(arriba)
			setPosition(new Vector2(getPosition().X,getPosition().Y-2f));
			if(izquierda)
			setPosition(new Vector2(getPosition().X-2f,getPosition().Y));
			if(abajo)
			setPosition(new Vector2(getPosition().X,getPosition().Y+2f));
			if(derecha)
			setPosition(new Vector2(getPosition().X+2f,getPosition().Y));
			if(attack){
				action();attack=false;}
		collisions();
	}
	
	@Override
	public void draw(Surface surf, Vector2 offsets) {
		amp.Draw(surf, getPosition().add(offsets));
	}

	@Override
	public void action() {
		if(!OnWater){
		if(arriba)
			world.getAttacks().add(new PlayerAttack(world, new Vector2(getPosition().X,getPosition().Y-30f)));
		if(izquierda)
			world.getAttacks().add(new PlayerAttack(world, new Vector2(getPosition().X-30f,getPosition().Y)));
		if(abajo)
				world.getAttacks().add(new PlayerAttack(world, new Vector2(getPosition().X,getPosition().Y+30f)));
		if(derecha)
			world.getAttacks().add(new PlayerAttack(world, new Vector2(getPosition().X+30f,getPosition().Y)));
		}
	}
	
	public int getClase(){return this.clase;}
	
	public void collisions(){
				
		Rectangle bounds = boundingBox();
		
		for(Enemy en:world.getEnemigos()){
			if(en.boundingBox().Intersects(bounds)){
				Vector2 depth = Rectangle.GetIntersectionDepth(bounds,en.boundingBox());
				if (depth != new Vector2(0,0)) {
					float absDepthX = Math.abs(depth.X);
					float absDepthY = Math.abs(depth.Y);

					if (absDepthX > 0 || absDepthY > 0) {					
						//Is a impasable tile,added by the user, timed, or breakeable.
							if (absDepthY < absDepthX) {
								setPosition(new Vector2(getPosition().X,getPosition().Y + depth.Y));
								subsLife(0.5f);
								bounds = boundingBox();
							} else {		
								setPosition(new Vector2(getPosition().X+ depth.X,getPosition().Y ));
								subsLife(0.5f);
								bounds = boundingBox();
							}
						}
			}
			}
		}
		bounds = boundingBox();
		
		int leftTile = (int) Math.floor((float) bounds.Left / Tile.Width);
		int rightTile = (int) Math.ceil(((float) bounds.Right() / Tile.Width)) ;
		int topTile = (int) Math.floor((float) bounds.Top / Tile.Height);
		int bottomTile = (int) Math.ceil(((float) bounds.Bottom() / Tile.Height)) ;
		for (int x = leftTile; x <= rightTile; ++x) {
			for (int y = topTile; y <= bottomTile; ++y) {
				int collision = world.getTileMap().GetCollision(x, y);
				Rectangle tileBounds = world.getTileMap().GetBounds(x, y);
				Vector2 depth = Rectangle.GetIntersectionDepth(bounds,tileBounds);
				if (depth != new Vector2(0,0)) {
					float absDepthX = Math.abs(depth.X);
					float absDepthY = Math.abs(depth.Y);

					if (absDepthX > 0 || absDepthY > 0) {					
						//Is a impasable tile,added by the user, timed, or breakeable.
						if (collision == 2||collision == -1) {
							if (absDepthY < absDepthX) {
								setPosition(new Vector2(getPosition().X,getPosition().Y + depth.Y));
								bounds = boundingBox();
							} else {		
								setPosition(new Vector2(getPosition().X+ depth.X,getPosition().Y ));
								bounds = boundingBox();
							}
						}
						if(OnWater&&collision==-1||OnWater&&collision==2){
							OnWater=true;
						}else{
						if (collision ==0) {
							OnWater=true;
						}else{
							OnWater=false;
						}}
						bounds = boundingBox();
					}
				}
			}
		}
	}
	
	public float getLife(){
		return this.life;
	}
	public void subsLife(float x){
		this.life-=x;
	}
	public float getOxy(){
		return this.oxygen;
	}
	public void subsOxy(float x){
		this.oxygen-=x;
	}
}
