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
 
public class TestAvatar extends JUnitStory {
 private MapGenerator  mapgen;
 private Tile[][]    map;
 Player jugador;
 @Given("world created")
 public void aWorldCreated() {
	 mapgen = new MapGenerator();
	 map=mapgen.GenerateMap(20, 20, 0, 10).getTilemap();
 }
 
 @Given("avatar position")
 public void aAvatarPosition() {
	 jugador = new Player(0, new Vector2(120,120), null);
 }

 @When("the user starts the game")
 public void whentheuserstartsthegame() {
	 
}
 
 @Then("the avatar must be placed in the world")
 public void theavatarmustbeplacedintheworld() {
	 if(jugador.getPosition().X<0||jugador.getPosition().X>40*120){
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