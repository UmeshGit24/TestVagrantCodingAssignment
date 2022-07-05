package dataValidation;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentReport.ExtentReport;
import org.json.simple.JSONArray;
import utility.ReadJsonData;

import java.util.Map;

public class DataValidation {


    private ReadJsonData readJsonData = new ReadJsonData ();
    private JSONArray playersList = readJsonData.getJsonArray ();
    private  ExtentReport extentReport=new ExtentReport ();


    private int countForiegnPlayerInTeam (JSONArray playersList) {
        int foriegnPlayerCountInTeam = 0;
        for (int i = 0; i < playersList.size (); i++) {
            Map<String, Object> map = (Map<String, Object>) playersList.get (i);
            if ( !map.get ("country").equals ("India") ) {
                foriegnPlayerCountInTeam++;

            }

        }
        return foriegnPlayerCountInTeam;

    }


    private int countWicketKeeperInTeam (JSONArray playersList) {
        int wicketKeeperCountInTeam = 0;
        for (int i = 0; i < playersList.size (); i++) {
            Map<String, Object> map = (Map<String, Object>) playersList.get (i);
            if ( map.get ("role").equals ("Wicket-keeper") ) {
                wicketKeeperCountInTeam++;

            }

        }
        return wicketKeeperCountInTeam;

    }


    public boolean verifyMaximumFourForiegnPlayerPresentInTeam () {

        int foriegnPlayerCountInTeam = countForiegnPlayerInTeam (playersList);
        if ( foriegnPlayerCountInTeam <= 4 ) {
            extentReport.loggingInReport ( Status.PASS,"Maximum four Foreign player are in team" );
            return true;
        } else {
            extentReport.loggingInReport ( Status.FAIL,"More than four Foreign player are in team" );
            return false;
        }


    }

    public boolean verifyAtmostOneWicketKeeperPresentInTeam () {
        int wicketKeeperCountInTeam = countWicketKeeperInTeam (playersList);
        if ( wicketKeeperCountInTeam >= 1 ) {
            extentReport.loggingInReport ( Status.PASS,"Wicket Keeper is present in team" );
            return true;
        } else {
            extentReport.loggingInReport ( Status.FAIL,"No Wicket keeper in team" );
            return false;
        }


    }


}
