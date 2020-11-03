package dhl.InOut;

import dhl.inputOutput.JSONReader;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JSONReaderTest {

    @Test
    void readJSON() {
        JSONObject jsonObject = JSONReader.readJSON("src/Data.json");
        assertTrue(jsonObject instanceof JSONObject);
    }
}
