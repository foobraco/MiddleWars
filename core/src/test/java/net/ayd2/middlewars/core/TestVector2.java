package net.ayd2.middlewars.core;


import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import net.ayd2.middlewars.core.actors.Player;
import net.ayd2.middlewars.core.items.Sword;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.Vector2;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestVector2 {
Vector2 testing;
  @BeforeClass
  public static void testSetup() {
	  
  }

  @AfterClass
  public static void testCleanup() {
	  
  }

  @Test
  public void testVector2() {
	testing=new Vector2(10,10);	
	if(testing.X==10&&testing.Y==10){
		Assert.assertTrue(true);
	}
  }

 
 
  
} 
