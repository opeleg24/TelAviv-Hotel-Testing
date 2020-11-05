package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageFAQs {
//	put them buttons in list then loop throug list click and then take secnd list with description amd match assert
	public WebDriver driver;
	private By buttons = By.cssSelector("div[class*='faq-display-style-Default']");
	private By FAQsDescription = By.cssSelector("div[class*='ufaq-faq-post']");

	public HomePageFAQs(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public List<WebElement> getFAQsButtons() {
		return driver.findElements(buttons);
	}

	public List<String> getFAQsDescription() {

		List<WebElement> FAQsDescriptionList = driver.findElements(FAQsDescription);
		List<String> FAQsDescriptionListText = new ArrayList<String>();
		for (WebElement text : FAQsDescriptionList) {

			FAQsDescriptionListText.add(text.getText());

		}
		return FAQsDescriptionListText;

	}

	public List<String> FAQsAnswers() {

		List<String> FAQsAnswer = Arrays.asList(
				"The booking conditions will be shown in the booking process under “details”. You will also find them on your booking confirmation.",
				"A detailed overview will be shown beneath the rate grid, if you click on a rate or category. The rate description will show every included service.",
				"Yes, of course you can enjoy a meal or drink in one of our restaurants or bars. You may also reserve a table with our table reservation form on each restaurant website.",
				"When booking through our website www.dorint.com, via our service center or directly in our hotel, we guarantee, that you will get the best available rate. In case you will find a cheaper price after your booking, you will receive the cheaper rate less 25% discount",
				"Generally hotel rooms are available from 3pm and apartments from 5pm.");
		return FAQsAnswer;

	}

	public void waitForDescription() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(FAQsDescription));
	}

}
