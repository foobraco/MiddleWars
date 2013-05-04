package net.ayd2.middlewars.core.actors;

import playn.core.Surface;
import net.ayd2.middlewars.core.Map;
import net.ayd2.middlewars.core.items.BareFists;
import net.ayd2.middlewars.core.utils.Entity;
import net.ayd2.middlewars.core.utils.Rectangle;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.Vector2;

public class Enemy  extends Entity{ 

	int clase;
	Map world;
	int orientation;
	public boolean arriba, abajo, izquierda, derecha;
	
	public Enemy(int cl,Vector2 position,Map mundo){
		this.clase=cl;
		setPosition(position);
		setItem(new BareFists(this,1));
		world=mundo;
		loadContent();
	}
	
	@Override
	public void loadContent() {
	
	}

	@Override
	public void update(float delta) {
	
	}

	@Override
	public void draw(Surface surf, Vector2 offsets) {
	
	}

	@Override
	public void action() {
	
	}

	public void collisions(){
	Rectangle bounds = boundingBox();
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
							bounds = boundingBox();
						} else {		
							setPosition(new Vector2(getPosition().X+ depth.X,getPosition().Y ));
							bounds = boundingBox();
						}
					}
					bounds = boundingBox();
				}
			}
		}
	}
	}

}
