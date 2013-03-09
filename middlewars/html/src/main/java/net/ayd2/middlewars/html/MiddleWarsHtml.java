package net.ayd2.middlewars.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import net.ayd2.middlewars.core.MiddleWars;

public class MiddleWarsHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("middlewars/");
    PlayN.run(new MiddleWars());
  }
}
