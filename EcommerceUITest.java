import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EcommerceUITest {

	static WebDriver driver = new ChromeDriver();
	public static void getProduct() {
		if(driver.getTitle() == "PRODUCTS") {
			System.out.print("Title is ok");
		}
		//WebElement checkout = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));

        Select drop = new Select(driver.findElement(By.className("product_sort_container")));
        
        drop.selectByValue("lohi");
        
        WebElement list = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
        list.click();
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
        cartButton.click();
        
        WebElement removeCart = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-onesie\"]"));
        if(removeCart.getText().equals("REMOVE")) {
        	cart();
        }
	}
	
	public static void cart() {
		
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
	
		cart.click();
		driver.get("https://www.saucedemo.com/inventory.html");
		logout();
    	}
	public static void logout() {
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        menu.click();
        logout.click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubWebDriver driver = new ChromeDriver();
		
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().fullscreen();
       
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement userName = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton =driver.findElement(By.name("login-button"));
        
        if(userName.isDisplayed() == true && userName.isEnabled()==true) {
        	userName.sendKeys("standard_user");
        }
        else {
        	System.out.println("Username field not found");
        }
        
        if(password.isDisplayed() == true && password.isEnabled()==true) {
        	password.sendKeys("secret_sauce");
        }
        else {
               System.out.println("password field not found");
        }
        if(loginButton.isDisplayed()==true&&loginButton.isEnabled()==true) {
        	loginButton.click();
        	if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
        		getProduct();
        	}
        }
        else {
        	System.out.println("button not found");
        }
        
        
	}

}
