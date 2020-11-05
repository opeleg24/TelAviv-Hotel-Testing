package TelAvivHotel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

import pageObjects.BlogPage;

import pageObjects.TopNavSocialMediaLinks;
import resources.base;

public class ValidateBlogPostsPage extends base {

	public WebDriver driver;
	public BlogPage blogPage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		blogPage = new BlogPage(driver);

	}

	@Test(priority = 1)

	public void validateCenterblogPageLink() throws IOException {
		log.debug("Clicking BLOG Page Link");
		blogPage.clickMiddleLink().click();
		log.info("Verifying BLOG Page Center Nav");

	}

	@Test(priority = 2)

	public void validateTopblogPageLink() throws IOException {
		log.debug("Clicking BLOG Page Link");
		blogPage.clickTopLink().click();
		log.info("Verifying BLOG Page Top Nav");
//		blogPage.waitForBlogText();
		Assert.assertEquals(blogPage.getBlogPageText().getText(), "BLOG");

	}

	@Test(priority = 3)

	public void validateNavblogPageLink() throws IOException {
//		blogPage.waitForBlogLink() ;
		log.debug("Clicking BLOG Page Link");
		blogPage.clickBottomLink().click();
		log.info("Verifying BLOG Page Bottom Nav");
//		blogPage.waitForBlogText();
		Assert.assertEquals(blogPage.getBlogPageText().getText(), "BLOG");

	}

	@Test(priority = 4)

	public void validateBlogArticalesAndSuccessPostingReply() throws IOException, InterruptedException {
		int i, j;
		for (i = 0, j = 0; i <= blogPage.getBlogLinks().size() - 1
				&& j <= blogPage.blogPageTitleText().size(); i++, j++) {
			log.debug("Clicking BLOG article Link");
			blogPage.getBlogLinks().get(i).click();
			log.info("Verifying BLOG article Link");
			Assert.assertEquals(blogPage.getBlogPageText().getText(), blogPage.blogPageTitleText().get(j));
			blogPage.getComment().clear();
			log.debug("sending comment information");
			blogPage.getComment().sendKeys(prop.getProperty("commentReply"));
			blogPage.getAuthor().clear();
			log.debug("sending comment name");
			blogPage.getAuthor().sendKeys(prop.getProperty("nameReply"));
			blogPage.getEmail().clear();
			log.debug("sending comment email");
			blogPage.getEmail().sendKeys(prop.getProperty("emailReply"));
			blogPage.getUrl().clear();
			log.debug("sending comment url");
			blogPage.getUrl().sendKeys(prop.getProperty("urlReply"));
			log.debug("save info");
			blogPage.getInfoBox().click();
			TimeUnit.SECONDS.sleep(10);
			log.debug("sumbit replay post");
			blogPage.sumbit().click();
			blogPage.waitReplySuccessMsg();
			log.info("Verifying comment registered in system");
			Assert.assertEquals(blogPage.getSuccessMessage().getText(), "Your comment is awaiting moderation.");

		}

	}

	@Test(priority = 5)

	public void validateBlogArticalesAndFailureOnPostingReply() throws IOException, InterruptedException {
		int i, j;
		for (i = 0, j = 0; i <= blogPage.getBlogLinks().size() - 1
				&& j <= blogPage.blogPageTitleText().size(); i++, j++) {
			log.debug("Clicking BLOG article Link");
			blogPage.getBlogLinks().get(i).click();
			log.info("Verifying BLOG article Link");
			Assert.assertEquals(blogPage.getBlogPageText().getText(), blogPage.blogPageTitleText().get(j));
			blogPage.getComment().clear();
			log.debug("sending comment information");
			blogPage.getComment().sendKeys(prop.getProperty("commentReply"));
			blogPage.getUrl().clear();
			log.debug("sending comment url");
			blogPage.getUrl().sendKeys(prop.getProperty("urlReply"));
			log.debug("save info");
			blogPage.getInfoBox().click();
			TimeUnit.SECONDS.sleep(5);
			log.debug("sumbit replay post");
			blogPage.sumbit().click();
			log.info("Verifying comment not registered in system");
			Assert.assertEquals(blogPage.getErrorMessage().getText(),
					"ERROR: please fill the required fields (name, email).");
			blogPage.getErrorMessageBackButton().click();

		}

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
