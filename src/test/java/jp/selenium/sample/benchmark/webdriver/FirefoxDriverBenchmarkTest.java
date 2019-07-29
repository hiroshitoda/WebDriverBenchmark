package jp.selenium.sample.benchmark.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
