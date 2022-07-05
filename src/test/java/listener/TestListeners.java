package listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import extentReport.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 Created By @Umesh Joshi
 **/


public class TestListeners implements ITestListener {

    private ExtentReport extentReport=new ExtentReport ();;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result){
        extentTest=extentReport.createTest (result);
        System.out.println("Test started : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS,"Classname"+" "+result.getTestClass());
        extentTest.log(Status.PASS,MarkupHelper.createLabel("TestCases SucessFully Passes :"+" "+result.getName(),ExtentColor.GREEN));

    }
    @Override
    public void onTestFailure(ITestResult result){
        extentTest.log(Status.FAIL,"Classname:"+" "+result.getTestClass());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Failed TestCase Name is "+" "+result.getName(), ExtentColor.RED));
        Reporter.log("Failed Test Report",true);
        extentTest.log(Status.FAIL,MarkupHelper.createLabel("TestCases Failed due to below reason",ExtentColor.RED));
        extentTest.log(Status.FAIL,result.getThrowable());

    }
    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.log(Status.SKIP,"Classname:"+" "+result.getTestClass());
        extentTest.log(Status.SKIP,"TestCases Skip"+" "+result.getName());

    }
    @Override
    public void onFinish(ITestContext context){
        System.out.println("All Test exceution fininshed "+context.getSuite().getAllMethods());
        extentReport.flushReport();
    }

}
