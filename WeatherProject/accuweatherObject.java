package WeatherProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class accuweatherObject {

	WebDriver driver;
	
	public accuweatherObject(WebDriver d) {

		this.driver = d;

	}

	public void launchSite(WebDriver driver) {

		driver.manage().window().maximize();
		driver.get("https://accuweather.com/");
	}

	public void searchCity(String cityName, WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement searchBox = driver.findElement(By.name("query"));
		WebElement searchIcon = driver.findElement(By.xpath("//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/*[1]"));

		searchBox.sendKeys(cityName);
		searchIcon.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@class='locations-list content-module']/a[1]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().refresh(); // to skip ad

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//body/div[1]/div[4]/div[1]/div[1]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[text()='More Details']")).click();

	}

	public int minTemp(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String nightTemp = driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]")).getText();

		//System.out.println(nightTemp);

		char numb1 = nightTemp.charAt(0);
		char numb2 = nightTemp.charAt(1);

		String str = String.valueOf(numb1) + String.valueOf(numb2);
		int num1 = Integer.parseInt(str);

		//System.out.println("Night temperature: " + num1);
		
		return num1;

	}

	public int maxTemp(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String dayTemp = driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]")).getText();
		//System.out.println( dayTemp);

		char number1 = dayTemp.charAt(0);
		char number2 = dayTemp.charAt(1);

		String str = String.valueOf(number1) + String.valueOf(number2);
		int num2 = Integer.parseInt(str);

		//System.out.println("Night temperature: " + num2);

		return num2;
	}

	public void closeBrowser(WebDriver driver) {
		
		driver.close();
	}
}
