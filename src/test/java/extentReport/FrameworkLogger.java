package extentReport;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.function.Consumer;

public class FrameworkLogger {

    static ExtentTest extentTest;

    public  static final  Consumer<String> PASS=($)->ExtentReport.getExtentTest ().pass ( $ );
    public   static final  Consumer<String> FAIL=($)->ExtentReport.getExtentTest ().fail ( $ );
    public   static final  Consumer<String> SKIP=($)->ExtentReport.getExtentTest ().skip ( $ );
    public  static final  Consumer<String> INFO=($)->ExtentReport.getExtentTest ().info ( $ );
    public   static final Consumer<String> CONSOLE=($)-> System.out.println ("INFO---->"+$);

    public static void log(Consumer status,String message){
        status.accept ( message );
    }






}
