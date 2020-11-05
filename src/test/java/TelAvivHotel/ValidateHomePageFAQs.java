package TelAvivHotel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageCredentials;
import pageObjects.HomePageFAQs;
import resources.base;

public class ValidateHomePageFAQs extends base {

	public WebDriver driver;
	public HomePageFAQs homePageFAQs;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
		prop.getProperty("url");

		homePageFAQs = new HomePageFAQs(driver);

	}

	@Test

	public void clickFAQs() throws IOException, InterruptedException {

		List<WebElement> buttons = homePageFAQs.getFAQsButtons();

		for (WebElement button : buttons)

		{
			log.debug("Clicking FAQs tabs");
			button.click();
			homePageFAQs.waitForDescription();

		}

		log.info("Checking for FAQs - booking Condition");
		Assert.assertEquals(homePageFAQs.getFAQsDescription().get(0),
				"The booking conditions will be shown in the booking process under “details”. You will also find them on your booking confirmation.");
		log.info("Checking for FAQs - price Features");
		Assert.assertEquals(homePageFAQs.getFAQsDescription().get(1), prop.getProperty("priceFeatures"));
		log.info("Checking for FAQs - break fast Or Dinner");
		Assert.assertEquals(homePageFAQs.getFAQsDescription().get(2), prop.getProperty("breakfastOrDinner"));
		log.info("Checking for FAQs - price Guarantee");
		Assert.assertEquals(homePageFAQs.getFAQsDescription().get(3), prop.getProperty("priceGuarantee"));
		log.info("Checking for FAQs - check In");
		Assert.assertEquals(homePageFAQs.getFAQsDescription().get(4), prop.getProperty("checkIn"));

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}

//int i,j;
//for(i = 0, j=0; i<= homePageFAQs.getFAQsDescription().size()-1 && j <=homePageFAQs.FAQsAnswers().size()-1; i++,j++) {
////	homePageFAQs.getFAQsButtons().get(i).click();
////	homePageFAQs.waitForDescription();
////	System.out.println(homePageFAQs.FAQsAnswers().get(j));
//
//	Assert.assertEquals(homePageFAQs.getFAQsDescription(), homePageFAQs.FAQsAnswers().get(j));
//}
//
//
//
