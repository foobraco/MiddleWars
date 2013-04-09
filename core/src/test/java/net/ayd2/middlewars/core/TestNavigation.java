package net.ayd2.middlewars.core;

import java.util.List;
 
import net.ayd2.middlewars.core.actors.Player;
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
import net.ayd2.middlewars.core.utils.Vector2;
import net.ayd2.middlewars.core.utils.mapgeneration.MapGenerator;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Assert;
import org.junit.Test;
 
public class TestNavigation extends JUnitStory {
 private MapGenerator  mapgen;
 private Tile[][]    map;
 Player jugador;

 @Given("map dimensions")
 public void mapDimensions() {
	map=new Tile[50][50];
	mapgen = new MapGenerator();
	 map=mapgen.GenerateMap(50, 50, 1, 50).getTilemap();
 }
 
 @Given("avatar position")
 public void avatarPosition() {
	 jugador = new Player(0, new Vector2(0,0));
 }

 @When("the user navigates in the world")
 public void theUserNavigatesInTheWorld() {
	 for(int x=0;x<map.length-1;x++){
		jugador.setPosition(new Vector2(x*40,0));
	 }
}
 
 @Then("see that never leave the boundaries")
 public void seeThatNeverLeaveTheBoundaries() {
 if(jugador.getPosition().X>map.length*40){
		Assert.assertTrue(false);
	}
	Assert.assertTrue(true);
 }
 
 @Override
 public Configuration configuration() {
 return new MostUsefulConfiguration()
 	.useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
 	.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
 }
 
 @Override
 public List<CandidateSteps> candidateSteps() {
 return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
 }
 
 @Override
 @Test
 public void run() throws Throwable {
 super.run();	 
 }
}