package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactory.Add2cartpage;
import pageFactory.Departmentpage;
import pageFactory.HomePage;
import pageFactory.Itemspage;
import pageFactory.Itemssublistpage;
import pageFactory.Sucessmsgpage;
import xls.ShineXlsReader;

public class TestBase {
	
	public static Properties prop;
	public static String Browser;
	public static WebDriver driver;
	public static SoftAssert st;
	public static HomePage hp;
	public static Departmentpage dp;
	public static Itemspage ip;
	public static Itemssublistpage isp ;
	public static Sucessmsgpage sp ;
	public static Add2cartpage acp;
	public static ShineXlsReader Mxls;
	public static HashMap<String,String> map;
	
	
	
	public static void openBrowser() throws Throwable, Throwable{
		st=new SoftAssert();
		prop=new Properties();
		prop.load(new FileReader("src\\test\\java\\config\\Global.properties"));
		Browser=prop.getProperty("Browser");
		System.out.println("Browser ="+Browser);
		if(Browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(Browser.equalsIgnoreCase("mozilla"))
			driver=new FirefoxDriver();
		else if(Browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
	
		driver.get(prop.getProperty("url"));//open url
		driver.manage().window().maximize();//maximize browserwindow
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		initiclass();
		moduledriver();
	}
	
	
	public static void moduledriver(){
		map=new HashMap<String,String>();
		Mxls=new ShineXlsReader("src\\test\\java\\exelFiles\\ModuleDriver.xlsx");
		int modulecount = Mxls.getRowCount("MainSheet");
		for(int i=2;i<=modulecount;i++){
			String modulename = Mxls.getCellData("MainSheet", 0, i);
			String exestatus = Mxls.getCellData("MainSheet", 1, i);
			if(exestatus.equalsIgnoreCase("yes")){
				int featurecount = Mxls.getRowCount(modulename);
				for(int j=2;j<=featurecount;j++){
					String featurename = Mxls.getCellData(modulename, 0, j);
					String runstatus = Mxls.getCellData(modulename, 1, j);
					map.put(featurename, runstatus);
				}
			}
		}
	}
	
	
	public static void initiclass(){
		  hp = PageFactory.initElements(driver, HomePage.class);
		  dp = PageFactory.initElements(driver, Departmentpage.class);
	      ip = PageFactory.initElements(driver, Itemspage.class);
	      isp = PageFactory.initElements(driver, Itemssublistpage.class);
	      sp = PageFactory.initElements(driver, Sucessmsgpage.class);
	      acp = PageFactory.initElements(driver, Add2cartpage.class);
	}
	
	
	
	//@Test(priority=1)
	public static void closeBrwoser(){
		driver.quit();
	}

}
