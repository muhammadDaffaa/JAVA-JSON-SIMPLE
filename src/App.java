import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {

    static JSONObject newData, petrolStation, jsonObject;
    static JSONParser parser;

    public static void main(String[] args) throws Exception {
        parser = new JSONParser();

        try {
            Object data1 = parser
                    .parse(new FileReader("C:/Users/daffa/Desktop/java-test-program/src/tempChoiceData.json"));

            tempChoiceDataJSON(data1);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    static void tempChoiceDataJSON(Object newJson) {

        // Array of Json, output should be {"No":2,"Petrol
        jsonObject = (JSONObject) newJson;
        System.out.println("Result of JsonObject : " + newJson);
        System.out.print("\n");

        // Array of Json, output should be {"No":2,"Petrol
        // Type":{"Super":"super_price","V Power":"vpower_price"},"Petrol Name":"Shell"}
        JSONArray jsonArrayPetrolStation = (JSONArray) jsonObject.get("Petrol Station");
        System.out.println("jsonArrayPetrolStation : " + jsonArrayPetrolStation.get(1));
        System.out.print("\n");

        // Output should be " {"No":2,"Petrol Type":{"Super":"super_price","V
        // Power":"vpower_price"},"Petrol Name":"Shell"} "
        petrolStation = (JSONObject) jsonArrayPetrolStation.get(1);
        System.out.println("petrolStation : " + petrolStation);
        System.out.print("\n");

        // Output should be " {"Super":"super_price","V Power":"vpower_price"} "
        JSONObject newJSONPetrol = (JSONObject) petrolStation.get("Petrol Type");
        System.out.println("newJSONPetrol : " + newJSONPetrol);
        System.out.print("\n");

        // Output should be "super_price"
        String newString = (String) newJSONPetrol.get("Super");
        System.out.println("newString : " + newString);
        System.out.print("\n");
    }

}
