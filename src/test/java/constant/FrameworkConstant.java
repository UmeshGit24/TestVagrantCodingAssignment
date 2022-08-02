package constant;

public final class FrameworkConstant {

    private FrameworkConstant(){

    }

    private  static final String CURRENT_DIRECTORY=System.getProperty ( "user.dir");
    private  static  final  String JSON_FILE_PATH=CURRENT_DIRECTORY+"\\src\\test\\resources\\test_data\\matchData.json";
    private static final String EXTENT_REPORT_FILE_PATH=CURRENT_DIRECTORY+".\\ExtentReport";
    private static  final String EXTENT_REPORT_FORMAT_CONFIG_FILE_PATH="ExtentReport.xml";


    public static String getCurrentDirectory(){
        return CURRENT_DIRECTORY;
    }

    public static String getJsonFilePath(){
        return JSON_FILE_PATH;
    }
    public static String getExtentReportFilePath(){
        return EXTENT_REPORT_FILE_PATH;
    }
    public static String getExtentReportFormatConfigFilePath(){
        return EXTENT_REPORT_FORMAT_CONFIG_FILE_PATH;
    }



}
