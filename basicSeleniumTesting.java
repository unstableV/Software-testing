import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class basicSeleniumTesting.java {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

       
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement testArea = driver.findElement(By.name("my-textarea"));
        
        Select drop = new Select(driver.findElement(By.name("my-select")));
        WebElement drop1 = driver.findElement(By.name("my-datalist"));
        WebElement check = driver.findElement(By.className("form-check"));
        WebElement upload = driver.findElement(By.name("my-file"));
        WebElement colorPick = driver.findElement(By.name("my-colors"));
        WebElement datePick = driver.findElement(By.name("my-date"));
        WebElement range = driver.findElement(By.name("my-range"));

        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        password.sendKeys("asmavasu");
        testArea.sendKeys("asma is great");
        drop.selectByValue("1");
        drop1.sendKeys("Seattle");
        if(check.isSelected()==false) {
                  check.click();	
        }
        
       upload.sendKeys("Suite.pdf");
       colorPick.sendKeys("my-colors");
       datePick.sendKeys("28/10/1996");
       range.sendKeys("1");
        
        submitButton.click();

        driver.quit();


	}

}
