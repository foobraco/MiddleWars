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
 
public class TestNavigation extends JUnitStory {
 private MapGenerator  mapgen;
 private Tile[][]    map;
 
 @Given("map dimensions")
 public void aMapGenerator() {
 }
 
 @Given("avatar position")
 public void avatarposition() {
 }

 @When("the user navigates in the world")
 public void theusernavigatesintheworld() {
	 }
 
 @Then("see that never leave the boundaries")
 public void seethatneverleavetheboundaries() {
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