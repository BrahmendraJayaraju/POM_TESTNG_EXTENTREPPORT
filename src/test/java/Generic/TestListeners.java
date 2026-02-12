package Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;


public class TestListeners  extends AdminBaseControl implements ITestListener


{
	/*
	//For Local Execution  start...........................
	 
	@Override
	public void onTestSkipped(ITestResult result) 
	{	
		
		
		 String    description=	result.getMethod().getDescription();
		
		     
		if(result.getStatus() == ITestResult.SKIP)
		{	
			
			
			 
	
			
			
					
try {
	
	
	
		String  screenshot=WebUtilityKeys.generatescreenshot(this.getWebDriver(),result.getName());
  	   
  
      
		
		String devicename=AdminBaseControl.GetBrowsername();
		mainTest=reports.createTest(result.getTestClass().getRealClass().getName().substring(14)+" Feature "+ result.getName() +" method skipped ").assignAuthor("Testername=Brahmendra@ge.com,Dhoni@ge.com,Irfan@ge.com").assignDevice(devicename).log(Status.SKIP,result.getName()+" \"Test step method is Skipped\"",MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			
		
		
		secondTest= mainTest.createNode(description);
		
		
		 secondTest.log(Status.SKIP,result.getName());
		
		
		
		 
		
	
		
		mainTest.assignCategory("Feature"+result.getTestClass().getRealClass().getName().substring(14));
		
		
    	
           //to get skipped exception in Bug icon 
           mainTest.info(result.getThrowable());
           
    
           
           
          
           
                            
       }

     catch (Exception e) 
   {
	
    	 secondTest.log(Status.SKIP, e.getMessage());
         System.out.println("error message" + e.getMessage());
         
     
          }
       
           
	}
		
		
		reports.flush();
		
	}	
		
	
*/


/*
	
	//Grid Skip start.............................
	
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{	
		
		
		 String    description=	result.getMethod().getDescription();
		
		     
		if(result.getStatus() == ITestResult.SKIP)
		{	
			
			
			 
	
			
			
					
try {
	
	
	
		String  screenshot=WebUtilityKeys.generateScreenshot(this.getWebDriver(),result.getName());
  	   
   
      
		String devicename=AdminBaseControl.GetBrowsername();
		
		mainTest=reports.createTest(result.getTestClass().getRealClass().getName().substring(14)+"_Feature_ "+ result.getName() +" method skipped ").assignAuthor("Testername=Brahmendra@ge.com,Dhoni@ge.com,Irfan@ge.com").assignDevice(devicename).log(Status.SKIP,result.getName()+" \"Test step method is Skipped\"",MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		
		
		
		secondTest= mainTest.createNode(description);
		DriverFactory.setTest(secondTest);
		
		 DriverFactory.getTest().log(Status.SKIP,result.getName()+" \"Test step method is skipped\"");
		
		
		
		 
		
	 
		
	 mainTest.assignCategory("Feature"+result.getTestClass().getRealClass().getName().substring(14));
		
		
    	
           //to get skipped exception in Bug icon 
         mainTest.info(result.getThrowable());
           
    
           
           
          
           
                            
       }

     catch (Exception e) 
   {
	
    	 DriverFactory.getTest().log(Status.SKIP, e.getMessage());
         System.out.println("error message" + e.getMessage());
         
     
          }
       
           
	}
		
		
		reports.flush();
		
	}	
*/
}
	

	


