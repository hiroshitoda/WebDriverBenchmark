package jp.selenium.sample.benchmark.webdriver;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class JBrowserDriverHeadlessBenchmarkTest extends Base
{
    @Override
    protected WebDriver getDriver() throws Exception
    {
        Capabilities capabilities = Settings.builder()
                .headless(true)
                .saveAttachments(true)
                .screen(new Dimension(1200, 700))
                .ssl("trustanything")
                .timezone(Timezone.ASIA_TOKYO)
                .buildCapabilities();
        return new JBrowserDriver(capabilities);
    }
}
