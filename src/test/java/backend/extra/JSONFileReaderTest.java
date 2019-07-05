package backend.extra;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JSONFileReaderTest {

    private JSONFileReader jsonFileReader = new JSONFileReader();

    @Test
    public void readEmailConfigJSONTest() {
        List<String> defaultList = new ArrayList();
        defaultList.add("noresponder.alaya@gmail.com");
        defaultList.add("alayaDigitalSolutions");
        List<String> jsonList = jsonFileReader.readEmailConfigJSON();
        Assert.assertEquals(defaultList, jsonList);
    }

    @Test
    public void readApiKeyConfigJSONTest() {
        String apiKey = jsonFileReader.readApiKeyConfigJSON();
        Assert.assertEquals(apiKey, "Z2F5X2lmX2RlY3J5cHQ");
    }
}