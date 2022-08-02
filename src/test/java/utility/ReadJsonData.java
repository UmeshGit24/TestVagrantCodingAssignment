package utility;

import constant.FrameworkConstant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class ReadJsonData {

    JSONParser jsonParser = new JSONParser();
    JSONArray playersList;


    public JSONArray getJsonArray () {
        try {
            Object obj = jsonParser.parse(new FileReader(FrameworkConstant.getJsonFilePath ()));
            JSONObject jsonObject = (JSONObject) obj;
            playersList = (JSONArray) jsonObject.get ( "player" );

        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        }
        return playersList;

    }
}
