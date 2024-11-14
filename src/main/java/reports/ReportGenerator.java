package reports;

import java.io.File;
import java.util.Collections;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
public class ReportGenerator {

    public static void generateReported(){
        File reportOutputDir = new File("target/cucumber-reports");
        String jsonFile = "target/cucumber-reports/cucumber.json";

        Configuration configuration = new Configuration(reportOutputDir, "Parabank-Selenium");
        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList(jsonFile), configuration);
        reportBuilder.generateReports();
    }

}
