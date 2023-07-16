package org.sof;


	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;

		import io.github.bonigarcia.wdm.WebDriverManager;

		public class Baseclass {
			
			public static  WebDriver driver;
			
			public static void main(String[] args) {
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\SeleniumInstallation\\Driver\\chromedriver.exe");
			    WebDriver driver = new ChromeDriver();
			
				}	
			public static void launchbrowser(String string) {
				WebDriverManager.chromedriver().setup();
				driver =  new ChromeDriver();			
			}
			public static void windowmaximize() {
			    driver.manage();	
			}
			public static void launchUrl(String Url) {
				driver.get(Url);		
			}
			public static void pageTitle() {
				String title = driver.getTitle();	
				System.out.println(title);
			}
			public static void pageUrl() {
				String currentUrl = driver.getCurrentUrl();	
				System.out.println(currentUrl);
			}
			public static void clickButton(WebElement ele) {
				ele.click();
			}
			public static void passText(String text,WebElement ele) {
				ele.sendKeys(text);
			}
			public static void closeEntireBrowser() {
				driver.quit();	
			}
			
			public static void screenShot(String imgName)throws IOException {
				TakesScreenshot ts = (TakesScreenshot)driver;
				File image = ts.getScreenshotAs(OutputType.FILE);
				File f = new File("location+imgName.png");
				FileUtils.copyFile(image, f);	
			}
			public static Actions a;

			public static void moveTheCursor(WebElement targetWebElement) {
				a = new Actions(driver);
				a.moveToElement(targetWebElement).perform();		
			}	
			public static void dragdrop(WebElement dragWebElement,WebElement dropElement) {
				a = new Actions(driver);
				a.dragAndDrop(dragWebElement, dropElement).perform();		
			}
			public static JavascriptExecutor js;
			private static Sheet mySheet;
			private static long d;
			private static int getRow;
			
			public static void ScrollThePage(WebElement targetWebElement) {
				js = (JavascriptExecutor)driver;
				js.executeScript("aruguments[0].scrollIntoView(true)",targetWebElement);	
			}
			public static void Scroll(WebElement element) {
				js = (JavascriptExecutor)driver;
				js.executeScript("aruguments[0].scrollIntoView(false)",element);
			}
			

	}



