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

import io.appium.java_client.android.AndroidDriver;

public class guru2Text {
	
	 static  AndroidDriver driver;

public void scrollToExact(String text)
	 	{                
	 	 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
	 	}

	@BeforeClass
	 public static void  setUp() throws Exception {
	//location of the app
	 File app = new File("C:\\Users\\TCEGULBAS\\Desktop\\apkDos", "Guru99.apk");
	 //To create an object of Desired Capabilities

	 DesiredCapabilities capability = new DesiredCapabilities();
	//OS Name
	// capability.setCapability("device","emulator-5556");
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
	 driver = new  AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
		

	 }
			 @Test
			 
				public void testApp() throws MalformedURLException{
					 
				//Set<String> allElementsText = new HashSet<String>();
					
					/* Home Page Verification */
					if(driver.findElement(By.id("android:id/home")).isDisplayed())
					{
						System.out.println(" Guru 99 App Home Page is displayed ");
					}
					
					/* Click on SAP Course in Course Category */
					int i=0;
					while(i<=5) {
					driver.findElement(By.name("Course Category")).click();
					List<WebElement> courseList = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));
					courseList.get(i).click();
					courseList.get(i).click();
					i++;
					}
					
					/* Child Elements count Verification */
//					List<WebElement> sapChildElements = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
//					for(WebElement element: sapChildElements)
//					{
//						//String text = element.getText();
//						//allElementsText.add(text);
////						String cours = element.get();
////						System.out.println(cours); //Print each course name
//						
//						
//					}
//					
//					scrollToExact("SAP BI");
//					
//					List<WebElement>sapChildElements2 = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
//					for(WebElement element: sapChildElements2)
//					{
//						String text = element.getText();
//						System.out.println(text); //Print each course name
//						//allElementsText.add(text);
//					}
//					
					/*for(String s : allElementsText)
					{
						System.out.println(s);
					}
					
					int childElementsCount = allElementsText.size();
					if(childElementsCount == 11)
					{
						System.out.println("Sap course Sub Contents are equal ");
					}
					*/
				
				driver.quit();
			}
						
				
}
