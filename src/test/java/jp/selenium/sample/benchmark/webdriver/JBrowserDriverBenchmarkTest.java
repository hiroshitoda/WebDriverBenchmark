package jp.selenium.sample.benchmark.webdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

public class JBrowserDriverBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        Capabilities capabilities = Settings.builder()
                .headless(false)
                .saveAttachments(true)
                .screen(new Dimension(1200, 700))
                .ssl("trustanything")
                .timezone(Timezone.ASIA_TOKYO)
                .buildCapabilities();
        return new JBrowserDriver(capabilities);
    }
}
