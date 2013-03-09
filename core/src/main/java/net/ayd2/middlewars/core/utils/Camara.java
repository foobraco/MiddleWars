package net.ayd2.middlewars.core.utils;

import net.ayd2.middlewars.core.Map;

public class Camara {
	private Vector2 position;
	public boolean up, down,left,right;

	public Camara(Map level, Vector2 pos) {
		position = pos;
	}

	public Vector2 Position() {
		return position;
	}

	// manual camera
	public void setPosition(Vector2 value) {
		this.position = value;
	}

	public void update_position(float x, float y) {
		position.X += x;
		position.Y += y;
	}

	public void update_position(Vector2 pos) {
		position.add(pos);
	}

	public void update() {

	}
}
