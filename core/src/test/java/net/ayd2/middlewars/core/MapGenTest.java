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

public class MapGenTest {

  @BeforeClass
  public static void testSetup() {
	  
  }

  @AfterClass
  public static void testCleanup() {
	  
  }

  @Test
  public void testMapGeneration() {
	MapGenerator mapGen=new MapGenerator();
	if(mapGen.GenerateMap(20, 20, 0,50).getTilemap()!=null){
		Assert.assertTrue(true);
	}	
  }
  
  @Test
  public void testMapLenght() {
	  MapGenerator mapGen=new MapGenerator();
	  Tile[][] tl=mapGen.GenerateMap(20, 20, 0,50).getTilemap();
		if(tl[0].length>0){
			Assert.assertTrue(true);
		}	
		
  }

 
  
} 
