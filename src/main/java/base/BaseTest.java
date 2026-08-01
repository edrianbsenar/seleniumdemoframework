package base;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;
import utils.ElementFetch;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public ElementFetch ele = new ElementFetch();

	public void beforeTestMethod(String browser) {
		String reportname = "REGRESSION_" + browser.toUpperCase();
		reportname = reportname.replace("-HEADLESS", "");
		String reportPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + reportname + File.separator + reportname + "_TESTING.html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Browser", browser);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName(reportname);
	}

	public void afterMethod(ITestResult result, String browser) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skip", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}

		try {
			if (driver != null) {
				String testName = result.getName();
				if (testName == null || testName.isEmpty()) {
					testName = result.getMethod().getMethodName();
				}
				System.out.println("Capturing screenshot for test: " + result.getName());
				String reportname = "REGRESSION_" + browser.toUpperCase();
				reportname = reportname.replace("-HEADLESS", "");
				captureScreenshot(result.getName(), reportname);
			}
		} catch (NoSuchSessionException e) {
			System.err.println("No active session to capture screenshot for test: " + result.getName() + ". Error: " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
			extent.flush();
		}
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

	public void setupDriver(String browser) {
		switch (browser) {
			case "chrome":
			case "chrome-headless":
				ChromeOptions options = new ChromeOptions();
				if (browser.contains("headless")) {
					options.addArguments("--headless");
				}
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-extensions");
				options.setCapability("acceptInsecureCerts", true);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
		}
	}

	public void captureScreenshot(String screenshotName, String reportname) {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String baseDir = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + reportname + File.separator + "img-src";
			File screenshotDir = new File(baseDir);
			if (!screenshotDir.exists()) {
				screenshotDir.mkdirs();
			}

			File destFile = new File(screenshotDir, screenshotName + "_" + timestamp + ".png");
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());

			String relativeImagePath = "." + File.separator + "img-src" + File.separator + screenshotName + "_" + timestamp + ".png";
			logger.pass("Screenshot: " + screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(relativeImagePath).build());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters({"browser"})
	public void initializeBrowser(String browser, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("URL: " + Constants.url);
	}

	public void click(String webElement) {
		try {
			ele.getXPATHWebElement(webElement).click();
		} catch (Exception e) {
			WebElement element = driver.findElement(By.xpath(webElement));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void sendKeys(String webElement, String keysToSend) {
		ele.getXPATHWebElement(webElement).sendKeys(keysToSend);
	}

	public void sendKeysElement(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void clear(String webElement) {
		ele.getXPATHWebElement(webElement).sendKeys(Keys.CONTROL, "a");
		ele.getXPATHWebElement(webElement).sendKeys(Keys.chord(Keys.DELETE));
	}

	public void clearElement(WebElement element) {
		element.sendKeys(Keys.CONTROL, "a");
		element.sendKeys(Keys.chord(Keys.DELETE));
	}

	public int generate4Digit() {
		Random rand = new Random();
		int intRandom = rand.nextInt(9000) + 1000;
		return intRandom;
	}

	public String generateRandomEmail() {
		return "test" + generate4Digit() + "@mailinator.com";
	}

	public void assertElementIsDisplayed(String webElement) {
		try {
			WebElement element = driver.findElement(By.xpath(webElement));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.isDisplayed(), "The element is not displayed.");
		} catch (NoSuchElementException e) {
			throw new AssertionError("Element not found: " + webElement, e);
		} catch (org.openqa.selenium.TimeoutException e) {
			throw new AssertionError("Element was not visible within the timeout: " + webElement, e);
		}
	}

	public void assertElementIsDisplayed(WebElement element, String elementName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.isDisplayed(), elementName + " is not displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			throw new AssertionError(elementName + " was not visible within the timeout.", e);
		}
	}

	public void assertTextIsDisplayed(String webElement, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
		assertTrue(element.getText().toLowerCase().contains(expectedText.toLowerCase()), "Expected text '" + expectedText + "' but found '" + element.getText() + "'");
	}

	public void selectElementByVisibleText(String webElement, String visibleText) {
		WebElement element = ele.getXPATHWebElement(webElement);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectElementByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectElementByValue(String webElement, String value) {
		WebElement element = ele.getXPATHWebElement(webElement);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void scrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
	}

	public void scrollToElement(String webElement) {
		WebElement element = ele.getXPATHWebElement(webElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
	}

	public void waitForElement(String webElement, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
	}

	public void waitForElement(WebElement element, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(String webElement, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
	}

	public void handleAlertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void uploadFile(String webElement, String filePath) {
		WebElement element = ele.getXPATHWebElement(webElement);
		element.sendKeys(filePath);
	}

	public boolean isElementPresent(String webElement) {
		try {
			driver.findElement(By.xpath(webElement));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void mouseHover(String webElement) {
		WebElement element = ele.getXPATHWebElement(webElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
		((JavascriptExecutor) driver).executeScript("var event = new MouseEvent('mouseover', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(event);", element);
	}

	public void mouseHover(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
		((JavascriptExecutor) driver).executeScript("var event = new MouseEvent('mouseover', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(event);", element);
	}

}
