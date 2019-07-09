package backend.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServicioTest {

    Servicio servicio;

    @Before
    public void testing(){
        servicio = new Servicio("Nombre", "Descripcion", "Compromiso", "Tarifa");
        servicio.set_id("123");
    }

    @Test
    public void get_id() {
        assertEquals("123", servicio.get_id());
    }

    @Test
    public void set_id() {
        servicio.set_id("Test");
        assertEquals("Test", servicio.get_id());
    }

    @Test
    public void getNombre() {
        assertEquals("Nombre", servicio.getNombre());
    }

    @Test
    public void setNombre() {
        servicio.setNombre("Test");
        assertEquals("Test", servicio.getNombre());
    }

    @Test
    public void getDescripcion() {
        assertEquals("Descripcion", servicio.getDescripcion());
    }

    @Test
    public void setDescripcion() {
        servicio.setDescripcion("Test");
        assertEquals("Test", servicio.getDescripcion());
    }

    @Test
    public void getCompromiso() {
        assertEquals("Compromiso", servicio.getCompromiso());
    }

    @Test
    public void setCompromiso() {
        servicio.setCompromiso("Test");
        assertEquals("Test", servicio.getCompromiso());
    }

    @Test
    public void getTarifa() {
        assertEquals("Tarifa", servicio.getTarifa());
    }

    @Test
    public void setTarifa() {
        servicio.setTarifa("Test");
        assertEquals("Test", servicio.getTarifa());
    }
}
