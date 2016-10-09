package jp.selenium.sample.benchmark.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("useMarionette", true);
        capabilities.setCapability(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "./geckodriver");
        return new FirefoxDriver(capabilities);
    }
}
