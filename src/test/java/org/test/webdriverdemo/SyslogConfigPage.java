package org.test.webdriverdemo;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SyslogConfigPage extends BasePage {
    WebElement enableCheckbox;
    WebElement ip;
    WebElement port;
    WebElement saveBtn;

    private static class Locator {
        static By platformMenu = By.xpath("//*[@id=\"user\"]/div[1]/ul[6]/li/a");
        static By syslogMenu = By.xpath("//*[@id=\"user\"]/div[1]/ul[6]/li/div/ul/li[2]/a");
        static By enableCheckbox = By.cssSelector(".checkbox > label > input");
        static By ip = By.name("ip");
        static By port = By.name("port");
        static By save = By.tagName("button");
        static By notifyMsg = By.cssSelector("span[data-notify=message]");
    }

    @Given("打开Syslog配置页面")
    public void openSyslogConfigPage() {
        waitFor(Locator.platformMenu).click();
        waitVisibleFor(Locator.syslogMenu).click();
        driver.switchTo().frame("iFramePanel");
    }

    @When("使用合法的参数启用Syslog")
    public void enableSyslogWithCorrectArgs() {
        enableCheckbox = driver.findElement(Locator.enableCheckbox);
        ip = driver.findElement(Locator.ip);
        port = driver.findElement(Locator.port);
        saveBtn = driver.findElement(Locator.save);
        if (!enableCheckbox.isSelected()) {
            enableCheckbox.click();
        }
        ip.clear();
        ip.sendKeys("1.1.1.1");
        port.clear();
        port.sendKeys("514");
        saveBtn.click();
    }

    @Then("Syslog启用成功")
    public void enableSyslogSuccessfully() {
        WebElement notifyMsg = waitFor(Locator.notifyMsg);
        assertEquals("保存成功!", notifyMsg.getText());
    }

    @Test
    void testIPInvalid () {

    }

    @Test
    void testPortInvalid() {

    }
}
