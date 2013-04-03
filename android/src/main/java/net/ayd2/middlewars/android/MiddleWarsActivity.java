package net.ayd2.middlewars.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import net.ayd2.middlewars.core.MiddleWars;

public class MiddleWarsActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new MiddleWars(null));
  }
}
