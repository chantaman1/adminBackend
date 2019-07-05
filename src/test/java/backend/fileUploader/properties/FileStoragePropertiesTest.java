package backend.fileUploader.properties;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileStoragePropertiesTest {

    @Test
    public void getUploadDirTest() {
        String test = "Test";
        FileStorageProperties fsp = new FileStorageProperties(test);
        Assert.assertEquals(fsp.getUploadDir(), test);
    }

    @Test
    public void setUploadDirTest() {
        String test = "Test 2";
        FileStorageProperties fsp = new FileStorageProperties(test);
        fsp.setUploadDir("Otra cosa");
        Assert.assertNotEquals(fsp.getUploadDir(), test);
    }
}