package jp.selenium.sample.benchmark.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        return new ChromeDriver();
    }
}
