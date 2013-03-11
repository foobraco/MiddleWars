package net.ayd2.middlewars.core;

import static playn.core.PlayN.*;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;

public class MiddleWars implements Game {
  @Override
  public void init() {
    // create and add background image layer
    Image bgImage = assets().getImage("images/bg.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);
    MapGenerator mpg = null;
    mpg.GenerateMap(800, 600, 0,0.70f);
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }

  @Override
  public void update(float delta) {
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
