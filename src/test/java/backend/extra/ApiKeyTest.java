package backend.extra;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiKeyTest {

    @Test
    public void getApi_key() {
        String stringTest = "Test 1";
        ApiKey apiKey = new ApiKey(stringTest);
        Assert.assertEquals(apiKey.getApi_key(), stringTest);
    }

    @Test
    public void setApi_key() {
        String stringTest = "Test 2";
        ApiKey apiKey = new ApiKey(stringTest);
        apiKey.setApi_key("Texto cambiado");
        Assert.assertNotEquals(apiKey.getApi_key(), stringTest);
    }
}