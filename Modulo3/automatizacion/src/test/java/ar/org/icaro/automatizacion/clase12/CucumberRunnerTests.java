package ar.org.icaro.automatizacion.clase12;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Wikipedia.feature"},
        glue = {"ar.org.icaro.automatizacion.clase12.steps"}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}