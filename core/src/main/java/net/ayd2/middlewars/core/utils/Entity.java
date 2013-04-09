package net.ayd2.middlewars.core.utils;



import playn.core.Surface;

public abstract class Entity {
	public Animation up,down,left,right,kill;
	public AnimationPlayer amp = new AnimationPlayer();
	Rectangle Bounds;
	Vector2 Position;
	Item itm;
	int angle;
	int life;
	boolean removeme;
	public abstract void loadContent();
	public abstract void update(float delta);
	public abstract void draw(Surface surf, Vector2 offsets);
	public abstract void action();
	public Vector2 getPosition(){
		return this.Position;
	}
	public void setBounds(Rectangle b){this.Bounds=b;}
	public void setPosition(Vector2 pos){
		this.Position=pos;
	}
	public Rectangle boundingBox(){
		int left = (int) (Math.round(getPosition().X) + Bounds.Left);
		int top = (int) (Math.round(getPosition().Y) + Bounds.Top);
		return new Rectangle(left, top, Bounds.Width, Bounds.Height, 1);
	}
	public void setRemove(){this.removeme=true;}
	public boolean removeMe(){return this.removeme;}
	public int getangle(){return this.angle;}
	public void setAngle(int angle){this.angle=angle;}
	public Item getItem(){return this.itm;}
	public void setItem(Item wp){this.itm=wp;}
}
