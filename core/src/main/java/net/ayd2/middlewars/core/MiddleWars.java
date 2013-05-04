package net.ayd2.middlewars.core;

import static playn.core.PlayN.*;
import playn.core.Game;
import playn.core.Image;
import playn.core.Platform.Type;
import playn.core.TextFormat;
import playn.core.gl.*;
import playn.core.Font;


public class MiddleWars implements Game {
Map mapita;
public static Image[] imagemap= new Image[9];
public static TextFormat format;
int WIDTH,HEIGHT;
	 public MiddleWars(String data){
		 mapita=new Map(data);
	 }
	 
  @Override
  public void init() {
	    WIDTH = 800;
		HEIGHT = 600;
	    format = new TextFormat().withFont(graphics().createFont("PressStart2P", Font.Style.PLAIN, 14));

		platformType();
		if(platformType() == Type.ANDROID){
			graphics().ctx().setTextureFilter(GLContext.Filter.LINEAR, GLContext.Filter.LINEAR);
			graphics().rootLayer().setScale(graphics().screenWidth()/WIDTH, graphics().screenHeight()/HEIGHT);	
		}
	    mapita.Init();
  }
  

  @Override
  public void paint(float alpha) {
	  
  }

  @Override
  public void update(float delta) {
	    mapita.Update(delta);
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
