package org.example.testifyProject;

import org.example.SauceLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class KongaProject {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/wendyseth/IdeaProjects/SeleniumProjects/src/chromedriver");
        WebDriver driver = new ChromeDriver();
        //make full screen
        driver.manage().window().maximize();
        // Navigate to Konga website
        driver.navigate().to("https://www.konga.com/");
        //Navigate the login page from the home page
        driver.findElement(By.xpath("//a[contains(text(),'Login / Signup')]")).click();
        // linking the login page
        KongaLoginPage login = new KongaLoginPage(driver);
        //Enter valid email
        login.getLogin().sendKeys("sethwendy@yahoo.com");
        //Enter valid password
        login.getPassword().sendKeys("Seth1896");
        //Click the Login button
        login.getLoginButton().click();
        //Click on computer categories
        WebElement computerAccessories = driver.findElement(By.xpath("//a[contains(text(),'Computers and Accessories')]"));
        //Click on the Laptop Category/Apple Macbook
        Actions mouse = new Actions(driver);
        mouse.moveToElement(computerAccessories).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("._0e252_CDReQ > div:nth-of-type(1) > a:nth-of-type(6)")).click();
        // Add item to cart
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[1]/div[3]/section[1]/main[1]/section[2]/section[1]/section[1]/" +
                "section[1]/section[1]/ul[1]/li[2]/div[1]/div[1]/div[2]/form[1]/div[4]/button[1]")).click();
        Thread.sleep(2000);
        //Go to my cart
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/section[1]/div[2]/nav[1]/div[2]/div[1]/div[1]/a[2]/span[1]")).click();
        Thread.sleep(2000);
        //Click check out button
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
        // To select delivery address
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Change Address')]")).click();

        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[1]/div[2]/section[1]/" +
                "section[1]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Use this Address')]")).click();

        // to click payment method
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[1]/div[2]/section[1]/main[1]/form[1]/" +
                "div[1]/section[1]/div[1]/div[4]/form[1]/ul[1]/li[1]/div[1]/button[1]")).click();
        // to continue to payment
        driver.findElement(By.xpath("//button[contains(text(),'Continue to Payment')]")).click();
        Thread.sleep(5000);
        //select card payment
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);
       driver.findElement(By.xpath("//body/section[1]")).click();
        Thread.sleep(5000);
        //Input invalid card details
        driver.findElement(By.id("card-number")).sendKeys("1234123412341234");
        //Input expiry date
        driver.findElement(By.id("expiry")).sendKeys("1224");
        Thread.sleep(5000);
        System.out.println( driver.findElement(By.id("card-number_unhappy")).getText());
        driver.findElement(By.id("expiry")).sendKeys("1224");
        driver.findElement(By.id("cvv")).sendKeys("122");
        driver.findElement(By.id("validateCardForm")).click();
        System.out.println("Completed adding card");
        //Close the iFrame that displays the input card Modal
        driver.findElement(By.className("data-card__close")).click();
        Thread.sleep(5000);
        //Quit the browser.
        driver.quit();

    }


}
