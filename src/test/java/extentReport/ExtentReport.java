package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constant.FrameworkConstant;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class ExtentReport {


    /**
     * Created By @Umesh Joshi
     **/

    static ExtentReports extentReports;
    public static ExtentTest extentTest;

    private ExtentReport(){


    }
    /*
    Creating Extent Report  using extentSparkReporter Class
    Extent Report theme,format is define in ExtentReport.xml and here loading the Xml config

     */
    public static void init () {
        extentReports = new ExtentReports ();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter ( FrameworkConstant.getExtentReportFilePath () );
        extentReports.attachReporter ( extentSparkReporter );
        try {
            extentSparkReporter.loadXMLConfig ( FrameworkConstant.getExtentReportFormatConfigFilePath ());
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    /**
     * Creates a test in Extent Report
     */
    public static ExtentTest createTest (ITestResult result) {
        extentTest = extentReports.createTest ( result.getName () );
        return extentTest;

    }

    public void loggingInReport (Status status, Markup markup){
        extentTest.log (status,markup);

    }

    public static void flushReport () {
        extentReports.flush ();

    }

    public static ExtentTest getExtentTest(){
       return extentTest;


    }





}

