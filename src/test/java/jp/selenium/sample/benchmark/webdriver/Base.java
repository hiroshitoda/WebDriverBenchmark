package jp.selenium.sample.benchmark.webdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class Base
{
    protected Logger logger = Logger.getLogger(this.getClass().getName());;
    protected WebDriver driver;
    protected long[] millis = new long[9];
    protected int limit = 100;

    @Before
    public void setUp() throws Exception
    {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSample() throws Exception
    {
        long startTime, endTime;
        byte[] bytes = null;

        for (int index = 0; index < limit; index++)
        {
            logger.info("" + index);
            startTime = System.currentTimeMillis();
            driver.get("http://example.selenium.jp/reserveApp/");
            endTime = System.currentTimeMillis();
            millis[0] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            WebElement reserveYear = driver.findElement(By.id("reserve_year"));
            endTime = System.currentTimeMillis();
            millis[1] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            reserveYear.clear();
            endTime = System.currentTimeMillis();
            millis[2] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            reserveYear.sendKeys("2014");
            endTime = System.currentTimeMillis();
            millis[3] += (endTime - startTime);

            /*
            startTime = System.currentTimeMillis();
            WebElement breakfastOff = driver.findElement(By.xpath("//input[@id=breakfast_off]"));
            endTime = System.currentTimeMillis();
            millis[4] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            breakfastOff.click();
            endTime = System.currentTimeMillis();
            millis[5] += (endTime - startTime);
            */

            startTime = System.currentTimeMillis();
            WebElement planB = driver.findElement(By.cssSelector("#plan_b"));
            endTime = System.currentTimeMillis();
            millis[6] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            planB.click();
            endTime = System.currentTimeMillis();
            millis[7] += (endTime - startTime);

            startTime = System.currentTimeMillis();
            bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            endTime = System.currentTimeMillis();
            millis[8] += (endTime - startTime);
        }
        
        Files.write(bytes, new File("screenshot.png"));
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
        logger.info(String.format("get: %d millisec.", millis[0] / limit));
        logger.info(String.format("findElementById: %d millisec.", millis[1] / limit));
        logger.info(String.format("WebElement.clear: %d millisec.", millis[2] / limit));
        logger.info(String.format("WebElement.sendKeys: %d millisec.", millis[3] / limit));
        logger.info(String.format("findElementByXPath: %d millisec.", millis[4] / limit));
        logger.info(String.format("WebElement.click: %d millisec.", millis[5] / limit));
        logger.info(String.format("findElementByCSS: %d millisec.", millis[6] / limit));
        logger.info(String.format("WebElement.click: %d millisec.", millis[7] / limit));
        logger.info(String.format("getScreenshot: %d millisec.", millis[8] / limit));
    }

    protected WebDriver getDriver() throws Exception
    {
        throw new Exception();
    }
}