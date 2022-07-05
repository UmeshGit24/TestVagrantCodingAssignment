package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class ReadJsonData {

    JSONParser jsonParser = new JSONParser();
    JSONArray playersList;


    public JSONArray getJsonArray () {
        try {
            FileReader fileReader = new FileReader("D:\\restAssuredClone\\TestVagrantCodingAssignment\\src\\test\\resources\\test_data\\matchData.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            playersList = (JSONArray) jsonObject.get("player");


        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        }
        return playersList;

    }
}
