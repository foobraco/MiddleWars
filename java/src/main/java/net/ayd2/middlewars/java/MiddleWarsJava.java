package net.ayd2.middlewars.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import net.ayd2.middlewars.core.MiddleWars;

public class MiddleWarsJava {

  public static void main(String[] args) {
    JavaPlatform.register();
    /*
     * To define a map you need a string containing:
     * create [water|forest|desert] select one of those for the kind of basemap
     * dimensions [800,600] defines the size in tiles of the map, 
     * [number of ants] for the complexity algorithm
     */
    JavaPlatform platform = JavaPlatform.register();
    platform.setTitle("Analisis y Dise~no2");
    playn.java.JavaPlatform.Config config = new playn.java.JavaPlatform.Config();
	  config.width = 800;
	  config.height = 600;
	    platform.graphics().registerFont("PressStart2P", "Text/PressStart2P.ttf");
	  platform = JavaPlatform.register(config);
    String data="create [forest] map with dimensions [40,20] with [100] ants";
    PlayN.run(new MiddleWars(data));
  }
}