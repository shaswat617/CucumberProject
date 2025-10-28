package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LandingPage {
    private WebDriver driver;

    private By tabsHeader = By.xpath("//ul[@class='top-menu']/li/a");

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Integer getTabsTotalCount()
    {
        return driver.findElements(tabsHeader).size();
    }

    public List<String> getTabsList()
    {
        List<WebElement> tabNames = driver.findElements(tabsHeader);
        List<String> tabsList = new ArrayList<>();

        for (WebElement eachTab : tabNames)
        {
            String tabText = eachTab.getText();
            System.out.println(tabText);
            tabsList.add(tabText);
        }

        return tabsList;
    }

    public String getLandingPageTitle()
    {
        return driver.getTitle();
    }
}
