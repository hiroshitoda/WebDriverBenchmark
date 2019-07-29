package jp.selenium.sample.benchmark.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        WebDriverManager.iedriver().arch32().setup();
        return new InternetExplorerDriver();
    }
}
