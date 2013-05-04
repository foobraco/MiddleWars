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

public class Enemy  extends Entity{ 

	int clase;
	Map world;
	int orientation;
	public boolean arriba, abajo, izquierda, derecha;
	float life;
	float oxygen;
	int or;
	public Enemy(int cl,Vector2 position,Map mundo){
		this.clase=cl;
		setPosition(position);
		setItem(new BareFists(this,1));
		world=mundo;
		loadContent();
		life=10;
		oxygen=10;
		or=0;
	}
	
	@Override
	public void loadContent() {
		up=new Animation(MiddleWars.imagemap[7], 300f, 30f, true);
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
			setRemove();
		}else{
			amp.updateAnimation(delta);
			collisions();
			action();
		}
	}

	@Override
	public void draw(Surface surf, Vector2 offsets) {
		amp.Draw(surf, getPosition().add(offsets));
	}

	@Override
	public void action() {
		switch(or){
		case 0:
			setPosition(new Vector2(getPosition().X,getPosition().Y+0.5f));
			break;
		case 1:
			setPosition(new Vector2(getPosition().X-0.5f,getPosition().Y));
			break;
		case 2:
			setPosition(new Vector2(getPosition().X+0.5f,getPosition().Y));
			break;
		case 3:
			setPosition(new Vector2(getPosition().X,getPosition().Y-0.5f));
			break;
		}
	}

	public void collisions(){
		
Rectangle bounds = boundingBox();
		
		for(PlayerAttack en:world.getAttacks()){
			if(en.boundingBox().Intersects(bounds)){
				Vector2 depth = Rectangle.GetIntersectionDepth(bounds,en.boundingBox());
				if (depth != new Vector2(0,0)) {
					float absDepthX = Math.abs(depth.X);
					float absDepthY = Math.abs(depth.Y);

					if (absDepthX > 0 || absDepthY > 0) {					
						//Is a impasable tile,added by the user, timed, or breakeable.
							if (absDepthY < absDepthX) {
								subsLife(0.2f);
								bounds = boundingBox();
							} else {		
								subsLife(0.2f);
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
					if (collision != 1) {
						if (absDepthY < absDepthX) {
							setPosition(new Vector2(getPosition().X,getPosition().Y + depth.Y));
							double random=Math.random()*4;
							or=(int)random;
							bounds = boundingBox();
						} else {		
							setPosition(new Vector2(getPosition().X+ depth.X,getPosition().Y ));
							double random=Math.random()*4;
							or=(int)random;
							bounds = boundingBox();
						}
					}
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

}
