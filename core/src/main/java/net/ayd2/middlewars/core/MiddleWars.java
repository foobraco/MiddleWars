package net.ayd2.middlewars.core;


import playn.core.Game;
import playn.core.Image;


public class MiddleWars implements Game {
Map mapita;
public static Image[] imagemap= new Image[6];

	 public MiddleWars(String data){
		 mapita=new Map(data);
	 }
	 
  @Override
  public void init() {
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
