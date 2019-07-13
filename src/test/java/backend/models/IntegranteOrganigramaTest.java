package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegranteOrganigramaTest {

    IntegranteOrganigrama organigrama;

    @Before
    public void testing(){
        organigrama = new IntegranteOrganigrama(1,"Test Text", "Test Title", "Email", "Test Image");
        organigrama.set_id("123");
    }

    @Test
    public void get_id() {
        Assert.assertEquals("123", organigrama.get_id());
    }

    @Test
    public void set_id() {
        organigrama.set_id("IdTest");
        Assert.assertEquals("IdTest", organigrama.get_id());
    }

    @Test
    public void getTextTest() {
        Assert.assertEquals("Test Text", organigrama.getText());
    }

    @Test
    public void setTextTest() {
        organigrama.setText("Test");
        Assert.assertEquals("Test", organigrama.getText());
    }

    @Test
    public void getTitleTest() {
        Assert.assertEquals("Test Title", organigrama.getTitle());
    }

    @Test
    public void setTitleTest() {
        organigrama.setTitle("Test");
        Assert.assertEquals("Test", organigrama.getTitle());
    }

    @Test
    public void getEmailTest() {
        Assert.assertEquals("Email", organigrama.getEmail());
    }

    @Test
    public void setEmailTest() {
        organigrama.setEmail("example@test.cl");
        Assert.assertEquals("example@test.cl", organigrama.getEmail());
    }

    @Test
    public void getImgTest() {
        Assert.assertEquals("Test Image", organigrama.getImg());
    }

    @Test
    public void setImgTest() {
        organigrama.setImg("Test");
        Assert.assertEquals("Test", organigrama.getImg());
    }

    @Test
    public void getParent() {
        Assert.assertEquals(1, organigrama.getParent());
    }

    @Test
    public void setParent() {
        organigrama.setParent(123);
        Assert.assertEquals(123, organigrama.getParent());
    }
}
