package guru99;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class deneme {
	static  WebDriver driver=null;
	@BeforeClass
	 public static void  setUp() throws Exception {
	//location of the app
	File app = new File("C:\\Users\\TCEGULBAS\\Desktop\\apkDos", "Guru99.apk");
	 //To create an object of Desired Capabilities

	 DesiredCapabilities capability = new DesiredCapabilities();
	//OS Name
	// capability.setCapability("device","emulator-5554");
	 capability.setCapability(CapabilityType.BROWSER_NAME, "");
	//Mobile OS version. In My case its running on Android 4.2
	 capability.setCapability(CapabilityType.VERSION, "4.2");
	 capability.setCapability("app", app.getAbsolutePath());
	//To Setup the device name
	 capability.setCapability("deviceName","Galaxy-4d003f7649cb80f1");
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
		 
		 if(driver.findElement(By.name("Guru99")).isDisplayed())
				System.out.println("guru99 header is displayed");
			else
				System.out.println("guru99 header is not displayed");
			
			//verification 2- is Course Category selected
			if(driver.findElement(By.name("Course Category")).isSelected())
				System.out.println("Course Category is currently selected");
			else
				System.out.println("Course Category is not selected");
			
			//Get all the courses listed in the course category
			
			//get all the courses and store them in a List
			List<WebElement> coursesOffered = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));
			
			//iterating the list to perform action on each webelement
			System.out.println("coourse offered are and their state ");
			for(WebElement course : coursesOffered)
			{
				String cours = course.getText();
				System.out.print(cours); //Print each course name
				if(course.isEnabled())
					System.out.print(" and it is enblaed");
				else
					System.out.print(" and it is not enalbed");
				System.out.println();
			
		}
			driver.quit();
		
		}

}
