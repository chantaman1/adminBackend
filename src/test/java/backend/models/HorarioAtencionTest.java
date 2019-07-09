package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class HorarioAtencionTest {

    LocalDate date;
    HorarioAtencion horarioAtencion;

    @Before
    public void testing(){
        horarioAtencion = new HorarioAtencion("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", date);
        date = LocalDate.now();
        horarioAtencion.set_id("123");
    }

    @Test
    public void get_id() {
        Assert.assertEquals("123", horarioAtencion.get_id());
    }

    @Test
    public void set_id() {
        horarioAtencion.set_id("Id Test");
        Assert.assertEquals("Id Test", horarioAtencion.get_id());
    }

    @Test
    public void getMonday() {
        Assert.assertEquals("Lunes", horarioAtencion.getMonday());
    }

    @Test
    public void setMonday() {
        horarioAtencion.setMonday("Lunes Test");
        Assert.assertEquals("Lunes Test", horarioAtencion.getMonday());
    }

    @Test
    public void getTuesday() {
        Assert.assertEquals("Martes", horarioAtencion.getTuesday());
    }

    @Test
    public void setTuesday() {
        horarioAtencion.setTuesday("Martes Test");
        Assert.assertEquals("Martes Test", horarioAtencion.getTuesday());
    }

    @Test
    public void getWednesday() {
        Assert.assertEquals("Miercoles", horarioAtencion.getWednesday());
    }

    @Test
    public void setWednesday() {
        horarioAtencion.setWednesday("Miercoles Test");
        Assert.assertEquals("Miercoles Test", horarioAtencion.getWednesday());
    }

    @Test
    public void getThursday() { ;
        Assert.assertEquals("Jueves", horarioAtencion.getThursday());
    }

    @Test
    public void setThursday() {
        horarioAtencion.setThursday("Jueves Test");
        Assert.assertEquals("Jueves Test", horarioAtencion.getThursday());
    }

    @Test
    public void getFriday() {
        Assert.assertEquals("Viernes", horarioAtencion.getFriday());
    }

    @Test
    public void setFriday() {
        horarioAtencion.setFriday("Viernes Test");
        Assert.assertEquals("Viernes Test", horarioAtencion.getFriday());
    }

    @Test
    public void getSaturday() {
        Assert.assertEquals("Sabado", horarioAtencion.getSaturday());
    }

    @Test
    public void setSaturday() {
        horarioAtencion.setSaturday("Sabado Test");
        Assert.assertEquals("Sabado Test", horarioAtencion.getSaturday());
    }

    @Test
    public void getSunday() {
        Assert.assertEquals("Domingo", horarioAtencion.getSunday());
    }

    @Test
    public void setSunday() {
        horarioAtencion.setSunday("Domingo Test");
        Assert.assertEquals("Domingo Test", horarioAtencion.getSunday());
    }

    @Test
    public void getCreatedAt() {
        Assert.assertEquals(date, horarioAtencion.getCreatedAt());
    }

    @Test
    public void setCreatedAt() {
        LocalDate dateTest = LocalDate.now();
        horarioAtencion.setCreatedAt(dateTest);
        Assert.assertEquals(dateTest, horarioAtencion.getCreatedAt());
    }
}
