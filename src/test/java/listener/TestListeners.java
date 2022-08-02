package listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import extentReport.ExtentReport;
import extentReport.FrameworkLogger;
import org.testng.*;

/**
 Created By @Umesh Joshi
 **/


public class TestListeners implements ITestListener,ISuiteListener {

    ExtentTest extentTest;


    @Override
    public void onStart(ITestContext iTestContext){
        ExtentReport.init ();

    }


    @Override
    public void onTestStart(ITestResult result){
        extentTest=ExtentReport.createTest (result);
        FrameworkLogger.log (FrameworkLogger.INFO,"TestCase "+result.getName ()+" started" );

    }
    @Override
    public void onTestSuccess(ITestResult result){
        FrameworkLogger.log ( FrameworkLogger.PASS,"TestCases SucessFully Passes :"+" "+result.getName());

    }
    @Override
    public void onTestFailure(ITestResult result){
        FrameworkLogger.log ( FrameworkLogger.FAIL,"Failed TestCase Name is: "+result.getName());
        Reporter.log("Failed Test Report",true);
        FrameworkLogger.log(FrameworkLogger.FAIL,result.getThrowable().toString ());

    }
    @Override
    public void onTestSkipped(ITestResult result){
        FrameworkLogger.log ( FrameworkLogger.SKIP,"TestCases Skip :"+result.getName( ));

    }
    @Override
    public void onFinish(ITestContext context){
        FrameworkLogger.log ( FrameworkLogger.CONSOLE,"All Test exceution fininshed "+context.getSuite().getAllMethods() );
        ExtentReport.flushReport();
    }

}
