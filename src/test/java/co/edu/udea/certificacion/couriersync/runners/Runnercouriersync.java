package co.edu.udea.certificacion.couriersync.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/logincouriersync.feature",
        glue = "co.edu.udea.certificacion.couriersync.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runnercouriersync {}