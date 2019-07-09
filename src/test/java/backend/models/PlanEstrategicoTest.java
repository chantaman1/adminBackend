package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PlanEstrategicoTest {

    LocalDate date = LocalDate.now();
    PlanEstrategico estrategico;
    @Before
    public void testing(){
        estrategico =  new PlanEstrategico("Nombre", "Descripcion", date);
        estrategico.set_id("123");
    }

    @Test
    public void get_id() {
        Assert.assertEquals("123", estrategico.get_id());
    }

    @Test
    public void set_id() {
        estrategico.set_id("Test");
        Assert.assertEquals("Test", estrategico.get_id());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Nombre", estrategico.getName());
    }

    @Test
    public void setVision() {
        estrategico.setName("Test");
        Assert.assertEquals("Test", estrategico.getName());
    }

    @Test
    public void getMision() {
        Assert.assertEquals("Descripcion", estrategico.getDescription());
    }

    @Test
    public void setMision() {
        estrategico.setDescription("Test");
        Assert.assertEquals("Test", estrategico.getDescription());
    }

    @Test
    public void getCreatedAt() {
        Assert.assertEquals(date, estrategico.getCreatedAt());
    }

    @Test
    public void setCreatedAt() {
        LocalDate newDate = LocalDate.now();
        estrategico.setCreatedAt(newDate);
        Assert.assertEquals(newDate, estrategico.getCreatedAt());
    }
}
