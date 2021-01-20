package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");

        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();
        //Implicit Wait Machine - When your code/test executes faster than your browser, test works with elements that are not there.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/windows");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String clickId = it.next();//Control will go to the [0] Index 'First index'
        String windowId = it.next();//Control will go to the [0] to [1] index 'Second index'
        driver.switchTo().window(windowId);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText().split("New")[1].trim().split(" ")[0]);
        driver.switchTo().window(clickId);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

    }
}
