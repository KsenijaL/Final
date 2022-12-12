import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = {"C:\\Users\\Edgars\\Desktop\\Ksenija\\FinalWork2\\src\\test\\resources\\features"},
        glue = {"steps"},
        tags = "@SmokeTest"
)
public class TestRunner {

}

