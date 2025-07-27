package testcases;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {
	//WebDriver driver;
	DesiredCapabilities cap;
	
	@Test(dataProvider="getdata1")
	public void testCase1(String cname,String cpassword, String Browser) throws Throwable{
		System.out.println("Browser="+Browser);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shrinivas\\Downloads\\SeleniumFiles_NSEit\\Grid+Maven\\GridNotes\\BrowserDrivers\\chromedriver.exe");
		//driver=new ChromeDriver();
		if(Browser.equalsIgnoreCase("chrome")){
			cap=DesiredCapabilities.chrome();
			cap.setPlatform(Platform.WINDOWS);
		}else if(Browser.equalsIgnoreCase("firefox")){
			cap=DesiredCapabilities.firefox();
			cap.setPlatform(Platform.ANY);
		}
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"), cap);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Login
		driver.findElement(By.id("login1")).sendKeys(cname);
		driver.findElement(By.id("password")).sendKeys(cpassword);
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getdata1(){
		Object obj[][]=new Object[3][3];
		
		obj[0][0]="Name1";
		obj[0][1]="pwd1";
		obj[0][2]="chrome";
		
		obj[1][0]="Name2";
		obj[1][1]="pwd2";
		obj[1][2]="chrome";
		
		obj[2][0]="Name3";
		obj[2][1]="pwd3";
		obj[2][2]="chrome";
		
		return obj;
		
		
		
	}
	
}
