package backend.models;

import org.junit.Assert;
import org.junit.Test;

public class ArquitecturaEmpresarialTest {

    @Test
    public void getIdTest(){
        ArquitecturaEmpresarial empresarial =  new ArquitecturaEmpresarial();
        empresarial.set_id("123");
        Assert.assertEquals("123", empresarial.get_id());
    }

    @Test
    public void getTituloTest(){
        ArquitecturaEmpresarial empresarial = new ArquitecturaEmpresarial();
        empresarial.setTitulo("Titulo Test");
        Assert.assertEquals("Titulo Test", empresarial.getTitulo());
    }

    @Test
    public void getDescripcionTest(){
        ArquitecturaEmpresarial empresarial = new ArquitecturaEmpresarial();
        empresarial.setDescripcion("Descripcion Test");
        Assert.assertEquals("Descripcion Test", empresarial.getDescripcion());
    }
}
