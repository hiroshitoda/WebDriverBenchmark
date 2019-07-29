package jp.selenium.sample.benchmark.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
