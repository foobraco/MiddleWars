package net.ayd2.middlewars.core.actors;

import playn.core.Surface;
import net.ayd2.middlewars.core.MiddleWars;
import net.ayd2.middlewars.core.items.BareFists;
import net.ayd2.middlewars.core.utils.Animation;
import net.ayd2.middlewars.core.utils.Entity;
import net.ayd2.middlewars.core.utils.Rectangle;
import net.ayd2.middlewars.core.utils.Vector2;

public class Player extends Entity{
	int clase;
	
	public Player(int cl,Vector2 position){
		this.clase=cl;
		setPosition(position);
		setItem(new BareFists(this,1));
		loadContent();
	}
	
	@Override
	public void loadContent() {
		up=new Animation(MiddleWars.imagemap[3], 40f, 40f, true);
		this.setBounds(new Rectangle(40,40,40,40,1));
		amp.PlayAnimation(up);
	}

	@Override
	public void update(float delta) {
		collisions();
	}
	
	@Override
	public void draw(Surface surf, Vector2 offsets) {
		amp.Draw(surf, getPosition().add(offsets));
	}

	@Override
	public void action() {
		// fire or do something
		
	}
	
	public int getClase(){return this.clase;}
	
	public void collisions(){
		
	}

}
