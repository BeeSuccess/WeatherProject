package WeatherProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeatherProjectTests {

	WebDriver driver;

	// Defining instance variables
	String cityRequired = "Johannesburg";

	weathersaObject weatherSite1 = new weathersaObject(driver);
	accuweatherObject weatherSite2 = new accuweatherObject(driver);

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\All things automati\\Chrome Drive\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception {

		weatherSite1.closeBrowser(driver);

	}

	@Test
	public void maximumTemp() {

		weatherSite1.launchSite(driver);
		weatherSite1.searchCity(cityRequired, driver);
		int maxTempWeathersa = weatherSite1.maxTemp(driver);

		weatherSite2.launchSite(driver);
		weatherSite2.searchCity(cityRequired, driver);
		int maxTempaccuweather = weatherSite2.maxTemp(driver);

		if (maxTempWeathersa == maxTempaccuweather) {

			System.out.println("Maximum weather matches");
		} else {

			System.out.println("Maximum weather does not match");
		}

		Assert.assertSame(maxTempWeathersa, maxTempaccuweather);
		;

	}

	@Test
	public void minimumTemp() {

		weatherSite1.launchSite(driver);
		weatherSite1.searchCity(cityRequired, driver);
		int minTempWeathersa = weatherSite1.minTemp(driver);

		weatherSite2.launchSite(driver);
		weatherSite2.searchCity(cityRequired, driver);
		int minTempaccuweather = weatherSite2.minTemp(driver);

		if (minTempWeathersa == minTempaccuweather) {

			System.out.println("Minimum weather matches");
		} else {

			System.out.println("Minimum weather does not match");
		}

		Assert.assertSame(minTempWeathersa, minTempaccuweather);
		

	}

}
