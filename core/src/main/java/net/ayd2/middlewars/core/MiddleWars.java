package net.ayd2.middlewars.core;

import static playn.core.PlayN.*;
import net.ayd2.middlewars.core.utils.Rectangle;
import net.ayd2.middlewars.core.utils.Screen;
import playn.core.Game;
import playn.core.Image;
import playn.core.Platform.Type;
import playn.core.TextFormat;
import playn.core.gl.*;
import playn.core.Font;


public class MiddleWars implements Game {
Map mapita;
public static Screen activeScreen;
public static String data;
public static Rectangle fingerBounds;
public static Image[] imagemap= new Image[11];
public static TextFormat format = new TextFormat().withFont(graphics().createFont("PressStart2P", Font.Style.PLAIN, 14));
int WIDTH,HEIGHT;
	 public MiddleWars(String data){
		 MiddleWars.data = data;
	 }
	 
	 
  @Override
  public void init() {
	    WIDTH = 800;
		HEIGHT = 600;

		platformType();
		if(platformType() == Type.ANDROID){
			graphics().ctx().setTextureFilter(GLContext.Filter.LINEAR, GLContext.Filter.LINEAR);
			graphics().rootLayer().setScale(graphics().screenWidth()/WIDTH, graphics().screenHeight()/HEIGHT);	
		}
		int width = (10);
		int left = 0;
		int height = (10);
		int top = 0;
		fingerBounds = new Rectangle(left, top, width, height, 1);

	    MainMenu menu = new MainMenu(this);
	    activeScreen = menu;
	    menu.Init();
  }
  

  @Override
  public void paint(float alpha) {
	  
  }
  
  public static Rectangle FingerRectangle(float x, float y) {
		int left = (int) (x - 10);
		int top = (int) (y - 10);
		return new Rectangle(left, top, fingerBounds.Bottom(),
				fingerBounds.Right(), 1);
	}

  @Override
  public void update(float delta) {
	    activeScreen.Update(delta);
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
