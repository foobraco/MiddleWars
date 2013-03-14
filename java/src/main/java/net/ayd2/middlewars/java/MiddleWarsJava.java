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
     * dimensions [800,600] defines de size in tiles of the map, 
     * [number of ants] for the complexity algorithm
     */
    String data="create [desert] map with dimensions [800,600] with [30] ants";
    PlayN.run(new MiddleWars(data));
  }
}
