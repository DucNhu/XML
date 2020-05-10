package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSONTest {
    public static void parseEmployeeObject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject) employee.get("employee");
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);
        String lastName = (String) employeeObject.get("LastName");
        System.out.println(lastName);
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reder = new FileReader("employees.json")) {
            Object obj = jsonParser.parse(reder);
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            employeeList.forEach(emp -> parseEmployeeObject( (JSONObject) emp));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
