package backend.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntradaDiccionarioTest {

    public EntradaDiccionario entradaDiccionario = new EntradaDiccionario("Descripcion Test", 123, "BPMN", "Matriz");

    @Test
    public void get_id() {
        entradaDiccionario.set_id("123");
        String id = entradaDiccionario.get_id();
        Assert.assertEquals("123", id);
    }

    @Test
    public void set_id() {
        entradaDiccionario.set_id("12345");
        Assert.assertEquals("12345", entradaDiccionario.get_id());
    }

    @Test
    public void getDescripcion() {
        String descripcion = entradaDiccionario.getDescripcion();
        Assert.assertEquals("Descripcion Test", descripcion);
    }

    @Test
    public void setDescripcion() {
        entradaDiccionario.setDescripcion("Descripcion Test2");
        Assert.assertEquals("Descripcion Test2", entradaDiccionario.descripcion);
    }

    @Test
    public void getIndentacion() {
        int identacion = entradaDiccionario.getIndentacion();
        Assert.assertEquals(123, identacion);
    }

    @Test
    public void setIndentacion() {
        entradaDiccionario.setIndentacion(101010);
        Assert.assertEquals(101010, entradaDiccionario.getIndentacion());
    }

    @Test
    public void getBpmn() {
        String bpmn = entradaDiccionario.getBpmn();
        Assert.assertEquals("BPMN", bpmn);
    }

    @Test
    public void setBpmn() {
        entradaDiccionario.setBpmn("BPMN Test");
        Assert.assertEquals("BPMN Test", entradaDiccionario.getBpmn());
    }

    @Test
    public void getMatrizRECI() {
        String matriz = entradaDiccionario.getMatrizRECI();
        Assert.assertEquals("Matriz", matriz);
    }

    @Test
    public void setMatrizRECI() {
        entradaDiccionario.setMatrizRECI("Matriz Test");
        Assert.assertEquals("Matriz Test", entradaDiccionario.getMatrizRECI());
    }
}
