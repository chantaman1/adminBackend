package backend.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntradaDiccionarioTest {

    EntradaDiccionario entradaDiccionario;

    @Before
    public void testing(){
        entradaDiccionario = new EntradaDiccionario("Descripcion Test", 123, "BPMN", "Matriz");
        entradaDiccionario.set_id("123");
    }

    @Test
    public void get_id() {
        Assert.assertEquals("123", entradaDiccionario.get_id());
    }

    @Test
    public void set_id() {
        entradaDiccionario.set_id("12345");
        Assert.assertEquals("12345", entradaDiccionario.get_id());
    }

    @Test
    public void getDescripcion() {
        Assert.assertEquals("Descripcion Test", entradaDiccionario.getDescripcion());
    }

    @Test
    public void setDescripcion() {
        entradaDiccionario.setDescripcion("Descripcion Test2");
        Assert.assertEquals("Descripcion Test2", entradaDiccionario.getDescripcion());
    }

    @Test
    public void getIndentacion() {
        Assert.assertEquals(123, entradaDiccionario.getIndentacion());
    }

    @Test
    public void setIndentacion() {
        entradaDiccionario.setIndentacion(101010);
        Assert.assertEquals(101010, entradaDiccionario.getIndentacion());
    }

    @Test
    public void getBpmn() {
        Assert.assertEquals("BPMN", entradaDiccionario.getBpmn());
    }

    @Test
    public void setBpmn() {
        entradaDiccionario.setBpmn("BPMN Test");
        Assert.assertEquals("BPMN Test", entradaDiccionario.getBpmn());
    }

    @Test
    public void getMatrizRECI() {
        Assert.assertEquals("Matriz", entradaDiccionario.getMatrizRECI());
    }

    @Test
    public void setMatrizRECI() {
        entradaDiccionario.setMatrizRECI("Matriz Test");
        Assert.assertEquals("Matriz Test", entradaDiccionario.getMatrizRECI());
    }
}
