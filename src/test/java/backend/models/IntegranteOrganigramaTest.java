package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegranteOrganigramaTest {

    IntegranteOrganigrama organigrama;

    @Before
    public void testing(){
        organigrama = new IntegranteOrganigrama("FirstName", "LastName", "Url", "position", 1, 3);
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
    public void getFirstName() {
        Assert.assertEquals("FirstName", organigrama.getFirstName());
    }

    @Test
    public void setFirstName() {
        organigrama.setFirstName("Test");
        Assert.assertEquals("Test", organigrama.getFirstName());
    }

    @Test
    public void getLastName() {
        Assert.assertEquals("LastName", organigrama.getLastName());
    }

    @Test
    public void setLastName() {
        organigrama.setLastName("Test");
        Assert.assertEquals("Test", organigrama.getLastName());
    }

    @Test
    public void getPhotoUrl() {
        Assert.assertEquals("Url", organigrama.getPhotoUrl());
    }

    @Test
    public void setPhotoUrl() {
        organigrama.setPhotoUrl("www.test.cl");
        Assert.assertEquals("www.test.cl", organigrama.getPhotoUrl());
    }

    @Test
    public void getPosition() {
        Assert.assertEquals("position", organigrama.getPosition());
    }

    @Test
    public void setPosition() {
        organigrama.setPosition("Test");
        Assert.assertEquals("Test", organigrama.getPosition());
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

    @Test
    public void getChild() {
        Assert.assertEquals(3, organigrama.getChild());
    }

    @Test
    public void setChild() {
        organigrama.setChild(123);
        Assert.assertEquals(123, organigrama.getChild());
    }
}
