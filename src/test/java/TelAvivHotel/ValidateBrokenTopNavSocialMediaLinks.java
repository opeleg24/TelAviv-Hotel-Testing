package TelAvivHotel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.TopNavSocialMediaLinks;
import resources.base;

public class ValidateBrokenTopNavSocialMediaLinks extends base {

	public WebDriver driver;
	TopNavSocialMediaLinks ValidateTopNavSocialMedia;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
	}

	@Test

	public void validateAppNavBar() throws IOException {

		ValidateTopNavSocialMedia = new TopNavSocialMediaLinks(driver);

		List<WebElement> links = ValidateTopNavSocialMedia.getSocialMediaLinks();

		for (WebElement link : links)

		{

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			log.info("Checking for broken links");
			Assert.assertTrue(respCode < 400,
					"The link with Text" + link.getText() + " is broken with code" + respCode);

		}

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
