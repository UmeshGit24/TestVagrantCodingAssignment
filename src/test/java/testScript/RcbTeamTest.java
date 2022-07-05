package testScript;

import dataValidation.DataValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RcbTeamTest {

    private DataValidation dataValidation = new DataValidation ();

    @Test
    public void verifyTeamHavingOnlyFourForeignPlayer () {
        Assert.assertTrue (dataValidation.verifyMaximumFourForiegnPlayerPresentInTeam ());

    }

    @Test
    public void verifyAtLeastOneWicketKeeperInTeam () {
        Assert.assertTrue (dataValidation.verifyAtmostOneWicketKeeperPresentInTeam ());

    }


}
