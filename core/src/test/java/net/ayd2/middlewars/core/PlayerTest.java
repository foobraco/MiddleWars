package net.ayd2.middlewars.core;


import static org.junit.Assert.assertEquals;
import net.ayd2.middlewars.core.actors.Player;
import net.ayd2.middlewars.core.items.Sword;
import net.ayd2.middlewars.core.utils.Vector2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

  @BeforeClass
  public static void testSetup() {
	  
  }

  @AfterClass
  public static void testCleanup() {
	  
  }

  @Test
  public void testVectorPosition() {
    Player tester = new Player(0, new Vector2(160,160));
    assertEquals("Player Pos: 160.0,160.0", "Player Pos: "+tester.getPosition().X+","+tester.getPosition().Y);
  }
  
  @Test
  public void testStartingItem() {
    Player tester = new Player(0, new Vector2(50,50));
    assertEquals(0, tester.getItem().getType());
  }

  @Test
  public void testItemChange() {
    Player tester = new Player(0, new Vector2(50,50));
    tester.setItem(new Sword(tester, 1));
    assertEquals(1, tester.getItem().getType());
  }
  
} 
