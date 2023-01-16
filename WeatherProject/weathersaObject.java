package WeatherProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.primitives.Chars;

public class weathersaObject {

	WebDriver driver;

	public weathersaObject(WebDriver d) {

		this.driver = d;

	}

	public void launchSite(WebDriver driver) {

		driver.manage().window().maximize();
		driver.get("https://www.weathersa.co.za/");
	}

	public void searchCity(String cityName, WebDriver driver) {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
		WebElement searchIcon = driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/fieldset[1]/button[1]/i[1]"));

		searchBox.sendKeys(cityName);
		searchIcon.click();
	}

	public int minTemp(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		String bodyText = driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/p[2]")).getText();

		System.out.println("body text: " + bodyText);

		char numb1 = bodyText.charAt(0);
		char numb2 = bodyText.charAt(1);

		String str = String.valueOf(numb1) + String.valueOf(numb2);
		int num1 = Integer.parseInt(str);
		// System.out.println(num1);

		char numb3 = bodyText.charAt(4);
		char numb4 = bodyText.charAt(5);

		String abc = String.valueOf(numb3) + String.valueOf(numb4);
		int num2 = Integer.parseInt(abc);
		// System.out.println(num2);

		if (num1 < num2) {

			return num1;

		} else {

			return num2;
		}

	}

	public int maxTemp(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String bodyText = driver.findElement(By.xpath("//p[@class='ctemp-0']")).getText();
		System.out.println("body text: " + bodyText);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		char numb1 = bodyText.charAt(0);
		char numb2 = bodyText.charAt(1);

		String str = String.valueOf(numb1) + String.valueOf(numb2);
		int num1 = Integer.parseInt(str);
		// System.out.println(num1);

		char numb3 = bodyText.charAt(4);
		char numb4 = bodyText.charAt(5);

		String abc = String.valueOf(numb3) + String.valueOf(numb4);
		int num2 = Integer.parseInt(abc);
		// System.out.println(num2);

		if (num1 > num2) {

			return num1;

		} else {

			return num2;
		}

	}

	public void closeBrowser(WebDriver driver) {

		driver.close();
	}

}
