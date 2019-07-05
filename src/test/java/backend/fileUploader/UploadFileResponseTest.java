package backend.fileUploader;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UploadFileResponseTest {

    private UploadFileResponse ufr = new UploadFileResponse("TestFN",
                                                        "TestFDL",
                                                            "TestFT", 1);

    @Test
    public void getFileNameTest() {
        Assert.assertEquals(ufr.getFileName(), "TestFN");
    }

    @Test
    public void setFileNameTest() {
        ufr.setFileName("Cambio filename");
        Assert.assertNotEquals(ufr.getFileName(), "TestFN");
    }

    @Test
    public void getFileDownloadUriTest() {
        Assert.assertEquals(ufr.getFileDownloadUri(), "TestFDL");
    }

    @Test
    public void setFileDownloadUriTest() {
        ufr.setFileDownloadUri("Cambio filedownloaduri");
        Assert.assertNotEquals(ufr.getFileDownloadUri(), "TestFDL");
    }

    @Test
    public void getFileType() {
        Assert.assertEquals(ufr.getFileType(), "TestFT");
    }

    @Test
    public void setFileType() {
        ufr.setFileType("Cambio Filetype");
        Assert.assertNotEquals(ufr.getFileType(), "TestFT");
    }

    @Test
    public void getSize() {
        Assert.assertEquals(ufr.getSize(), 1);
    }

    @Test
    public void setSize() {
        ufr.setSize(42);
        Assert.assertNotEquals(ufr.getSize(), 1);
    }
}