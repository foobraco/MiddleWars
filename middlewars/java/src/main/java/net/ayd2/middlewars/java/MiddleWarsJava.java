package net.ayd2.middlewars.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import net.ayd2.middlewars.core.MiddleWars;

public class MiddleWarsJava {

  public static void main(String[] args) {
    JavaPlatform.register();
    PlayN.run(new MiddleWars());
  }
}
