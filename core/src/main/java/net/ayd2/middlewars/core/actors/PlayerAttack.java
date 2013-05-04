package net.ayd2.middlewars.core.actors;

import playn.core.Surface;
import net.ayd2.middlewars.core.Map;
import net.ayd2.middlewars.core.MiddleWars;
import net.ayd2.middlewars.core.StaticTile;
import net.ayd2.middlewars.core.utils.Animation;
import net.ayd2.middlewars.core.utils.Entity;
import net.ayd2.middlewars.core.utils.Rectangle;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.Vector2;

public class PlayerAttack extends Entity{
	Map mundo;
	boolean didHit;
	int or;
	public PlayerAttack(Map mapa, Vector2 pos){
		this.mundo=mapa;
		loadContent();
		this.setPosition(pos);
	}
	
	@Override
	public void loadContent() {
		up=new Animation(MiddleWars.imagemap[6], 100f, 30f, true);
		int width = (int) (30);
		int left = (int) (30 - width) / 2;
		int height = (int) (20);
		int top = (int) (10);
		this.setBounds(new Rectangle(left,top,width,height, 1));
		amp.PlayAnimation(up);		
	}

	@Override
	public void update(float delta) {
		amp.updateAnimation(delta);
		if(amp.FrameIndex()>=2){
			this.setRemove();
		}else{
			action();
		}
	}

	@Override
	public void draw(Surface surf, Vector2 offsets) {
		amp.Draw(surf, this.getPosition().add(offsets));
	}

	@Override
	public void action() {
		if(!didHit){
		for(Enemy en: mundo.getEnemigos()){
			if(en.boundingBox().Intersects(this.boundingBox())){
				
			}
		}
		collisions();
		didHit=true;
		}
	}
	
	public void collisions(){
		Rectangle bounds = boundingBox();
		int leftTile = (int) Math.floor((float) bounds.Left / Tile.Width);
		int rightTile = (int) Math.ceil(((float) bounds.Right() / Tile.Width)) ;
		int topTile = (int) Math.floor((float) bounds.Top / Tile.Height);
		int bottomTile = (int) Math.ceil(((float) bounds.Bottom() / Tile.Height)) ;
		for (int x = leftTile; x <= rightTile; ++x) {
			for (int y = topTile; y <= bottomTile; ++y) {
				int collision = mundo.getTileMap().GetCollision(x, y);
				Rectangle tileBounds = mundo.getTileMap().GetBounds(x, y);
				Vector2 depth = Rectangle.GetIntersectionDepth(bounds,tileBounds);
				if (depth != new Vector2(0,0)) {
					float absDepthX = Math.abs(depth.X);
					float absDepthY = Math.abs(depth.Y);

					if (absDepthX > 0 || absDepthY > 0) {					
						//Is a impasable tile,added by the user, timed, or breakeable.
						if (collision == 2) {
							StaticTile st=(StaticTile) mundo.getTileMap().GetTile(x, y);
							st.subsLife(1);
							if(st.getLife()<=0){
								mundo.getTileMap().SetTile(new StaticTile("1", 1, "1", 1), x, y);
								double random=Math.random()*8;
								or=(int)random;
								
								switch(or){
								case 3:
									mundo.food();
									break;
								case 0:
									mundo.wood();
									break;
								case 1:
									mundo.wood();
									break;
								case 2:
									mundo.wood();
									break;
								case 4:
									mundo.wood();
									break;
								case 5:
									mundo.wood();
									break;
								case 6:
									mundo.wood();
									break;
								case 7:
									mundo.wood();
									break;
		
								}
							}
						}
						bounds = boundingBox();
					}
				}
			}
		}
	}

}
