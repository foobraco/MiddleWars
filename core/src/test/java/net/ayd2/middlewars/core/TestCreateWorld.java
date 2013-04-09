package net.ayd2.middlewars.core;

import java.util.List;
 
import net.ayd2.middlewars.core.utils.Tile;
import net.ayd2.middlewars.core.utils.TileMap;
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
 
public class TestCreateWorld extends JUnitStory {
 private MapGenerator            mapgen;
 private Tile[][]    map;
 
 @Given("a map generator")
 public void aMapGenerator() {
 mapgen = new MapGenerator();
 }
 
 @Given("a game board")
 public void aGameBoard() {
	map = new Tile[50][50];
 }
 
 @When("the game creates a new world sets the default complexity level of ant creation.")
 public void whenTheGameCreatesANewWorldSetsTheDefaultComplexityLevelOfAntCreation() {
	 map = mapgen.GenerateMap(50,50, 1, 50).getTilemap();
	 }
 
 @Then("the game board must be added to the playable board.")
 public void thenTheGameBoardMustBeAddedToThePlayableBoard() {
 Assert.assertTrue(map != null );
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