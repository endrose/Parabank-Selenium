package runner;


import org.junit.runner.RunWith;
import org.junit.AfterClass;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import reports.ReportGenerator;

//
@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDef",
        tags = "@Test1",
        plugin = {"pretty", "html:target/RegressionReport.html"}
)

public class RunTest extends ReportGenerator {
    @AfterClass
    public static void generateReport() {
        ReportGenerator.generateReported();
    }
}
