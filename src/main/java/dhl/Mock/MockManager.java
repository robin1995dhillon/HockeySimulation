package dhl.Mock;

import java.util.ArrayList;
import java.util.List;

public class MockManager {

    public static ArrayList<String> createMock() {
        ArrayList<String> generalManagerArray = new ArrayList<>();
        generalManagerArray.add("Manager1");
        generalManagerArray.add("Manager2");
        generalManagerArray.add("Manager3");
        return generalManagerArray;
    }
}
