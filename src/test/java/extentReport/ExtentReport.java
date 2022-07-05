package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class ExtentReport {


    /**
     * Created By @Umesh Joshi
     **/

    ExtentReports extentReports;
    public static ExtentTest extentTest;

    /*
    Creating Extent Report  using extentSparkReporter Class
    Extent Report theme,format is define in ExtentReport.xml and here loading the Xml config

     */
    public ExtentReport () {
        extentReports = new ExtentReports ();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter ( System.getProperty ( "user.dir" ) + ".\\ExtentReport" );
        extentReports.attachReporter ( extentSparkReporter );
        try {
            extentSparkReporter.loadXMLConfig ( "ExtentReport.xml" );
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    /**
     * Creates a test in Extent Report
     */
    public ExtentTest createTest (ITestResult result) {
        extentTest = extentReports.createTest ( result.getName () );
        return extentTest;

    }

    public void loggingInReport (Status status, Markup markup){
        extentTest.log (status,markup);

    }

    public void flushReport () {
        extentReports.flush ();

    }





}

