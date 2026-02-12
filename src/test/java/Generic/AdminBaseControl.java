package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;





public class AdminBaseControl extends DriverFactory {
	String chrome_key = "webdriver.chrome.driver";

	String chrome_value = "./Drivers/chromedriver";

	String Gecko_key = "webdriver.gecko.driver";

	String Gecko_value = "";

	String Edge_key = "webdriver.edge.driver";

	String Edge_value = "";



	   
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentTest mainTest;
    public static ExtentTest secondTest;
    public static ExtentTest DeviceTest;
	public static String setUpData = "/TestEnviornmentSetUp/BasicTestSetUp.properties";
	public static String objectRepo = "/ObjectRepository/Login.properties";
	

	public static String testData = "/TestData/TestLogin.properties";
	String Concatenate=".";

	// For Normal execution

    public WebDriver getWebDriver()
    {
        return driver;
    }
    
    
    @Parameters("browsername")
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browsername) throws Exception {

        if (browsername.equalsIgnoreCase("chrome")) {

   
        	ChromeOptions options = new ChromeOptions();


        	  options.addArguments("--headless=new");
              options.addArguments("--no-sandbox");
              options.addArguments("--disable-dev-shm-usage");
              options.addArguments("--disable-gpu");
              options.addArguments("--window-size=1920,1080"); 

            driver = new ChromeDriver(options);
            DriverFactory.setDriver(driver);
        }
    

	    else if (browsername.equalsIgnoreCase("firefox")) {

	        System.setProperty(Gecko_key, Gecko_value);
	        driver = new FirefoxDriver();

	    }
	    else if (browsername.equalsIgnoreCase("edge")) {

	        System.setProperty(Edge_key, Edge_value);
	        driver = new EdgeDriver();

	    }
	    else {
	        throw new Exception("Browser is not correct: " + browsername);
	    }



	
	    driver.manage().window().maximize();

	    String url = WebUtilityKeys.readPropertyFiles(setUpData, "URL");
	    driver.get(url);
	    
	    /* ================= EXTENT REPORT SETUP ================= */

	    String reportPath = "Project_Report/ExtentReport.html";

	    reports = new ExtentReports();
	    htmlReporter = new ExtentSparkReporter(reportPath);

	
	   	
	       
	      
	   	htmlReporter.config().setTheme(Theme.DARK);
	   	htmlReporter.config().setDocumentTitle("Actitime TestReport");
	   	htmlReporter.config().setTimelineEnabled(true);
	   	
	   	
	   
	   	reports.attachReporter(htmlReporter);
	   	
	   	
	   	
	   	if
	       (WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals("SanityTestCases"))
	       {
	           htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(setUpData,"SanityReportName"));
	           reports.setSystemInfo("No. Of Test cases", WebUtilityKeys.readPropertyFiles(setUpData,"SanityTestCases"));
	           reports.setSystemInfo("Testing Scope", WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope"));
	       }
	       else if(WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals("RegressionTestCases"))
	       {
	           htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(setUpData,"RegressionReportName"));
	           reports.setSystemInfo("No. Of Test cases",WebUtilityKeys.readPropertyFiles(setUpData,"RegressionTestCases"));
	           reports.setSystemInfo("Testing Scope", WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope"));
	       }

	       else if(WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals("UserStories"))
	       {
	           htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(setUpData,"FunctionalName"));
	           reports.setSystemInfo("No. Of Test cases", WebUtilityKeys.readPropertyFiles(setUpData,"FuctionalTestcases"));
	           reports.setSystemInfo("Testing Scope", WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope"));
	       }
	   	
	   	
	   	reports.setSystemInfo("UserName", WebUtilityKeys.readPropertyFiles(setUpData,"UserName"));
	       reports.setSystemInfo("OS", WebUtilityKeys.readPropertyFiles(setUpData,"OS"));
	       reports.setSystemInfo("Environment", WebUtilityKeys.readPropertyFiles(setUpData,"Environment"));
	       reports.setSystemInfo("Device", WebUtilityKeys.readPropertyFiles(setUpData,"Device"));
	   	
	       reports.setSystemInfo("BrowserName", WebUtilityKeys.readPropertyFiles(setUpData,"Browser")); 
	       reports.setReportUsesManualConfiguration(false);
	}


	
	

	
	
	
	

	@AfterMethod
	public void PostConditionTestStatus(ITestResult result) throws Exception {

		ITestNGMethod m = result.getMethod();
		String name = m.getMethodName();
 
		if (result.getStatus() == ITestResult.SUCCESS) {

			WebUtilityKeys.assignTestCategories(result.getTestClass().getRealClass().getName().substring(10));

			String screenshot =WebUtilityKeys.generateScreenshot(this.getWebDriver(), name);

			secondTest.log(Status.PASS, name, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

		}

		else if (result.getStatus() == ITestResult.FAILURE) {

			WebUtilityKeys.assignTestCategories(result.getTestClass().getRealClass().getName().substring(10));

			try {

				String screenshot =WebUtilityKeys.generateScreenshot(this.getWebDriver(), name);
				secondTest.log(Status.FAIL, name, MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());

				Reporter.log("screenshotname:" + screenshot, true);

				
				
				
				secondTest.info(result.getThrowable());

			}

			catch (Exception e) {

			}
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			WebUtilityKeys.assignTestCategories(result.getTestClass().getRealClass().getName().substring(10));

			secondTest.log(Status.SKIP, name);

			secondTest.log(Status.SKIP, result.getThrowable());

		}

		reports.flush();

	}

	@AfterClass
	public void addToReport() {
		reports.flush();

	}

    @AfterSuite
    public void closeDriver()
    {
        driver.quit();
    }
    
	

	// For Grid Local Execution Starting
	// Start HUB and all Nodes before Execution

	/*
	 * public static void createTestName(String testName,String description,String
	 * Authorname) throws Exception
	 * 
	 * {
	 * 
	 * String devicename=WebUtilityKeys.readPropertyFiles(setUpData,"Device");
	 * 
	 * 
	 * 
	 * mainTest =
	 * reports.createTest(testName).assignAuthor(Authorname).assignDevice(devicename
	 * ); secondTest = mainTest.createNode(description);
	 * 
	 * DriverFactory.setTest(secondTest);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public static void assignTestCategories(String pageName) {
	 * DriverFactory.setTestcategory(mainTest);
	 * 
	 * DriverFactory.getTestcategory().assignCategory(pageName);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * //GRID public static WebDriver getWebDriver() { return
	 * DriverFactory.getInstance().getWebDriverinstance(); }
	 * 
	 * 
	 * 
	 * //GRID individual Browser parallel Execution Reports
	 * 
	 * @Parameters("Browser")
	 * 
	 * @BeforeSuite public void extentReportSetUpGrid(String Browser) throws
	 * Exception
	 * 
	 * {
	 * 
	 * if(Browser.equalsIgnoreCase("chrome")) { //String ReportPath=
	 * ""+
	 * timestamp(); String ReportPath=
	 * "";
	 * 
	 * 
	 * 
	 * reports = new ExtentReports(); htmlReporter = new
	 * ExtentSparkReporter(ReportPath);
	 * 
	 * htmlReporter.config().setTheme(Theme.DARK);
	 * htmlReporter.config().setDocumentTitle("");
	 * htmlReporter.config().setTimelineEnabled(true);
	 * 
	 * reports.attachReporter(htmlReporter); reports.setSystemInfo("BrowserName",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"ChromeBrowserversion")); }
	 * 
	 * 
	 * else if (Browser.equalsIgnoreCase("firefox")) { //String ReportPath=
	 * ""+
	 * timestamp(); String ReportPath=
	 * "";
	 * 
	 * 
	 * 
	 * reports = new ExtentReports(); htmlReporter = new
	 * ExtentSparkReporter(ReportPath);
	 * 
	 * htmlReporter.config().setTheme(Theme.DARK);
	 * htmlReporter.config().setDocumentTitle("");
	 * htmlReporter.config().setTimelineEnabled(true);
	 * 
	 * reports.attachReporter(htmlReporter); reports.setSystemInfo("BrowserName",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"FirefoxBrowserVersion")); }
	 * 
	 * else if (Browser.equalsIgnoreCase("MicrosoftEdge")) {
	 * 
	 * //String ReportPath=
	 * ""+
	 * timestamp(); String ReportPath=
	 * "";
	 * 
	 * 
	 * 
	 * reports = new ExtentReports(); htmlReporter = new
	 * ExtentSparkReporter(ReportPath);
	 * 
	 * htmlReporter.config().setTheme(Theme.DARK);
	 * htmlReporter.config().setDocumentTitle("");
	 * htmlReporter.config().setTimelineEnabled(true);
	 * 
	 * reports.attachReporter(htmlReporter);
	 * 
	 * reports.setSystemInfo("BrowserName",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"EdgeBrowserVersion"));
	 * 
	 * }
	 * 
	 * if (WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals(
	 * "SanityTestCases")) {
	 * htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(
	 * setUpData,"SanityReportName")); reports.setSystemInfo("No. Of Test cases",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"SanityTestCases"));
	 * reports.setSystemInfo("Testing Scope",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope")); } else
	 * if(WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals(
	 * "RegressionTestCases")) {
	 * htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(
	 * setUpData,"RegressionReportName"));
	 * reports.setSystemInfo("No. Of Test cases",WebUtilityKeys.readPropertyFiles(
	 * setUpData,"RegressionTestCases")); reports.setSystemInfo("Testing Scope",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope")); }
	 * 
	 * else if(WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope").equals(
	 * "UserStories")) {
	 * htmlReporter.config().setReportName(WebUtilityKeys.readPropertyFiles(
	 * setUpData,"FunctionalName")); reports.setSystemInfo("No. Of Test cases",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"FuctionalTestcases"));
	 * reports.setSystemInfo("Testing Scope",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"TestingScope")); }
	 * 
	 * 
	 * reports.setSystemInfo("UserName",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"UserName"));
	 * reports.setSystemInfo("OS",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"OS"));
	 * reports.setSystemInfo("Environment",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"Environment"));
	 * reports.setSystemInfo("Device",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"Device"));
	 * 
	 * // reports.setSystemInfo("BrowserName",
	 * WebUtilityKeys.readPropertyFiles(setUpData,"Browser"));
	 * reports.setReportUsesManualConfiguration(false);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //GRID all Browser parallel Execution
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //GRID
	 * 
	 * @Parameters({"portNo"})
	 * 
	 * @BeforeTest public void preconditionSetGrid(String PortNumber) throws
	 * Exception {
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * if(PortNumber.equalsIgnoreCase("44506")) {
	 * 
	 * 
	 * 
	 * System.out.print("Chrome Browser Test Environment");
	 * 
	 * DesiredCapabilities dc=new DesiredCapabilities();
	 * dc.setBrowserName("chrome"); dc.setPlatform(Platform.WINDOWS);
	 * 
	 * 
	 * 
	 * URL u1=new URL(WebUtilityKeys.readPropertyFiles(setUpData,"ChromeNodeURL"));
	 * 
	 * RemoteWebDriver driver=new RemoteWebDriver(u1,dc);
	 * 
	 * DriverFactory.getInstance().setDriver(driver);
	 * 
	 * driver=DriverFactory.getInstance().getWebDriverinstance();
	 * 
	 * 
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * 
	 * 
	 * driver.navigate().to(WebUtilityKeys.readPropertyFiles(setUpData,
	 * "ApplicationUrl"));
	 * 
	 * 
	 * driver.findElement(By.name(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "ENTERUSERNAME"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"sso")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LoginButton1"))).click();
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "PASSWORD"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"password")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LOGINBUTTON"))).click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * else if (PortNumber.equalsIgnoreCase("5555")) {
	 * 
	 * System.out.print("Firefox Browser Test Environment");
	 * 
	 * DesiredCapabilities dc=new DesiredCapabilities();
	 * dc.setBrowserName("firefox"); dc.setPlatform(Platform.WINDOWS);
	 * 
	 * FirefoxOptions options = new FirefoxOptions();
	 * 
	 * 
	 * 
	 * URL u1=new URL(WebUtilityKeys.readPropertyFiles(setUpData,"FirefoxNodeURL"));
	 * 
	 * RemoteWebDriver driver=new RemoteWebDriver(u1,dc);
	 * 
	 * DriverFactory.getInstance().setDriver(driver);
	 * 
	 * driver=DriverFactory.getInstance().getWebDriverinstance();
	 * 
	 * 
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * 
	 * driver.navigate().to(WebUtilityKeys.readPropertyFiles(setUpData,
	 * "ApplicationUrl"));
	 * 
	 * 
	 * driver.findElement(By.name(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "ENTERUSERNAME"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"sso")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LoginButton1"))).click();
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "PASSWORD"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"password")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LOGINBUTTON"))).click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * else if(PortNumber.equalsIgnoreCase("5556")) {
	 * 
	 * System.out.print("Edge Browser Test Environment");
	 * 
	 * DesiredCapabilities dc=new DesiredCapabilities();
	 * dc.setBrowserName("MicrosoftEdge"); dc.setPlatform(Platform.WINDOWS);
	 * 
	 * 
	 * EdgeOptions options = new EdgeOptions();
	 * 
	 * 
	 * URL u1=new URL(WebUtilityKeys.readPropertyFiles(setUpData,"EdgeNodeURL"));
	 * 
	 * RemoteWebDriver driver=new RemoteWebDriver(u1,dc);
	 * 
	 * DriverFactory.getInstance().setDriver(driver);
	 * 
	 * driver=DriverFactory.getInstance().getWebDriverinstance();
	 * 
	 * 
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * 
	 * 
	 * 
	 * driver.navigate().to(WebUtilityKeys.readPropertyFiles(setUpData,
	 * "ApplicationUrl"));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * driver.findElement(By.name(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "ENTERUSERNAME"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"sso")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LoginButton1"))).click();
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "PASSWORD"))).sendKeys(WebUtilityKeys.readPropertyFiles(setUpData,"password")
	 * );
	 * 
	 * 
	 * 
	 * driver.findElement(By.id(WebUtilityKeys.readPropertyFiles(objectRepo,
	 * "LOGINBUTTON"))).click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * catch (MalformedURLException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * @AfterMethod public void PostConditionTestStatus(ITestResult result) throws
	 * Exception {
	 * 
	 * ITestNGMethod m=result.getMethod(); String name=m.getMethodName();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(result.getStatus() == ITestResult.SUCCESS) {
	 * 
	 * DriverFactory.getTest().log(Status.PASS,name);
	 * 
	 * DriverFactory.setTestcategory(mainTest);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * AdminBaseControl.assignTestCategories(result.getTestClass().getRealClass().
	 * getName().substring(14));
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * else if(result.getStatus()==ITestResult.FAILURE) {
	 * 
	 * AdminBaseControl.assignTestCategories(result.getTestClass().getRealClass().
	 * getName().substring(14));
	 * 
	 * 
	 * try {
	 * 
	 * String
	 * screenshot=WebUtilityKeys.generatescreenshot(this.getWebDriver(),name);
	 * DriverFactory.getTest().log(Status.FAIL,name,MediaEntityBuilder.
	 * createScreenCaptureFromPath(screenshot).build()); }
	 * 
	 * 
	 * 
	 * catch (Exception e) {
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * else if(result.getStatus()==ITestResult.SKIP) {
	 * 
	 * AdminBaseControl.assignTestCategories(result.getTestClass().getRealClass().
	 * getName().substring(14));
	 * 
	 * 
	 * 
	 * secondTest.log(Status.SKIP,name);
	 * 
	 * secondTest.log(Status.SKIP, result.getThrowable());
	 * 
	 * 
	 * }
	 * 
	 * reports.flush();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @AfterClass public void addToReport() { reports.flush();
	 * 
	 * }
	 * 
	 * //GRID
	 * 
	 * @AfterTest public void closeDriver() {
	 * DriverFactory.getInstance().removeDriver(); }
	 * 
	 * //For Grid Local Execution Ending
	 * 
	 * 
	 */
    

    



}
