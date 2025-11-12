package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {
        System.out.println("Browser value is : " + browser);
        if (browser.equals("chrome")) {
            driver = new ChromeDriver(); //WebDriverManager.chromeDriver.setup()
            threadLocal.set(driver);// threadLocal.set(new ChromeDriver())
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();//WebDriverManager.edgeDriver.setup()
            threadLocal.set(driver);
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();//WebDriverManager.safariDriver.setup()
            threadLocal.set(driver);
        } else {
            System.out.println("Incorrect browser value" + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return threadLocal.get();
    }

}
