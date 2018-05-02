package guru99;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class fizygazete {
	
	static  WebDriver driver=null;
//	protected WebDriverWait wait;
	public static final int DEFAULT_WAIT = 15;
	
/*	public fizy(AndroidDriver driver) {
		wait = new WebDriverWait(driver, DEFAULT_WAIT, 1000);
	}*/
	
	@BeforeClass
	 public static void  setUp() throws Exception {
		 File app = new File("C:\\Users\\TCEGULBAS\\Desktop\\apkDos", "dergilik-regular-turkcellRelease.apk");
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
		 capability.setCapability("app-package", "com.arneca.dergilik.main3x");
		 //set the Launcher activity name of the app
		 capability.setCapability("app-activity", "com.solidict.dergilik.activities.SignInActivity");
		//driver object with new Url and Capabilities
		 driver = new  RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		 driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		/*WebElement bar=driver.findElement(By.id("com.arneca.dergilik.main3x:id/iv_kullanici_button"));
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.arneca.dergilik.main3x:id/iv_left")));

		*/
	}
	 @Test
		public void testApp() throws MalformedURLException{
		 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 	
		 	//click gazete tab
		 	driver.findElement(By.id("com.arneca.dergilik.main3x:id/iv_gazete_button")).click();
		 
		 	//gazete tıkla
		 	List<WebElement> gazete=  driver.findElements(By.className("android.widget.LinearLayout"));
		
			gazete.get(1).click();
		
		 	
		 	/*
		 	 * 	List<MobileElement> textFields1 = driver.findElements(By.id("com.arneca.dergilik.main3x:id/ll_item"));
		textFields1.get(3).click();
		 	 */
		
			/*  To click login botton */
			driver.findElement(By.id("com.arneca.dergilik.main3x:id/tv_aylik_abone")).click();
			
			/* To click on Quality Center Quiz item
			 */
			driver.findElement(By.id("com.arneca.dergilik.main3x:id/et_phone")).sendKeys("5380099999"); 
			
			//btnClick Continue
			driver.findElement(By.id("com.arneca.dergilik.main3x:id/tv_kod_iste")).click();
			
			WebElement c1= driver.findElement(By.id("com.arneca.dergilik.main3x:id/et_number1")); 
			c1.sendKeys("1234");
		
			//com.arneca.dergilik.main3x:id/et_number1
			
			
	 }
	 	
	 @After
	 public void teardown(){
	     //close the app
	     driver.quit();
	 }

}
