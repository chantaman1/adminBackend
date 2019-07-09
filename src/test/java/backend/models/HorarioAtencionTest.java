package backend.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class HorarioAtencionTest {

    LocalDate date = LocalDate.now();
    HorarioAtencion horarioAtencion = new HorarioAtencion("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", date);

    @Test
    public void get_id() {
        horarioAtencion.set_id("123");
        String id = horarioAtencion.get_id();
        Assert.assertEquals("123", id);
    }

    @Test
    public void set_id() {
        horarioAtencion.set_id("Id Test");
        Assert.assertEquals("Id Test", horarioAtencion.get_id());
    }

    @Test
    public void getMonday() {
        String monday = horarioAtencion.getMonday();
        Assert.assertEquals("Lunes", monday);
    }

    @Test
    public void setMonday() {
        horarioAtencion.setMonday("Lunes Test");
        Assert.assertEquals("Lunes Test", horarioAtencion.getMonday());
    }

    @Test
    public void getTuesday() {
        String tuesday = horarioAtencion.getTuesday();
        Assert.assertEquals("Martes", tuesday);
    }

    @Test
    public void setTuesday() {
        horarioAtencion.setTuesday("Martes Test");
        Assert.assertEquals("Martes Test", horarioAtencion.getTuesday());
    }

    @Test
    public void getWednesday() {
        String wednesday = horarioAtencion.getWednesday();
        Assert.assertEquals("Miercoles", wednesday);
    }

    @Test
    public void setWednesday() {
        horarioAtencion.setWednesday("Miercoles Test");
        Assert.assertEquals("Miercoles Test", horarioAtencion.getWednesday());
    }

    @Test
    public void getThursday() {
        String thursday = horarioAtencion.getThursday();
        Assert.assertEquals("Jueves", thursday);
    }

    @Test
    public void setThursday() {
        horarioAtencion.setThursday("Jueves Test");
        Assert.assertEquals("Jueves Test", horarioAtencion.getThursday());
    }

    @Test
    public void getFriday() {
        String friday = horarioAtencion.getFriday();
        Assert.assertEquals("Viernes", friday);
    }

    @Test
    public void setFriday() {
        horarioAtencion.setFriday("Viernes Test");
        Assert.assertEquals("Viernes Test", horarioAtencion.getFriday());
    }

    @Test
    public void getSaturday() {
        String saturday = horarioAtencion.getSaturday();
        Assert.assertEquals("Sabado", saturday);
    }

    @Test
    public void setSaturday() {
        horarioAtencion.setSaturday("Sabado Test");
        Assert.assertEquals("Sabado Test", horarioAtencion.getSaturday());
    }

    @Test
    public void getSunday() {
        String sunday = horarioAtencion.getSunday();
        Assert.assertEquals("Domingo", sunday);
    }

    @Test
    public void setSunday() {
        horarioAtencion.setSunday("Domingo Test");
        Assert.assertEquals("Domingo Test", horarioAtencion.getSunday());
    }

    @Test
    public void getCreatedAt() {
        LocalDate dateTest = horarioAtencion.getCreatedAt();
        Assert.assertEquals(dateTest, horarioAtencion.getCreatedAt());
    }

    @Test
    public void setCreatedAt() {
        LocalDate dateTest = LocalDate.now();
        horarioAtencion.setCreatedAt(dateTest);
        Assert.assertEquals(dateTest, horarioAtencion.getCreatedAt());
    }
}
