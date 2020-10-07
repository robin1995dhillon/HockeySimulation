package dhl;

import dhl.InOut.JSONReader;
import dhl.LeagueModel.League;
import org.json.simple.JSONObject;

import java.io.*;
//import org.json.simple.JSONObject;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        JSONObject Object = JSONReader.readJSON("src/Data.json");
        System.out.println(Object);
        JSONObject JSONValidator = dhl.InOut.JSONValidator.JSONValidator.mainValidator(Object);
        System.out.println(JSONValidator);
        Object Conf_Object = Object.get("conferences");
        System.out.println(Conf_Object.getClass());

    }
}
