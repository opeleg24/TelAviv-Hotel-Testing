package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageCredentials {
	public WebDriver driver;

	private By topBarAddress = By.cssSelector("div[class='sq-top-left-header']");
	private By bottomBarCredentials = By.xpath("//div[@class='sq-contact-info']/ul/li");
	private By hotelDescription = By.cssSelector("div[class='textwidget'] p");

	public HomePageCredentials(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getTopBarAddress() {
		return driver.findElement(topBarAddress);
	}
	public WebElement getHotelDescription() {
		return driver.findElement(hotelDescription);
	}


	public List<String> getBottomBarCredentials() {

		List<WebElement> credentials = driver.findElements(bottomBarCredentials);
		List<String> credentialText = new ArrayList<String>();
		for (WebElement credential : credentials) {

			credentialText.add(credential.getText());

		}
		return credentialText;

	}

}
