package jp.selenium.sample.benchmark.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        System.setProperty(
                "webdriver.edge.driver",
                "C:/Program Files (x86)/Microsoft Web Driver/MicrosoftWebDriver.exe"
                );
        return new EdgeDriver();
    }
}
