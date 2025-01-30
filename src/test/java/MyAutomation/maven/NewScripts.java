package MyAutomation.maven;

import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class NewScripts {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 
	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.get("https://mobulous.co.in/askbiz/admin/login.html");
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Askbiz";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
  	        System.out.println("Title Matched");
  	      List<WebElement> images = driver.findElements(By.tagName("img"));
  	    System.out.println("The number of images at login page is " + images.size());
         
  	    try {
            WebElement loginElement = driver.findElement(By.xpath("/html/body/div/div[2]/h3/span"));
            assertTrue(loginElement.isDisplayed(), "Text 'Log In' is not present on the page");           
            System.out.println("Text 'Login' is present on the page");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Text 'Login' is not present on the page");
        }
  	    Thread.sleep(1000);
     WebElement button=driver.findElement(By.xpath("/html/body/div/div[2]/form/a"));
     button.click();
     System.out.println("Admin Logged In Successfully");
     List<WebElement> image = driver.findElements(By.tagName("img"));
	    System.out.println("The number of images at admin dashboard is " + image.size());
	 //for checking the no. of links   
//	    List<WebElement> links = driver.findElements(By.tagName("a"));
//        for (WebElement link : links) {
//            String href = link.getAttribute("href");
//            try {
//                HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
//                int responseCode = connection.getResponseCode();
//                if (responseCode == 404 || responseCode >= 500) {
//                    System.out.println("Broken link: " + href);
//                }
//            } catch (Exception e) {
//                System.out.println("Error checking link: " + href);
//            }
//        }

//        List<WebElement> images1 = driver.findElements(By.tagName("img"));
//        for (WebElement image1 : images1) {
//            String src = image1.getAttribute("src");
//            try {
//                URL url = new URL(src);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                int responseCode = connection.getResponseCode();
//                if (responseCode == 404 || responseCode >= 500) {
//                    System.out.println("Broken image: " + src);
//                }
//            } catch (Exception e) {
//                System.out.println("Error checking image: " + src);
//            }
//        }
	    
	    
	    
//to hover over profile.................................
        WebElement profileElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/a")); 
        Actions actions = new Actions(driver);

        // Move the mouse to the profile element and hover over it
        actions.moveToElement(profileElement).perform();

        // Wait for a few seconds to see the hover effect
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
        WebElement logoutbutton=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/ul/li[4]/a"));
        logoutbutton.click();
        Thread.sleep(2000);
        WebElement logoutyesbutton=driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/div/a"));
        logoutyesbutton.click(); 
        System.out.println("Logged out successfully");
	}

}
