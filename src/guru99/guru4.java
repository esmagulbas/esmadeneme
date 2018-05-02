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
import org.openqa.selenium.firefox.FirefoxDriver;


public class guru4 {
	static  WebDriver driver=null;
	@BeforeClass
	 public static void  setUp() throws Exception {
		 File app = new File("C:\\Users\\TCEGULBAS\\Desktop\\apkDos", "Guru99.apk");
		 //To create an object of Desired Capabilities

		 DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		 capability.setCapability("device","emulator-5556");
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
		 driver = new  RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	 @Test
		public void testApp() throws MalformedURLException{
		//Step1  - Verify home page
			if(driver.findElement(By.name("Guru99")).isDisplayed())
				System.out.println("Home page is displayed");
			else
				System.out.println("home page is not displayed");
			
	//step2 - click the Interview button and questions are displayed
		driver.findElement(By.name("Interview")).click();
	
		
	//Step 3 - Click java and followed with structs
		driver.findElement(By.name("JAVA")).click();
		driver.findElement(By.name("Top 50 Struts Interview Questions")).click();
		
	//Step 4 - Click on show answer button and press next
		driver.findElement(By.id("com.vector.guru99:id/show_answer")).click();
		driver.findElement(By.name("Next")).click();
	 }
	 
	 @After
	 public void teardown(){
	     //close the app
	     driver.quit();
	 }
	 

}
