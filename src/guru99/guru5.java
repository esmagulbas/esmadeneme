package guru99;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class guru5 {
	static  AndroidDriver driver=null;

		public void scrollToExact(String text)
			{                
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
			}
			

	@BeforeClass
	 public static void  setUp() throws Exception {
		 File app = new File("C:\\Users\\TCEGULBAS\\Desktop\\apkDos", "Guru99.apk");
		 //To create an object of Desired Capabilities

		 DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		 capability.setCapability("device","emulator-5554");
		 capability.setCapability(CapabilityType.BROWSER_NAME, "");
		//Mobile OS version. In My case its running on Android 4.2
		 capability.setCapability(CapabilityType.VERSION, "4.2");
		 capability.setCapability("app", app.getAbsolutePath());
		//To Setup the device name
		 capability.setCapability("deviceName","test");
		 capability.setCapability("platformName","Android");
		//set the package name of the app
		 capability.setCapability("app-package", "com.vector.guru99");
		 //set the Launcher activity name of the app
		 capability.setCapability("app-activity", "com.vector.guru99.BaseActivity");
		//driver object with new Url and Capabilities
		 driver = new  AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	 @Test
		public void testApp() throws MalformedURLException{
	
		//Step1  - Verify home page
			if(driver.findElement(By.name("Guru99")).isDisplayed())
				System.out.println("Home page is displayed");
			else
				System.out.println("home page is not displayed");
			
	//step2 - click on Course List tab
		driver.findElement(By.name("Course List")).click();
	
		
	//Step 3 - darg until PHP course found and click on it
	//driver.scrollToExact("PHP");
		scrollToExact("PHP");
		driver.findElement(By.name("PHP")).click();
		
	//Step 4 - Click on Lesson 1 and verify the lesson1
		driver.findElement(By.name("Lesson #1")).click();

		if(driver.findElement(By.name("What is PHP? Write your first PHP Program")).isDisplayed())
		System.out.println("First Lesson is opened");
		else
			System.out.println("First lesson not opened");
		
		//Go to next lesson
		driver.findElement(By.name("Next")).click();
		
		//verify 2nd lesson title
		
		if(driver.findElement(By.name("Step by step instruction on XAMPP & Netbeans installation")).isDisplayed())
			System.out.println("second Lesson is opened");
			else
			System.out.println("second lesson is not opened");

	 }
	 
	 @After
	 public void teardown(){
	     //close the app
	     driver.quit();
	 }
	 }

