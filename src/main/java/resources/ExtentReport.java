package resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReport {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		//set the configuration under this method
		//set the extent report dependencies
		
		String path= System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reported = new ExtentSparkReporter(path);
		reported.config().setReportName("WebAutomation Results");
		reported.config().setDocumentTitle("Test Result");
	
		
		 extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reported);
		extent.setSystemInfo("Tester", "Shalini");
		return extent;
		
	}

}
