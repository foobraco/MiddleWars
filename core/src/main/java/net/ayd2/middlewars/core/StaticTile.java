package net.ayd2.middlewars.core;

import playn.core.Surface;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.Vector2;

public class StaticTile extends Tile{

	public StaticTile(String texture, int collision, String data, int tp) {
		if (texture != null) {
			Texture = texture;
			name = data;
			Collision = collision;
			Type=tp;
		}
	}

	@Override
	public void Draw(Surface surf, Vector2 position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(float f) {
		// TODO Auto-generated method stub
		
	}

}
