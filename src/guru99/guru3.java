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



public class guru3 {
	static  WebDriver driver=null;
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
		 driver = new  RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	 @Test
		public void testApp() throws MalformedURLException{
		
		 if(driver.findElement(By.id("android:id/home")).isDisplayed())
			{
				System.out.println(" Guru 99 App Home Page is displayed ");
			}
			
			/*  To click on Quiz Button */
			driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
			
			/* To click on Quality Center Quiz item
			 */
			driver.findElement(By.name("Quality Center")).click();
			
			/* Questions & Answers Verification  */
			
			//First Question
			String question1 = driver.findElement(By.id("com.vector.guru99:id/question")).getText();
			System.out.println(" First Question :  "+ question1);
			/* Getting Time Remaining */
			String timeForFirstQues = driver.findElement(By.id("com.vector.guru99:id/timer")).getText();
			System.out.println("Time Remaining:  "+ timeForFirstQues);
			/* Clicking on Answer and Next */
			driver.findElement(By.id("com.vector.guru99:id/option2")).click();
			driver.findElement(By.id("com.vector.guru99:id/next")).click();
			
			//Second Question 
			/*
			String question2 = driver.findElement(By.id("com.vector.guru99:id/question")).getText();
			System.out.println("Second Question :  "+ question2);
		//	 Getting Time Remaining 
			String timeForSecondQues = driver.findElement(By.id("com.vector.guru99:id/timer")).getText();
			System.out.println("Time Remaining:  "+timeForSecondQues);
			// Clicking on Answer and Finish 
			driver.findElement(By.id("com.vector.guru99:id/option1")).click();
			driver.findElement(By.id("com.vector.guru99:id/finish")).click();
			*/
			
			/* Result */
			if(driver.findElement(By.id("com.vector.guru99:id/heading")).isDisplayed())
			{
				System.out.println(" Test Results: ");
				System.out.println(driver.findElement(By.id("com.vector.guru99:id/score")).getText());
			}
			
		
		
			
		 
	 }
	 @After
	 public void teardown(){
	     //close the app
	     driver.quit();
	 }
	 
}
