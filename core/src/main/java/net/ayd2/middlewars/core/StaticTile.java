package net.ayd2.middlewars.core;

import playn.core.Surface;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.Vector2;

public class StaticTile extends Tile{
	int life;
	public StaticTile(String texture, int collision, String data, int tp) {
		if (texture != null) {
			Texture = texture;
			name = data;
			Collision = collision;
			Type=tp;
			if(collision==2){life=5;}else{life=0;}
		}
	}
	@Override
	public void Draw(Surface surf, Vector2 position) {
		surf.drawImage(MiddleWars.imagemap[Integer.parseInt(name)], position.X, position.Y);
	}
	@Override
	public void Update(float f) {}
	public int getLife(){return this.life;}
	public void subsLife(int l){this.life-=l;}
}
