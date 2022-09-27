package testRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stepDefinitions.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(
			features ={".//Features"},
			glue={"stepDefinitions"},
			monochrome= true,
			dryRun=false,
			plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			)
public class TestRunner {
	@BeforeClass
	public static void beforeClass() throws Exception
	{
		BaseClass.readConfig();
	}
}
