
package Generic;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;



public  class DriverFactory 
{

	
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	

	// For Browser 
	
	ThreadLocal<RemoteWebDriver> drivers= new ThreadLocal<RemoteWebDriver>();
	
	

	
	
	public static void setDriver(WebDriver WebDriver)
	
	{
		driver.set(WebDriver);
	}
	
	 public static WebDriver getDriver() 
	 {
	        return driver.get();
	    }
	 
	 
	
	public  static void removeDriver()
	{
		driver.get().quit();
		driver.remove();
	}
	
	
	//For Test in Extent Reports Testnames
	
	public static ThreadLocal<ExtentTest>  extentTestThreadSafe = new ThreadLocal<ExtentTest>(); 
	   
	public static synchronized ExtentTest getTest() 
	{ 
	  return extentTestThreadSafe.get(); 
	}
	public static void setTest(ExtentTest tst) 
	{ 
	   extentTestThreadSafe.set(tst); 
	}
	
	
	
	// For Extent Report Category
	public static ThreadLocal<ExtentTest>  extentTestcategory = new ThreadLocal<ExtentTest>();
	
	
	public static synchronized ExtentTest getTestcategory() 
	{ 
	  return extentTestcategory.get(); 
	}
	public static void setTestcategory(ExtentTest tst) 
	{ 
		extentTestcategory.set(tst); 
	}
	
	
	
			

	

	
	
	
	
	
	
	
}