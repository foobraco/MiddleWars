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
 
public class TestObstacle extends JUnitStory {
	 private MapGenerator  mapgen;
	 private Tile[][]    map;
	 TileMap tl;
	 Player jugador;

 
 @Given("location of obstacles")
 public void locationOfObstacles() {
	 //	mapgen = new MapGenerator();
 }
 
 @Given("avatar position")
 public void avatarPosition() {
	/// Vector2 posicion = new Vector2(2000,2000);
 }

 @When("the user moves the world and encounters an obstruction")
 public void theUserMovesTheWorldAndEncountersAnObstruction() {
	// map = mapgen.GenerateMap(50,50, 1, 50).getTilemap();
	 }
 
 @Then("you must stop and not to cross the road")
 public void youMustStopAndNotToTrossTheRoad() {
 //Assert.assertTrue(true);
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